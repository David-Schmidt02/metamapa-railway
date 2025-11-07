// En tu archivo Login.jsx
import { useEffect } from 'react';
import { useKeycloak } from '@react-keycloak/web';
import {Navigate} from "react-router-dom";

const Login = () => {
    const { keycloak } = useKeycloak();

    useEffect(() => {
        // Cuando este componente se monte,
        // si no estamos autenticados, iniciamos el login.
        if (!keycloak.authenticated) {
            keycloak.login();
        }
    }, [keycloak]);

    // Opcional: si ya está autenticado, redirigir a home
    if (keycloak.authenticated) {
        return <Navigate to="/home" replace />;
    }

    // Muestra un "cargando" mientras se produce la redirección
    return <div>Redirigiendo a la página de login...</div>;
};

export default Login;