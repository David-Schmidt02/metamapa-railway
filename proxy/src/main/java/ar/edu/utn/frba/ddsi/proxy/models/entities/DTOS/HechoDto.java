package ar.edu.utn.frba.ddsi.proxy.models.entities.DTOS;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Categoria;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Etiqueta;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Origen_Fuente;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Ubicacion;
import ar.edu.utn.frba.ddsi.proxy.models.entities.personas.Contribuyente;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class HechoDto {
    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private Ubicacion ubicacion;
    private LocalDateTime fechaAcontecimiento;
    private LocalDateTime fechaCarga;
    private Origen_Fuente origenFuente;
    private List<Etiqueta> etiquetas;
    private Contribuyente contribuyente;
    private List<String> contenidoMultimedia;
    private String cuerpo;

    public HechoDto(String titulo, String descripcion, Categoria categoria, Ubicacion ubicacion, LocalDateTime fechaAcontecimiento, LocalDateTime fechaCarga, Origen_Fuente origenFuente, List<Etiqueta> etiquetas, Contribuyente contribuyente, List<String> contenidoMultimedia, String cuerpo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fechaAcontecimiento = fechaAcontecimiento;
        this.fechaCarga = fechaCarga;
        this.origenFuente = origenFuente;
        this.etiquetas = etiquetas;
        this.contribuyente = contribuyente;
        this.contenidoMultimedia = contenidoMultimedia;
        this.cuerpo = cuerpo;
    }
}
