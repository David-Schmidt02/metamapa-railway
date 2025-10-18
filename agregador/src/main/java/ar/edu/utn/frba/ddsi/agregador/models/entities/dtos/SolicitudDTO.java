package ar.edu.utn.frba.ddsi.agregador.models.entities.dtos;

import ar.edu.utn.frba.ddsi.agregador.models.entities.solicitudEliminacion.Estado_Solicitud;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SolicitudDTO {
    private Integer id;
    private Integer idHecho;
    private String justificacion;
    private Estado_Solicitud estadoSolicitud;

    public SolicitudDTO(Integer id, Integer idHecho,String justificacion, Estado_Solicitud estadoSolicitud) {
        this.id = id;
        this.idHecho = idHecho;
        this.justificacion = justificacion;
        this.estadoSolicitud = estadoSolicitud;
    }
}
