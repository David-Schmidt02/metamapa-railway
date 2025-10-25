// visualizador/src/features/home-page/components/mapa.jsx
import {Card} from "react-bootstrap";
import React from "react";

//TODO: Reemplazar el mapa de google con uno que permita agregar marcadores
const Mapa = () => (
    <Card className="shadow-lg" style={{ marginTop: '50px', marginBottom: '50px' }}>
        <Card.Body style={{ padding: '0px' }}>
            <h4 className="text-center pt-3 pb-3 mb-0">Mapa de hechos registrados</h4>
            <div style={{ height: '450px', width: '100%' }}>
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d210146.6827477399!2d-58.5733847849977!3d-34.61574369999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcca3b4ef90cbd%3A0xa0b3812e88e88e87!2sBuenos%20Aires%2C%20CABA!5e0!3m2!1ses-419!2sar!4v1685126459021!5m2!1ses-419!2sar"
                    width="100%"
                    height="100%"
                    style={{ border: 0 }}
                    allowFullScreen=""
                    loading="lazy"
                    referrerPolicy="no-referrer-when-downgrade"
                    title="Google Maps Embed"
                ></iframe>
            </div>
        </Card.Body>
    </Card>
);

export default Mapa;