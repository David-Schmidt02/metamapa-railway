// 1. Asegúrate de importar Carousel
import React, { useState, useEffect } from 'react';
import Spinner from 'react-bootstrap/Spinner';
import Carousel from 'react-bootstrap/Carousel';
import { hechomockeado } from "./hechomockeado";

function DetailPage() {
    const [hecho, setHecho] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        setTimeout(() => {
            setHecho(hechomockeado);
            setLoading(false);
        }, 500);
    }, []);

    if (loading) {
        return (

            <div className="d-flex justify-content-center mt-5 ">
                <Spinner animation="border" role="status">
                    <span className="visually-hidden">Cargando...</span>
                </Spinner>
            </div>
        );
    }

    const carouselImageStyle = {
        height: '500px',
        objectFit: 'cover',
        borderRadius: 'var(--bs-border-radius-lg)',
        border: '1px solid var(--bs-border-color)'
    };


    return (
        <div className="container my-5">
            <div className="row">

                {/* ============================================= */}
                {/* COLUMNA IZQUIERDA: SÓLO Información */}
                {/* ============================================= */}
                <div className="col-md-7">
                    <h1 className="display-5 fw-bold">{hecho.titulo}</h1>
                    <p className="h5 text-muted mb-3">{hecho.categoria?.detalle}</p>
                    <p className="lead" style={{ whiteSpace: 'pre-line' }}>
                        {hecho.descripcion}
                    </p>

                    <hr className="my-4" />

                    <div className="mt-2">
                        <h4>Informacion adicional</h4>
                        <ul className="list-unstyled fs-5">
                            <li><strong>Ubicación:</strong> {hecho.ubicacion?.texto || `${hecho.ubicacion?.latitud}, ${hecho.ubicacion?.longitud}`}</li>
                            <li><strong>Fecha de carga:</strong> {hecho.fechaCarga}</li>
                            <li><strong>Origen:</strong> {hecho.origen}</li>
                            <li><strong>Contribuyente:</strong> {hecho.contribuyente}</li>
                        </ul>

                        <h4 className="mt-4">Etiquetas</h4>
                        <div className="d-flex flex-wrap">
                            {hecho.etiquetas?.map((tag) => (
                                <span
                                    key={tag.id}
                                    className="badge bg-secondary-subtle text-secondary-emphasis rounded-pill me-2 mb-2 p-2 fs-6"
                                >
                                {tag.descripcion}
                            </span>
                            ))}
                        </div>

                        {/* NOTA:
                      Quitamos el <hr> y la lógica del carousel de aquí.
                    */}

                    </div>
                </div>

                {/* ============================================= */}
                {/* COLUMNA DERECHA: Mapa */}
                {/* ============================================= */}
                <div className="col-md-5">
                    <h1 className="display-5 fw-bold invisible" aria-hidden="true">

                    </h1>

                    <h4 className="mt-3">Ubicacion del hecho</h4>

                    <div
                        className="ratio ratio-4x3 rounded shadow-sm"
                        style={{ overflow: 'hidden', border: '1px solid #ddd' }}
                    >
                        <iframe
                            src={`https://maps.google.com/maps?q=${hecho.ubicacion?.latitud},${hecho.ubicacion?.longitud}&z=15&output=embed`}
                            width="100%"
                            height="100%"
                            style={{ border: 0 }}
                            allowFullScreen=""
                            loading="lazy"
                            referrerPolicy="no-referrer-when-downgrade"
                            title="Ubicación del hecho"
                        ></iframe>
                    </div>
                </div>

            </div> {/* <-- FIN DE LA PRIMERA FILA (INFO + MAPA) */}


            {/* ============================================= */}
            {/* NUEVA FILA: Carousel (centrado) */}
            {/* ============================================= */}
            <hr className="my-5" /> {/* Separador que estaba antes */}

            <div className="row">
                <div className="col-12"> {/* Ocupa todo el ancho del container */}

                    {/* --- LÓGICA DE MULTIMEDIA MOVIDA AQUÍ --- */}
                    {hecho.cuerpo ? (
                        <>
                            <h2>Cuerpo</h2>
                            <div className="card p-3 mb-3">
                                <p style={{ whiteSpace: 'pre-line', margin: 0 }}>{hecho.cuerpo}</p>
                            </div>
                        </>
                    ) : (
                        hecho.contenidoMultimedia?.length > 0 && (
                            <>
                                <h2>Contenido Multimedia</h2>

                                <Carousel
                                    id="carouselHecho"
                                    className="mt-3"
                                    interval={null}
                                >
                                    {hecho.contenidoMultimedia.map((url, index) => (
                                        <Carousel.Item key={index}>
                                            <img
                                                className="d-block w-100"
                                                src={url}
                                                alt={`Multimedia ${index + 1}`}
                                                style={carouselImageStyle}
                                            />
                                        </Carousel.Item>
                                    ))}
                                </Carousel>
                            </>
                        )
                    )}
                    {/* --- FIN DE LA LÓGICA MOVIDA --- */}

                </div>
            </div>

        </div> /* <-- Fin del container */
    );
}

export default DetailPage;