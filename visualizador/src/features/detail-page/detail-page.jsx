import React, {useState, useEffect} from 'react';
import Spinner from 'react-bootstrap/Spinner';

function DetailPage() {
    const [hecho, setHecho] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const hechomockeado = {
            id: 1,
            titulo: "Hecho Mockeado",
            descripcion: "Esta es una descripcion de un hecho mockeado para propósitos de prueba.",
            categoria: {
                id: 1,
                detalle: "Categoria de prueba"
            },
            ubicacion: {
                latitud: "-34.6037",
                longitud: "-58.3816"
            },
            fechaAcontecimiento: "2024-01-15T10:00:00Z",
            fechaCarga: "2024-01-16T12:00:00Z",
            origen: "Estatica",
            contribuyente: "Anonimo",
            etiquetas: [{
                id:"1",
                descripcion: "asd"
            }]
        }

        setTimeout(() => { // Simula un pequeño retraso de red
            setHecho(hechomockeado);
            setLoading(false);
        }, 500);

    }, [])

    if (loading) {
        return (
            <Spinner animation="border" role="status">
                <span className="visually-hidden">Cargando...</span>
            </Spinner>
        );
    }




    return (
        <div className="container my-5">
            <div className="row">

                {/* ============================================= */}
                {/* COLUMNA IZQUIERDA: Información del Hecho      */}
                {/* ============================================= */}
                <div className="col-md-7">

                    {/* Título y Categoría */}
                    <h1 className="display-5 fw-bold">{hecho.titulo}</h1>
                    <p className="h5 text-muted mb-3">{hecho.categoria.detalle}</p>

                    {/* Descripción */}
                    <p className="lead" style={{ whiteSpace: 'pre-line' }}>
                        {hecho.descripcion}
                    </p>

                    <hr className="my-4" />

                    {/* Información Adicional */}
                    <h4>Informacion adicional</h4>
                    <ul className="list-unstyled fs-5">
                        <li><strong>Ubicación:</strong> {hecho.ubicacion.latitud}</li>
                        <li><strong>Fecha acontecimiento:</strong> {hecho.fechaAcontecimiento}</li>
                        <li><strong>Origen:</strong> {hecho.origen}</li>
                        <li><strong>Contribuyente:</strong> {hecho.contribuyente}</li>
                    </ul>

                    {/* Etiquetas */}
                    <h4 className="mt-4">Etiquetas</h4>
                    <div className="d-flex flex-wrap">
                        {hecho.etiquetas.map((tag) => (
                            <span
                                key={tag.id} // Usamos el ID de la etiqueta como key
                                className="badge bg-secondary-subtle text-secondary-emphasis rounded-pill me-2 mb-2 p-2 fs-6"
                            >
                {tag.descripcion} {/* Mostramos la descripción */}
              </span>
                        ))}
                    </div>
                </div>

                {/* ============================================= */}
                {/* COLUMNA DERECHA: Mapa                         */}
                {/* ============================================= */}
                <div className="col-md-5">
                    <h4>Ubicacion del hecho</h4>

                    {/* Aquí debes poner tu componente de mapa (React Leaflet, Google Maps API, etc.).
            Uso un iframe de Google Maps como placeholder.
            Recuerda reemplazar TU_API_KEY por tu clave de Google Maps.
          */}
                    {/*<div*/}
                    {/*    className="ratio ratio-1x1 rounded shadow-sm"*/}
                    {/*    style={{ overflow: 'hidden', border: '1px solid #ddd' }}*/}
                    {/*>*/}
                    {/*    <iframe*/}
                    {/*        src={`https://www.google.com/maps/embed/v1/place?key=TU_API_KEY&q=${hecho.lat},${hecho.lng}&zoom=14`}*/}
                    {/*        width="100%"*/}
                    {/*        height="100%"*/}
                    {/*        style={{ border: 0 }}*/}
                    {/*        allowFullScreen=""*/}
                    {/*        loading="lazy"*/}
                    {/*        referrerPolicy="no-referrer-when-downgrade"*/}
                    {/*        title="Ubicación del hecho"*/}
                    {/*    ></iframe>*/}
                    {/*</div>*/}
                </div>

            </div>

            <hr className="my-5" />

            {/* ============================================= */}
            {/* SECCIÓN INFERIOR: Multimedia                  */}
            {/* ============================================= */}
            {/*<div className="row">*/}
            {/*    <div className="col-12">*/}
            {/*        <h2>Contenido Multimedia / Cuerpo</h2>*/}
            {/*        <img*/}
            {/*            src={hecho.multimediaUrl}*/}
            {/*            className="img-fluid rounded shadow-sm mt-3"*/}
            {/*            alt={`Multimedia sobre ${hecho.titulo}`}*/}
            {/*            style={{ width: '100%', objectFit: 'cover' }}*/}
            {/*        />*/}
            {/*    </div>*/}
            {/*</div>*/}
        </div>
        );
}


export default DetailPage;