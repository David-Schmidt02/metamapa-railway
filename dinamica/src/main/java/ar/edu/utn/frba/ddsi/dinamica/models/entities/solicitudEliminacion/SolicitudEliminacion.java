package ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion;

import lombok.Getter;

import java.util.UUID;
@Getter
public class SolicitudEliminacion {
    private UUID id;
    private UUID idHecho;
    private String justificacion;
    private Estado_Solicitud estado;

    public SolicitudEliminacion(UUID idHecho, String justificacion) {
        this.id = UUID.randomUUID();
        this.idHecho = idHecho;
        this.justificacion = justificacion;
        this.estado = Estado_Solicitud.PENDIENTE; // Estado inicial por defecto
    }

    public boolean esCorrecta() {
        // Justificacion con minimo 500 caracteres
        return justificacion != null && justificacion.length() >= 500;
    }
}
