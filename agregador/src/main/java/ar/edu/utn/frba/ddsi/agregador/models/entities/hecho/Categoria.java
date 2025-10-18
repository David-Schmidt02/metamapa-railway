package ar.edu.utn.frba.ddsi.agregador.models.entities.hecho;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.io.Serializable;

@Getter
@Setter

@Entity
@Table(name="Categoria")
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String detalle;

    public Categoria(String detalle) {
        this.detalle = detalle;
    }

    public Categoria() {}
}
