package ar.edu.utn.frba.ddsi.agregador.models.entities.archivoProcesado;


import ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.Fuente;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
public class ArchivoProcesado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private LocalDateTime fechaCarga;

    @ManyToOne
    @JoinColumn(name = "url_fuente") // la FK
    private Fuente fuente;

    public ArchivoProcesado(String nombre, LocalDateTime fechaCarga, Fuente fuente) {
        this.nombre = nombre;
        this.fechaCarga = fechaCarga;
        this.fuente = fuente;
    }

    public ArchivoProcesado() {}
}
