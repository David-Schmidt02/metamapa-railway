package ar.edu.utn.frba.ddsi.agregador.models.entities.dtos;

import lombok.Getter;


@Getter
public class UbicacionParaMapaDTO {
    private Integer id;
    private String titulo;
    private Double latitud;
    private Double longitud;

    public UbicacionParaMapaDTO(Integer id, String titulo, Double latitud, Double longitud) {
        this.id = id;
        this.titulo = titulo;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}

