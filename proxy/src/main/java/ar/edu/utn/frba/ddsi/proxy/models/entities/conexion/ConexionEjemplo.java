package ar.edu.utn.frba.ddsi.proxy.models.entities.conexion;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;

public class ConexionEjemplo implements Conexion {

    @Override
    public Map<String, Object> siguienteHecho(URL url, LocalDate fechaUltimaConsulta) {
        // Implementación de ejemplo que retorna un mapa vacío
        return Map.of();
    }
}
