import React, {useEffect} from 'react';
import {Container, Row, Col, Card, Button, Spinner} from 'react-bootstrap';
import { FaLayerGroup } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import ApiAgregador from "../../api/api-agregador.jsx";

// Estilo para el ícono (reemplaza tu "Image cap")
const cardIconStyle = {
    textAlign: 'center', // Centra el ícono
    paddingTop: '1.5rem', // Espacio superior
    paddingBottom: '1rem', // Espacio inferior
    backgroundColor: '#f8f9fa', // Un fondo gris claro
    color: '#6e2a34', // Color del ícono (tu marrón/rojo)
    fontSize: '3rem' // Tamaño del ícono
};

function ColeccionesPage() {
    const navigate = useNavigate();

    const [colecciones, setColecciones] = useState([]);
    const [error, setError] = useState(null);

    // 3. Función que se llama al hacer clic en el botón
    const handleVerHechos = (coleccionId) => {
        // Navega a la ruta de los hechos de esa colección
        // (Asegúrate de tener esta ruta definida en tu Router)
        navigate(`/colecciones/${coleccionId}/hechos`);
    };

    useEffect(() => {
        const fetchColecciones = async () => {
            try {
                setError(null);

                const data = await ApiAgregador.obtenerColecciones();

                setColecciones(data);

            } catch (error) {
                setError(error);
            } finally {
            }
        }

        fetchColecciones();
    }, []);


    return (
        // Usamos el fondo verde pálido de tu imagen
        <div style={{ backgroundColor: '#f0fdf4', minHeight: '100vh', padding: '2rem 0' }}>
            <Container>
                <h1 className="text-center mb-5">Colecciones de MetaMapa</h1>

                {/* 4. Grilla responsiva. Se ajustará a 2 columnas en pantallas medianas */}
                <Row xs={1} md={2} className="g-4">
                    {colecciones.map((coleccion) => (
                        <Col key={coleccion.id}>
                            <Card className="shadow-sm h-100">
                                {/* 5. El ícono reemplaza a la imagen */}
                                <div style={cardIconStyle}>
                                    <FaLayerGroup />
                                </div>

                                <Card.Body className="d-flex flex-column">
                                    <Card.Title className="fw-bold">{coleccion.titulo}</Card.Title>
                                    <Card.Text>
                                        {coleccion.descripcion}
                                    </Card.Text>

                                    {/* 6. El botón llama a la función de navegación */}
                                    <Button
                                        variant="warning"
                                        className="mt-auto" // Empuja el botón al final de la card
                                        onClick={() => handleVerHechos(coleccion.id)}
                                    >
                                        Ver Hechos
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))}
                </Row>

                {/* Aquí iría tu componente de paginación (1, 2, 3) */}

            </Container>
        </div>
    );
}

export default ColeccionesPage;