package ar.edu.utn.frba.ddsi.agregador.models.entities.hecho;

import ar.edu.utn.frba.ddsi.agregador.models.entities.dtos.UbicacionDTO;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Getter
@Setter


@Embeddable
public class Ubicacion {

    @Column
    private Double latitud;

    @Column
    private Double longitud;

    public Ubicacion(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Ubicacion() {}

    public UbicacionDTO toDTO() {
        return new UbicacionDTO(this.latitud, this.longitud);
    }


}
