import React from 'react';
import './hecho-card.css';
import { Link } from 'react-router-dom';

// 1. Recibe la prop 'coleccion' que pasamos desde ColeccionHechosPage
export default function HechoCard({ hecho, coleccion }) {
    return (
        // 2. Envuelve TODA la tarjeta en el Link
        <Link
            // 1. 'to' ahora es solo un string con la URL
            to={`/hecho/${hecho.id}`}

            // 2. 'state' se pasa como una prop aparte
            state={{
                coleccionId: coleccion?.id,
                coleccionNombre: coleccion?.titulo
            }}

            className="hecho-card-link-wrapper"
        >


            {/* Tu código de la tarjeta va aquí dentro.
        El <div> exterior original se elimina porque el <Link>
        ya cumple esa función de "contenedor".
      */}
            <div className="hecho-card">
                {hecho.imagen && (
                    <div className="hecho-card-img-box">
                        <img src={hecho.imagen} alt={hecho.titulo} className="hecho-card-img" />
                    </div>
                )}
                <div style={{ flex: 1 }}>
                    <div className="hecho-card-title-row">

                        {/* 3. El título ya no necesita ser un Link,
                 porque la card entera lo es.
                 Lo convertimos a un <span> (o <div>) */}
                        <span className="hecho-card-title">
              {hecho.titulo}
            </span>

                        <div style={{ display: 'flex', alignItems: 'center', gap: 16 }}>
                            {hecho.contribuyente && (
                                <span className="hecho-card-autor">
                por {hecho.contribuyente.contribuyente_nombre || 'Anónimo'}
              </span>
                            )}
                            {hecho.consenso && (
                                <span className="hecho-card-consenso">
                <svg width="18" height="18" viewBox="0 0 20 20" fill="none" style={{ verticalAlign: 'middle' }}><path d="M7.5 13.5L4 10L5.41 8.59L7.5 10.67L14.59 3.59L16 5L7.5 13.5Z" fill="#7d4f1e"/></svg>
                Consensuado
              </span>
                            )}
                        </div>
                    </div>
                    <div className="hecho-card-desc">{hecho.descripcion}</div>
                    <div className="hecho-card-chips">
                        {hecho.categoria && (
                            <span className="hecho-card-chip-categoria">{hecho.categoria.detalle}</span>
                        )}
                        {hecho.ubicacion.latitud && (
                            <span className="hecho-card-chip-ubicacion">{hecho.ubicacion.latitud}</span>
                        )}
                        {hecho.ubicacion.longitud && (
                            <span className="hecho-card-chip-ubicacion">{hecho.ubicacion.longitud}</span>
                        )}
                    </div>
                </div>
            </div>
        </Link>
    );
}