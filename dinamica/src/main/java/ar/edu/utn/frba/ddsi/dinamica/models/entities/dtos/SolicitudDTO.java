package ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SolicitudDTO {
    private UUID id;
    private String justificacion;

    public SolicitudDTO(UUID id, String justificacion) {
        this.id = id;
        this.justificacion = justificacion;
    }
}
