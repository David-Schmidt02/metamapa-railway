import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import {Card} from "react-bootstrap";


const SolicitudCard = () => {


    return (
    //TARJETAS DE SOLICITUDES
    <Card  as="div"  className="contenedor-tarjeta-solicitud">
        <h1>hola </h1>
        <Container as="div" className="contenedor-botoness">
            <Button className="boton-aprobar"  variant = "success" > Aprobar</Button>
            <Button className="boton-rechazar" variant = "danger"> Rechazar</Button>
        </Container>
    </Card>
    )
}

export default SolicitudCard