package ar.edu.utn.frba.ddsi.normalizador.models.entities.archivoProcesado;


import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ArchivoProcesado {

    private UUID id;
    private String nombre;
    private LocalDateTime fechaCarga;

    public ArchivoProcesado(String nombre, LocalDateTime fechaCarga) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.fechaCarga = fechaCarga;
    }
}
