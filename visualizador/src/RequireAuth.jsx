import { useKeycloak } from "@react-keycloak/web";
import { Navigate, Outlet, useLocation } from "react-router-dom";

const RequireAuth = () => {
    const { keycloak, initialized } = useKeycloak();
    const location = useLocation();

    // 1. Espera a que Keycloak termine de inicializarse
    if (!initialized) {
        return <div>Cargando...</div>; // O un spinner
    }

    // 2. Una vez inicializado, comprueba si está autenticado
    if (keycloak.authenticated) {
        // Si está autenticado, renderiza la ruta hija
        return <Outlet />;
    }

    // 3. Si no está autenticado, redirige al login
    // Nota: El login de Keycloak es una redirección, no una página
    // Es mejor llamar a keycloak.login() que redirigir a /login

    // Opción A: Redirigir a tu página /login (ver punto 4)
    keycloak.login();

    // Opción B (Recomendada): Iniciar el login de Keycloak directamente
    // keycloak.login();
    // return null; // No renderiza nada mientras redirige
};

export default RequireAuth;