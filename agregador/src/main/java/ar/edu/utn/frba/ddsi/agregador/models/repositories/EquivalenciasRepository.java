package ar.edu.utn.frba.ddsi.agregador.models.repositories;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Categoria;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EquivalenciasRepository {
    private Map<String, Categoria> equivalenciasCategorias;
    private Map<String, Categoria> nuevasCategorias;

    public Map<String, Categoria> obtenerEquivalencias() {
        return equivalenciasCategorias;
    }

    public void agregarCategoriaNueva(Categoria nuevaCategoria) {

    }
}
