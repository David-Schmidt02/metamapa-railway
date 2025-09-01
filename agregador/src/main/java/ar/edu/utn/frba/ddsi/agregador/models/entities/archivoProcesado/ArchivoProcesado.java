package ar.edu.utn.frba.ddsi.agregador.models.entities.archivoProcesado;

import ar.edu.utn.frba.ddsi.agregador.models.entities.dtos.HechoDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ArchivoProcesado {

    private String nombre;
    private LocalDateTime ultimaConsulta;

    public ArchivoProcesado(String nombre, LocalDateTime ultimaConsulta, List<HechoDTO> hechos) {
        this.nombre = nombre;
        this.ultimaConsulta = ultimaConsulta;
    }
}
