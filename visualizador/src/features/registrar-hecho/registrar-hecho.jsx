import React, { useState } from 'react';
import {
    Container,
    Card,
    Form,
    Row,
    Col,
    Button,
    Tabs,
    Tab,
    Spinner
} from 'react-bootstrap';

function RegistrarHecho() {
    const [formData, setFormData] = useState({
        titulo: '',
        descripcion: '',
        categoria: '',
        latitud: '',
        longitud: '',
        fechaAcontecimiento: '',
        etiquetas: '',
        cuerpo: '',
        contenidoMultimedia: []
    });

    const [activeTab, setActiveTab] = useState('multimedia');
    const [isSubmitting, setIsSubmitting] = useState(false);

    // ... (handleChange, handleFileChange, handleSubmit, mockCategorias sin cambios) ...
    // ...
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevData => ({
            ...prevData,
            [name]: value
        }));
    };

    const handleFileChange = (e) => {
        setFormData(prevData => ({
            ...prevData,
            contenidoMultimedia: e.target.files
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (isSubmitting) return;

        setIsSubmitting(true);

        console.log("Datos del formulario:", formData);
        await new Promise(resolve => setTimeout(resolve, 2000));
        setIsSubmitting(false);
        console.log("Hecho registrado con éxito");
    };

    const mockCategorias = [
        { id: 1, nombre: 'Incendio' },
        { id: 2, nombre: 'Accidente Vial' },
        { id: 3, nombre: 'Robo' },
        { id: 4, nombre: 'Corte de Luz' }
    ];
    // ...

    return (
        <div style={{ backgroundColor: '#f8f9fa', padding: '3rem 0' }}>
            <Container>
                <Row className="justify-content-center">
                    <Col md={10} lg={8}>
                        <Card className="shadow-sm border-0" style={{ borderRadius: '1rem' }}>
                            <Card.Body className="p-4 p-md-5">
                                <h2 className="text-center fw-bold mb-4">
                                    Registrar un Hecho
                                </h2>

                                <Form onSubmit={handleSubmit}>

                                    {/* --- 1. Información Principal --- */}
                                    <h5 className="mb-3">Información Principal</h5>

                                    {/* ... (Título y Categoría sin cambios) ... */}
                                    <Row>
                                        <Col md={6}>
                                            <Form.Group className="mb-3" controlId="formTitulo">
                                                <Form.Label>Título *</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="titulo"
                                                    placeholder="Ej: Incendio en Palermo Hollywood"
                                                    value={formData.titulo}
                                                    onChange={handleChange}
                                                    required
                                                />
                                            </Form.Group>
                                        </Col>
                                    </Row>

                                    {/* Campo condicional de Descripción Breve */}
                                    {activeTab === 'cuerpo' && (
                                        <Form.Group className="mb-3" controlId="formDescripcionBreve">
                                            <Form.Label>Descripción Breve *</Form.Label>
                                            <Form.Control
                                                as="textarea"
                                                rows={2}
                                                name="descripcion"
                                                placeholder="Describa brevemente lo que sucedió..."
                                                value={formData.descripcion}
                                                onChange={handleChange}
                                                // CAMBIO 1: Hacer 'required' dinámico
                                                required={activeTab === 'cuerpo'}
                                            />
                                        </Form.Group>
                                    )}

                                    <Form.Group className="mb-3" controlId="formCategoria">
                                        <Form.Label>Categoría *</Form.Label>
                                        <Form.Select
                                            name="categoria"
                                            value={formData.categoria}
                                            onChange={handleChange}
                                            required
                                        >
                                            <option value="">Seleccione una categoría...</option>
                                            {mockCategorias.map(cat => (
                                                <option key={cat.id} value={cat.id}>{cat.nombre}</option>
                                            ))}
                                        </Form.Select>
                                    </Form.Group>

                                    <hr className="my-4" />

                                    {/* --- 2. ¿Cuándo y Dónde? --- */}
                                    <h5 className="mb-3">¿Cuándo y Dónde?</h5>
                                    {/* ... (Campos de fecha y ubicación sin cambios) ... */}
                                    <Form.Group className="mb-3" controlId="formFecha">
                                        <Form.Label>Fecha y Hora del Acontecimiento *</Form.Label>
                                        <Form.Control
                                            type="datetime-local"
                                            name="fechaAcontecimiento"
                                            value={formData.fechaAcontecimiento}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Form.Group>
                                    <Row>
                                        <Col md={6}>
                                            <Form.Group className="mb-3" controlId="formLatitud">
                                                <Form.Label>Latitud *</Form.Label>
                                                <Form.Control
                                                    type="number"
                                                    name="latitud"
                                                    placeholder="-34.5811"
                                                    value={formData.latitud}
                                                    onChange={handleChange}
                                                    required
                                                />
                                            </Form.Group>
                                        </Col>
                                        <Col md={6}>
                                            <Form.Group className="mb-3" controlId="formLongitud">
                                                <Form.Label>Longitud *</Form.Label>
                                                <Form.Control
                                                    type="number"
                                                    name="longitud"
                                                    placeholder="-58.4377"
                                                    value={formData.longitud}
                                                    onChange={handleChange}
                                                    required
                                                />
                                            </Form.Group>
                                        </Col>
                                    </Row>


                                    <hr className="my-4" />

                                    {/* --- 3. Contenido del Reporte (Tabs) --- */}
                                    <h5 className="mb-3">Contenido del Reporte</h5>

                                    <Tabs
                                        activeKey={activeTab}
                                        onSelect={(k) => setActiveTab(k)}
                                        id="reporte-tabs"
                                        className="mb-3"
                                    >
                                        <Tab eventKey="multimedia" title="Reporte con Multimedia">
                                            <Form.Group className="mb-3" controlId="formDescripcion">
                                                <Form.Label>Descripción *</Form.Label>
                                                <Form.Control
                                                    as="textarea"
                                                    rows={3}
                                                    name="descripcion"
                                                    placeholder="Describa brevemente lo que sucedió..."
                                                    value={formData.descripcion}
                                                    onChange={handleChange}
                                                    // CAMBIO 2: Hacer 'required' dinámico
                                                    required={activeTab === 'multimedia'}
                                                />
                                            </Form.Group>
                                            <Form.Group controlId="formFile" className="mb-3">
                                                <Form.Label>Imágenes o Videos</Form.Label>
                                                <Form.Control
                                                    type="file"
                                                    name="contenidoMultimedia"
                                                    onChange={handleFileChange}
                                                    multiple
                                                />
                                            </Form.Group>
                                        </Tab>

                                        <Tab eventKey="cuerpo" title="Reporte de solo Texto (Cuerpo)">
                                            <Form.Group className="mb-3" controlId="formCuerpo">
                                                <Form.Label>Cuerpo del Reporte *</Form.Label>
                                                <Form.Control
                                                    as="textarea"
                                                    rows={8}
                                                    name="cuerpo"
                                                    placeholder="Escriba aquí el reporte detallado..."
                                                    value={formData.cuerpo}
                                                    onChange={handleChange}
                                                    // CAMBIO 3: Hacer 'required' dinámico
                                                    required={activeTab === 'cuerpo'}
                                                />
                                            </Form.Group>
                                        </Tab>

                                    </Tabs>

                                    <hr className="my-4" />

                                    {/* --- 4. Detalles Adicionales --- */}
                                    <h5 className="mb-3">Detalles Adicionales</h5>
                                    {/* ... (Campo de etiquetas sin cambios) ... */}
                                    <Form.Group className="mb-3" controlId="formEtiquetas">
                                        <Form.Label>Etiquetas</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="etiquetas"
                                            placeholder="incendio, bomberos, palermo"
                                            value={formData.etiquetas}
                                            onChange={handleChange}
                                        />
                                        <Form.Text className="text-muted">
                                            Separar etiquetas con comas.
                                        </Form.Text>
                                    </Form.Group>

                                    {/* --- 5. Botón de Envío --- */}
                                    <div className="d-grid mt-5">
                                        {/* ... (Lógica del botón sin cambios) ... */}
                                        <Button
                                            variant="warning"
                                            type="submit"
                                            size="lg"
                                            disabled={isSubmitting}
                                        >
                                            {isSubmitting ? (
                                                <>
                                                    <Spinner
                                                        as="span"
                                                        animation="border"
                                                        size="sm"
                                                        role="status"
                                                        aria-hidden="true"
                                                    />
                                                    <span className="ms-2">Registrando...</span>
                                                </>
                                            ) : (
                                                "Registrar Hecho"
                                            )}
                                        </Button>
                                    </div>

                                </Form>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}

export default RegistrarHecho;