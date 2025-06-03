package ar.edu.utn.frba.ddsi.proxy.models.entities.conexion;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface Conexion {
    public List<Hecho> obtenerHechos();
}
