// visualizador/src/features/home-page/components/mapa.jsx
import {Card} from "react-bootstrap";
import React from "react";
import {MapContainer, TileLayer, Marker, Popup} from 'react-leaflet'
import 'leaflet/dist/leaflet.css'
import './mapa.css'
import L from 'leaflet';
/* fix para que cargue el icono, dsp poner personalizado */
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
    iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
    iconUrl: require('leaflet/dist/images/marker-icon.png'),
    shadowUrl: require('leaflet/dist/images/marker-shadow.png')
});

const posHechosMock = [
    { posicion: {lat: '-34.37049232747865', long: '-58.90407374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-34.97049232747865', long: '-59.45407374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-35.85049232747865', long: '-60.10407374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-35.97049232747865', long: '-57.90407374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-34.91049232747865', long: '-58.23407374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-33.93149232747865', long: '-60.61407374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-34.59849232747865', long: '-58.44607374255551'}, descripcion: 'Una descripcion de ejemplo' },
    { posicion: {lat: '-35.09049232747865', long: '-58.48407374255551'}, descripcion: 'Una descripcion de ejemplo' }
]

const Mapa = () => (
    <Card className="shadow-lg" style={{ marginTop: '50px', marginBottom: '50px' }}>
        <Card.Body style={{ padding: '0px' }}>
            <h4 className="text-center pt-3 pb-3 mb-0">Mapa de hechos registrados</h4>
            <div style={{ height: '450px', width: '100%' }}>
                <MapContainer
                    center={{lat: '-34.37049232747865', lng: '-58.90407374255551'}}
                    zoom={10} >
                    <TileLayer
                        url='https://tile.openstreetmap.org/{z}/{x}/{y}.png'
                        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    />
                    {posHechosMock.map(unHecho =>
                        <Marker position={{lat: unHecho.posicion.lat, lng:  unHecho.posicion.long}}> {/* icono no carga, ver esto */}
                            <Popup>unHecho.descripcion</Popup>
                        </Marker>
                    )}
                </MapContainer>
            </div>
        </Card.Body>
    </Card>
);

export default Mapa;