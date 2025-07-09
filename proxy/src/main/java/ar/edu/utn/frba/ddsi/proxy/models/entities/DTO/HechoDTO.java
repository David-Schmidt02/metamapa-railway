package ar.edu.utn.frba.ddsi.proxy.models.entities.DTO;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Origen_Fuente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Ubicacion;
import ar.edu.utn.frba.ddsi.proxy.models.entities.personas.Contribuyente;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Etiqueta;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Categoria;

public class HechoDTO {
    private UUID id;
    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private Ubicacion ubicacion;
    private LocalDateTime fechaAcontecimiento;
    private LocalDateTime fechaCarga;
    private Origen_Fuente origenFuente;
    private List<Etiqueta> etiquetas;
    private List<String> contenidoMultimedia;
    private String cuerpo;
    private Contribuyente contribuyente;
    private boolean verificado = false;

    public HechoDTO(UUID id, String titulo, String descripcion, Categoria categoria, Ubicacion ubicacion, LocalDateTime fechaAcontecimiento, LocalDateTime fechaCarga, List<Etiqueta> etiquetas, List<String> contenidoMultimedia, String cuerpo, Origen_Fuente origenFuente, Contribuyente contribuyente) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fechaAcontecimiento = fechaAcontecimiento;
        this.fechaCarga = fechaCarga;
        this.etiquetas = etiquetas;
        this.contenidoMultimedia = contenidoMultimedia;
        this.cuerpo = cuerpo;
        this.origenFuente = origenFuente;
        this.contribuyente = contribuyente;

    }


}