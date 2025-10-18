package ar.edu.utn.frba.ddsi.estadistica.models.entities;

import lombok.Getter;

@Getter
public class Categoria {
    private Integer id;
    private String detalle;

    public Categoria(String detalle) {
        this.detalle = detalle;
    }

}
