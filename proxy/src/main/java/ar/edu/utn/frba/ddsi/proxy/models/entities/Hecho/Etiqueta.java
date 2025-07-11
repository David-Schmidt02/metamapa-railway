package ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Etiqueta {
    private String descripcion;

    public Etiqueta(String descripcion) {
        this.descripcion = descripcion;
    }

    public Etiqueta() {}
}

