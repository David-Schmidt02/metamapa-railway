package ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class SolicitudDTO {
    private Integer idHecho;
    private String justificacion;

    public SolicitudDTO(Integer id, String justificacion) {
        this.idHecho = id;
        this.justificacion = justificacion;
    }
}
