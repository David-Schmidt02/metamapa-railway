package ar.edu.utn.frba.ddsi.agregador.models.entities.hecho;

import lombok.Getter;

@Getter
public class Filtro {
    private final String categoria;
    private final String fecha_reporte_desde;
    private final String fecha_reporte_hasta;
    private final String fecha_acontecimiento_desde;
    private final String fecha_acontecimiento_hasta;
    private final Integer latitud;
    private final Integer longitud;

    public Filtro(String categoria, String fecha_reporte_desde, String fecha_reporte_hasta, String fecha_acontecimiento_desde, String fecha_acontecimiento_hasta, Integer latitud, Integer longitud) {
        this.categoria = categoria;
        this.fecha_reporte_desde = fecha_reporte_desde;
        this.fecha_reporte_hasta = fecha_reporte_hasta;
        this.fecha_acontecimiento_desde = fecha_acontecimiento_desde;
        this.fecha_acontecimiento_hasta = fecha_acontecimiento_hasta;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
