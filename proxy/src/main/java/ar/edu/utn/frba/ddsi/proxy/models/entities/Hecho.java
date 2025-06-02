package ar.edu.utn.frba.ddsi.proxy.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Hecho {

    public UUID getId() {
        return id;
    }

    private final UUID id;
    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private Ubicacion ubicacion;
    private LocalDate fechaAcontecimiento;
    private LocalDateTime fechaImportacion;
    private Origen_Fuente origenFuente;

    public Hecho(String titulo, String descripcion, Categoria categoria, Ubicacion ubicacion, LocalDate fechaAcontecimiento) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fechaAcontecimiento = fechaAcontecimiento;
        this.fechaImportacion = LocalDateTime.now();
        this.origenFuente = Origen_Fuente.ESTATICA;
    }

}
