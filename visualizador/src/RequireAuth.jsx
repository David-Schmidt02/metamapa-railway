import { useKeycloak } from './KeycloakProvider';
import { Navigate } from 'react-router-dom';

/**
 * Componente que verifica la autenticación. Si el usuario no está autenticado,
 * lo redirige a la página de login.
 */
const RequireAuth = ({ children }) => {
    const { isAuthenticated, isInitialized } = useKeycloak();

    // Si Keycloak aún no se inicializa, no renderizamos nada (lo maneja el Provider)
    if (!isInitialized) {
        return null;
    }

    if (!isAuthenticated) {
        // Si no está autenticado, lo redirigimos a la ruta de login.
        // Esto lo llevara a tu componente <Login /> donde puedes usar LoginHandler
        return <Navigate to="/login" replace />;
    }

    // Si está autenticado, renderizamos el componente hijo solicitado
    return children;
};

export default RequireAuth;