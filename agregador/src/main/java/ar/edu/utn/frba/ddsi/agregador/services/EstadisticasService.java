package ar.edu.utn.frba.ddsi.agregador.services;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Ubicacion;
import ar.edu.utn.frba.ddsi.agregador.models.repositories.EstadisticasRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadisticasService {
    private final EstadisticasRepository estadisticasRepository;

    public EstadisticasService(EstadisticasRepository estadisticasRepository) {
        this.estadisticasRepository = estadisticasRepository;
    }

    // SERVICIOS PARA EL MÓDULO DE ESTADÍSTICAS
    public List<Ubicacion> obtenerUbicaciones(Integer idColeccion) {
        return this.estadisticasRepository.obtenerUbicaciones(idColeccion);
    }

    public Categoria obtenerCategoriaConMasHechos() {
        return this.estadisticasRepository.obtenerCategoriaConMasHechos();
    }
}
