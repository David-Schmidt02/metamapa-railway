package ar.edu.utn.frba.ddsi.estatica.models.entities.dtos;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ArchivoProcesadoDTO {

    private final String nombre;
    private final LocalDateTime fechaCarga;
    private final List<HechoDTO> hechos;

    public ArchivoProcesadoDTO(String nombre, LocalDateTime fechaCarga, List<HechoDTO> hechos) {
        this.nombre = nombre;
        this.fechaCarga = fechaCarga;
        this.hechos = hechos;
    }

}
