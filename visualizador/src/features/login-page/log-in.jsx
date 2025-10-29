import React from 'react';
import { LoginHandler, useKeycloak } from '../../KeycloakProvider'; // Ajusta la ruta
import {Navigate} from "react-router-dom";
const Login = () => {
    const { isAuthenticated } = useKeycloak();

    // Si el usuario ya está autenticado, redirigir al home o a donde sea necesario
    if (isAuthenticated) {
        console.log("Usuario ya autenticado, redirigiendo a /home");
        return <Navigate to="/home" replace />;
    }

    // 1. Usar el LoginHandler para forzar la redirección a Keycloak
    return (
        <div>
            <h1>Iniciando Sesión...</h1>
            <p>Serás redirigido a la página de login segura.</p>

            {/* Componente que ejecuta keycloak.login() al montarse */}
            <LoginHandler redirectPath="/home" />
        </div>
    );
};

export default Login;