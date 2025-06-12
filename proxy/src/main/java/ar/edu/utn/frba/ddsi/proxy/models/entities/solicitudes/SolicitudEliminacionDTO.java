package ar.edu.utn.frba.ddsi.proxy.models.entities.solicitudes;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SolicitudEliminacionDTO {

    private UUID idHecho;
    private String justificacion;

}
