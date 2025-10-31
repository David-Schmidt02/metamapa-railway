import { Card, Button, Stack, Badge } from "react-bootstrap";
import { useState } from 'react';
// Asumo que la ruta a VentanaEmergente es dos niveles arriba desde la carpeta solicitud-card
import VentanaEmergente from "../ventana-emergente/ventana-emergente.jsx";
import api from "../../../../api/api-agregador";
import './solicitud-card.css'; // Importamos el nuevo CSS

// 1. Importa los iconos
import { CheckCircle, XCircle } from 'react-bootstrap-icons';

// --- 2. RECIBIMOS LA NUEVA PROP 'vistaActual' ---
const SolicitudCard = ({
                           solicitud,
                           solicitudId,
                           solicitudEstado,
                           justificacion,
                           handleEliminarSolicitud,
                           vistaActual // <--- ¡AQUÍ ESTÁ!
                       }) => {
    const [showRechazarSolicitud, setShowRechazarSolicitud] = useState(false);
    const [showConfirmarSolicitud, setShowConfirmarSolicitud] = useState(false);

    const mostrarVentanaRechazar = () => setShowRechazarSolicitud(true);
    const mostrarVentanaConfirmar = () => setShowConfirmarSolicitud(true);

    // Tu lógica de API (sin cambios)
    const eliminarSolicitud = async () => {
        setShowRechazarSolicitud(false);
        await api.eliminarSolicitud(solicitudId);
        await handleEliminarSolicitud(solicitudId);
    };

    const confirmarSolicitudD = async () => {
        setShowConfirmarSolicitud(false);
        await api.confirmarSolicitud(solicitudId);
        await handleEliminarSolicitud(solicitudId);
    };

    const hecho = solicitud?.hecho;

    // Función para determinar el color del Badge
    const getBadgeVariant = (estado) => {
        // Hacemos la comprobación del badge insensible a mayúsculas también
        switch (estado?.toUpperCase()) {
            case 'ACEPTADA':
                return 'success';
            case 'RECHAZADA':
                return 'danger';
            case 'PENDIENTE':
            default:
                return 'warning';
        }
    };

    // Ya no necesitamos 'estadoNormalizado' para la lógica de botones

    return (
        <>
            {/* 2. Usamos 'solicitud-card' y 'shadow-sm' */}
            <Card className="solicitud-card shadow-sm">
                <Card.Body>
                    <div className="d-flex justify-content-between align-items-center">

                        {/* --- INFO (IZQUIERDA) --- */}
                        <div className="solicitud-info">
                            <div className="d-flex align-items-center mb-1">
                                <Badge
                                    pill
                                    bg={getBadgeVariant(solicitudEstado)}
                                    className="me-2 solicitud-badge"
                                >
                                    {/* Mostramos el estado real, o PENDIENTE si es nulo/vacío */}
                                    {solicitudEstado || 'PENDIENTE'}
                                </Badge>
                                <Card.Title className="solicitud-titulo mb-0">
                                    {hecho?.titulo || `Solicitud #${solicitudId}`}
                                </Card.Title>
                            </div>
                            <Card.Text className="solicitud-descripcion text-muted">
                                <strong>Justificación:</strong> {justificacion || "Sin justificación."}
                            </Card.Text>
                        </div>

                        {/* --- ACCIONES (DERECHA) --- */}
                        {/*
                          --- 3. CAMBIAMOS LA LÓGICA ---
                          Ahora los botones solo aparecen si la VISTA ACTUAL (el filtro)
                          es 'PENDIENTE'.
                        */}
                        { vistaActual === 'PENDIENTE' && (
                            <Stack direction="horizontal" gap={2} className="solicitud-acciones">
                                <Button
                                    variant="outline-success"
                                    size="sm"
                                    onClick={mostrarVentanaConfirmar}
                                    title="Aceptar solicitud"
                                >
                                    <CheckCircle size={18} />
                                    <span className="ms-2">Aceptar</span>
                                </Button>

                                <Button
                                    variant="outline-danger"
                                    size="sm"
                                    onClick={mostrarVentanaRechazar}
                                    title="Rechazar solicitud"
                                >
                                    <XCircle size={18} />
                                    <span className="ms-2">Rechazar</span>
                                </Button>
                            </Stack>
                        )}
                    </div>
                </Card.Body>
            </Card>

            {/* --- VENTANAS EMERGENTES (Tu lógica sin cambios) --- */}
            {showRechazarSolicitud && (
                <VentanaEmergente
                    mensaje="¿Estás seguro de que deseas rechazar la solicitud?"
                    onConfirm={eliminarSolicitud}
                    onCancel={() => setShowRechazarSolicitud(false)}
                />
            )}

            {showConfirmarSolicitud && (
                <VentanaEmergente
                    mensaje="¿Estás seguro de que deseas confirmar la solicitud?"
                    onConfirm={confirmarSolicitudD}
                    onCancel={() => setShowConfirmarSolicitud(false)}
                />
            )}
        </>
    );
};

export default SolicitudCard;
