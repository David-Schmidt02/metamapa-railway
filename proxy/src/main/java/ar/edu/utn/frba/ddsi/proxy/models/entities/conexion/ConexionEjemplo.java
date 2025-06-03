package ar.edu.utn.frba.ddsi.proxy.models.entities.conexion;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConexionEjemplo implements Conexion {

    private URL url;

    @Override
    public List<Hecho> obtenerHechos() {
        ArrayList<Hecho> hechos = new ArrayList<>();
        Map<String, Object> hechoDescompuesto = siguienteHecho(url, LocalDate.now());
        while(hechoDescompuesto != null) {
            hechos.add(convertirHechos(hechoDescompuesto));
            hechoDescompuesto = siguienteHecho(url, LocalDate.now());
        } ;
        return hechos;
    }

    private Hecho convertirHechos(Map<String, Object> hechoDescompuesto) {
        // Implementación de ejemplo que retorna un nuevo Hecho
        return new Hecho();
    }


    public Map<String, Object> siguienteHecho(URL url, LocalDate fechaUltimaConsulta) {
        // Implementación de ejemplo que retorna un mapa vacío
        return Map.of();
    }
}
