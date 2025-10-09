package ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String detalle;

    public Categoria(String detalle) {
        this.detalle = detalle;
    }

    public Categoria(){}
}
