// RequireAdmin.jsx
import { useKeycloak } from "@react-keycloak/web";
import {Navigate, Outlet, useLocation} from "react-router-dom";

const RequireAdmin = ({ children }) => {
    const { keycloak, initialized } = useKeycloak();
    const location = useLocation();

    // 1. Espera a que Keycloak esté inicializado
    if (!initialized) {
        return <div>Cargando...</div>; // O un spinner
    }

    // 2. Comprueba si está autenticado Y si tiene el rol 'admin'
    const hasAdminRole = keycloak.authenticated && keycloak.hasRealmRole("admin");

    if (!hasAdminRole) {
        // Si está autenticado pero NO es admin, lo mandamos al home (no tiene nada que hacer aquí)
        if (keycloak.authenticated) {
            return <Navigate to="/home" state={{ from: location }} replace />;
        }

        // Si no está ni autenticado, lo mandamos a loguearse
        // (Aunque keycloak-js suele manejar esto automáticamente)
        return <Navigate to="/" state={{ from: location }} replace />;
    }

    // 3. Si es admin, renderiza la página solicitada
    return <Outlet />; // O {children} si no usas <Route element=... >
};

export default RequireAdmin;