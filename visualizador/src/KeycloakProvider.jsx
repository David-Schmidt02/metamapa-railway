import React, { createContext, useContext, useState, useEffect, useMemo } from 'react';
import Keycloak from 'keycloak-js';

// 1. Definir la Configuración de Keycloak
const keycloakConfig = {
    url: 'http://localhost:9090',
    realm: 'MetaMapa',
    clientId: 'metamapa-frontend',
};

// Crear una instancia de Keycloak
const keycloak = new Keycloak(keycloakConfig);

// 2. Crear el Contexto
const KeycloakContext = createContext({
    keycloak: keycloak,
    isAuthenticated: false,
    isInitialized: false,
    token: null,
});

// 3. Crear el Proveedor
export const KeycloakProvider = ({ children }) => {
    const [isInitialized, setIsInitialized] = useState(false);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [token, setToken] = useState(null);

    useEffect(() => {
        // Variable para almacenar el ID del temporizador
        let tokenRefreshInterval;

        keycloak.init({
            onLoad: 'check-sso',
            silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html',
            pkceMethod: 'S256',
            checkLoginIframe: false,
        })
            .then((authenticated) => {
                setIsAuthenticated(authenticated);

                if (authenticated) {
                    setToken(keycloak.token);

                    // 🐛 Solución al Memory Leak: Asignar el ID del temporizador
                    tokenRefreshInterval = setInterval(() => {
                        keycloak.updateToken(70).then((refreshed) => {
                            if (refreshed) {
                                setToken(keycloak.token);
                                console.log('Token refrescado automáticamente.');
                            }
                        }).catch(() => {
                            console.warn('Fallo al refrescar el token. Se requiere re-login.');
                            // Opcional: keycloak.login();
                        });
                    }, 60000); // Intenta refrescar cada minuto
                }
            })
            .catch((error) => {
                console.error('Fallo al inicializar Keycloak:', error);
            })
            .finally(() => {
                setIsInitialized(true);
            });

        // ✅ Función de Limpieza: Esto se ejecuta cuando el componente se desmonta.
        return () => {
            if (tokenRefreshInterval) {
                clearInterval(tokenRefreshInterval); // Detiene el temporizador
                console.log('Limpieza: Temporizador de refresco detenido.');
            }
        };

    }, []); // Empty dependency array ensures this runs only on mount and unmount

    const contextValue = {
        keycloak,
        isAuthenticated,
        isInitialized,
        token,
    };

    // Si Keycloak no ha terminado de inicializarse, muestra un cargando
    // if (!isInitialized) {
    //     return <div>Cargando autenticación...</div>;
    //     // Puedes reemplazar esto con un spinner o tu componente de carga.
    // }

    return (
        <KeycloakContext.Provider value={contextValue}>
            {children}
        </KeycloakContext.Provider>
    );
};

// 4. Custom Hook para facilitar el acceso al Contexto
export const useKeycloak = () => useContext(KeycloakContext);

// 5. Componente para manejar el Login
export const LoginHandler = ({ redirectPath = '/' }) => {
    const { keycloak, isAuthenticated } = useKeycloak();

    useEffect(() => {
        if (!isAuthenticated) {
            keycloak.login({ redirectUri: window.location.origin + redirectPath });
        }
    }, [isAuthenticated, keycloak, redirectPath]);

    return null; // Este componente solo maneja la lógica de redirección, no renderiza nada visible.
};
