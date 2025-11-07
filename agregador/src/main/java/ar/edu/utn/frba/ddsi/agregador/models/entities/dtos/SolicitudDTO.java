package ar.edu.utn.frba.ddsi.agregador.models.entities.dtos;

import ar.edu.utn.frba.ddsi.agregador.models.entities.solicitudEliminacion.Estado_Solicitud;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SolicitudDTO {
    private Integer idHecho;
    private String justificacion;

    public SolicitudDTO(Integer idHecho,String justificacion) {
        this.idHecho = idHecho;
        this.justificacion = justificacion;
    }
}
