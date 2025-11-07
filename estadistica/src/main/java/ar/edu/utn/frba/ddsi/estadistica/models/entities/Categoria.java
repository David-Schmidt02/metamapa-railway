package ar.edu.utn.frba.ddsi.estadistica.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String detalle;
    private LocalDateTime fecha;

    public Categoria() {}

    public Categoria(String detalle) {
        this.detalle = detalle;
        this.fecha = LocalDateTime.now();
    }

}
