package ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion;

import lombok.Getter;
import lombok.Setter;
import java.util.Random;

@Getter
public class SolicitudEliminacion {
    private Integer id;
    private Integer idHecho;
    private String justificacion;
    @Setter
    private Estado_Solicitud estado;

    public SolicitudEliminacion(Integer idHecho, String justificacion) {
        this.id = new Random().nextInt(1, 100000); // Generar un ID aleatorio entre 1 y 100000
        this.idHecho = idHecho;
        this.justificacion = justificacion;
        this.estado = Estado_Solicitud.PENDIENTE; // Estado inicial por defecto
    }

    public boolean esCorrecta() {
        // Justificacion con minimo 500 caracteres
        return justificacion != null && justificacion.length() >= 500;
    }

}
