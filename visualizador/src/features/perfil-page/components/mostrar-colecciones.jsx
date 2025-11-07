import ColeccionCard from './coleccion-card/coleccion-card'
import { useEffect, useState } from 'react'
import api from "../../../api/api-agregador";
import './coleccion-card/coleccion-card.css'
import { Collection } from 'react-bootstrap-icons';

const MostrarColecciones = () => {
    const [colecciones, setColecciones] = useState([])
    const [loading, setLoading] = useState(true)

    const fetchColecciones = async () => {
        try {
            const response = await api.obtenerColecciones()
            setColecciones(response)
            // console.log('colecciones:', response) // <--- CORRECCIÓN: Usa 'response' aquí
        } catch (error) {
            console.log(error.message)
        } finally {
            setLoading(false)
        }
    }

    useEffect(() => {
        fetchColecciones()
    }, [])


    // --- 👇 FUNCIÓN NUEVA ---
    // Se llama desde el hijo (ColeccionCard) después de que la API actualiza
    const handleActualizarColeccionLocal = (coleccionId, datosNuevos) => {
        // datosNuevos = { algoritmo: "...", fuentesSeleccionadas: ["...", "..."] }

        // Mapeamos las URLs a la estructura de objeto que espera tu estado
        const nuevasFuentes = datosNuevos.fuentesSeleccionadas.map(url => {
            // Asumo la estructura basado en el useEffect de tu VentanaConfiguracion
            // Ajusta "url_fuente" si la propiedad es otra (ej: "url")
            return { url_fuente: url };
        });

        setColecciones(coleccionesActuales =>
            coleccionesActuales.map(col => {
                // Si encontramos la colección, la reemplazamos con la nueva data
                if (col.id === coleccionId) {
                    return {
                        ...col,
                        algoritmo_consenso: datosNuevos.algoritmo,
                        // Actualizamos también el string 'algoritmo' para la UI
                        algoritmo: datosNuevos.algoritmo ? datosNuevos.algoritmo.replace('_', ' ') : null,
                        fuentes: nuevasFuentes
                    };
                }
                // Si no es, la devolvemos como estaba
                return col;
            })
        );
    };

    // --- 👇 FUNCIÓN NUEVA (Mejorada) ---
    // Se llama desde el hijo (ColeccionCard) después de que la API elimina
    const handleEliminarColeccionLocal = (id) => {
        setColecciones(coleccionesActuales =>
            coleccionesActuales.filter(col => col.id !== id)
        );
    };

    return (
        <>
            <h2>Colecciones</h2>
            {loading ? (
                <div>{/* <CircularIndeterminate /> */}</div>
            ) : (
                <>
                    {colecciones.length > 0 && (
                        <div className="fondo-gris">
                            {colecciones.map((result) => (
                                <ColeccionCard
                                    key={result.id}
                                    coleccion={result}
                                    coleccionId={result.id}
                                    // --- 👇 PROPS ACTUALIZADAS ---
                                    // Pasamos las *nuevas* funciones al hijo
                                    onColeccionActualizada={handleActualizarColeccionLocal}
                                    onColeccionEliminada={handleEliminarColeccionLocal}
                                />
                            ))}
                        </div>
                    )}

                    {colecciones.length === 0 && (
                        <div
                            className="text-center p-4 p-md-5 text-secondary"
                            style={{
                                backgroundColor: '#f8f9fa',
                                borderRadius: '12px',
                                marginTop: '1.5rem'
                            }}
                        >
                            <Collection size={48} className="mb-3" />
                            <h4 className="fw-normal">No hay colecciones</h4>
                            <p className="mb-0">Todavía no tenés colecciones creadas.</p>
                        </div>
                    )}
                </>
            )}
        </>
    )
}

export default MostrarColecciones