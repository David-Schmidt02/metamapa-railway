package ar.edu.utn.frba.ddsi.agregador.models.entities.dtos;

import lombok.Getter;


@Getter

public class UbicacionDTO {
    private Double latitud;
    private Double longitud;

    public UbicacionDTO(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
