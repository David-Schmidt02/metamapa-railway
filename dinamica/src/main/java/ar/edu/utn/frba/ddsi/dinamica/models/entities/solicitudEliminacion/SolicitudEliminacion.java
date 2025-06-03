package ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Hecho;

public class SolicitudEliminacion {
    private Hecho hecho;
    private String justificacion;
    private Estado_Solicitud estado;

    public SolicitudEliminacion(Hecho hecho, String justificacion) {
        this.hecho = hecho;
        this.justificacion = justificacion;
        this.estado = Estado_Solicitud.PENDIENTE; // Estado inicial por defecto
    }

    public boolean esCorrecta() {
        // Justificacion con minimo 500 caracteres
        return justificacion != null && justificacion.length() >= 500;
    }
}
