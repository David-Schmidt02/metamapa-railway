package ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Etiqueta;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Ubicacion;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.personas.Registrado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor

public class HechoDTO {
    private String tipo;
    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private Ubicacion ubicacion;
    private LocalDateTime fechaAcontecimiento;
    private UUID contribuyente_id;
    private List<Etiqueta> etiquetas;
    private List<String> contenidoMultimedia;
    private String cuerpo;

    public HechoDTO(String titulo, String descripcion, Categoria categoria, Ubicacion ubicacion, LocalDateTime fechaAcontecimiento, UUID contribuyente_id, List<Etiqueta> etiquetas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fechaAcontecimiento = fechaAcontecimiento;
        this.contribuyente_id = contribuyente_id;
        this.etiquetas = etiquetas;

    }


}

