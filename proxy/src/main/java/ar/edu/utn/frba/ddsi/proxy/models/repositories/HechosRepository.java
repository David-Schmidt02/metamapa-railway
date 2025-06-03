package ar.edu.utn.frba.ddsi.proxy.models.repositories;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;
import ar.edu.utn.frba.ddsi.proxy.models.entities.conexion.Conexion;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class HechosRepository {
    private List<Hecho> hechos;
    private final Map<String, Conexion> conexiones = Map.of(
            // Aquí se pueden agregar las conexiones a los distintos servicios
            // Ejemplo: new URL("http://example.com"), new ConexionEjemplo()
    );

    public List<Hecho> findByURL(String nombre) {
        return this.conexiones.get(nombre).obtenerHechos();
    }
}
