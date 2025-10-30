import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import {Card} from "react-bootstrap";


const ColeccionCard= () => {
    return (

<Card  as="div"  className="contenedor-tarjeta-coleccion">
    <h1>hola </h1>
    <Container as="div" className="contenedor-botones-coleccion">
        <Button className="boton-aprobar"  variant = "secondary"  > Configurar coleccion </Button>
        <Button className="boton-rechazar" variant = "danger"  > Eliminar</Button>
    </Container>
</Card>

)}

export default ColeccionCard