package ar.edu.utn.frba.ddsi.proxy.models.repositories;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;
import ar.edu.utn.frba.ddsi.proxy.models.entities.conexion.Conexion;

import java.net.URL;
import java.util.List;

public class HechosRepository {
    private List<Hecho> hechos;
    private List<Conexion> conexiones;

    public List<Hecho> findByURL(URL url) {
        return this.hechos;
    }
}
