import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Button, Form, NavDropdown } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useKeycloak } from '@react-keycloak/web'; // <--- 1. IMPORTAR EL HOOK

function NavBar() {
    const navigate = useNavigate();
    const { keycloak } = useKeycloak(); // <--- 2. OBTENER EL CONTEXTO DE KEYCLOAK

    return (
        <Navbar expand="lg" data-bs-theme='prueba' >
            <Container fluid >
                <Navbar.Brand href="/home">MetaMapa</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll" >
                    <Nav
                        className="ms-auto my-2 my-lg-0"
                        style={{ maxHeight: '150px' }}
                        navbarScroll
                        activeKey="/home"
                        onSelect={(selectedKey) => navigate(`${selectedKey}`)}
                    >
                        <Nav.Item>
                            <Nav.Link href="/busqueda" >Buscar</Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link href="/estadisticas" >Estadisticas</Nav.Link>
                        </Nav.Item>

                        {/* --- 3. RENDERIZADO CONDICIONAL --- */}

                        {/* Si NO está autenticado, muestra el botón de Login */}
                        {!keycloak.authenticated && (
                            <Nav.Item className='sesion'>
                                {/* Es mejor usar onClick con navigate para el routing de React */}
                                <Nav.Link onClick={() => keycloak.login()} >Iniciar Sesion</Nav.Link>
                            </Nav.Item>
                        )}

                        {/* Si SÍ está autenticado, muestra el menú de usuario */}
                        {keycloak.authenticated && (
                            <NavDropdown
                                // El nombre de usuario está en el token parseado
                                title={`Hola, ${keycloak.tokenParsed.preferred_username}`}
                                id="basic-nav-dropdown"
                            >
                                <NavDropdown.Item onClick={() => navigate('/perfil')}>
                                    Mi Perfil
                                </NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item onClick={() => keycloak.logout()}>
                                    Cerrar Sesión
                                </NavDropdown.Item>
                            </NavDropdown>
                        )}

                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default NavBar;