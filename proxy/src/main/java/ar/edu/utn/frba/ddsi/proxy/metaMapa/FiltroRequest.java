package ar.edu.utn.frba.ddsi.proxy.metaMapa;

import org.springframework.web.util.UriComponentsBuilder;

public class FiltroRequest {
    private final String categoria;
    private final String fecha_reporte_desde;
    private final String fecha_reporte_hasta;
    private final String fecha_acontecimiento_desde;
    private final String fecha_acontecimiento_hasta;
    private final String latitud;
    private final String longitud;
    private final String ultimaConsulta;

    public FiltroRequest(String fecha_acontecimiento_hasta, String latitud, String longitud, String fecha_acontecimiento_desde, String fecha_reporte_hasta, String fecha_reporte_desde, String categoria, String ultimaConsulta) { // ! Bastante negro esto
        this.fecha_acontecimiento_hasta = fecha_acontecimiento_hasta;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha_acontecimiento_desde = fecha_acontecimiento_desde;
        this.fecha_reporte_hasta = fecha_reporte_hasta;
        this.fecha_reporte_desde = fecha_reporte_desde;
        this.categoria = categoria;
        this.ultimaConsulta = ultimaConsulta;
    }

    public String aplicarFiltroARequest(UriComponentsBuilder url) {
        if (categoria != null) url.queryParam("categoria", categoria);
        if (fecha_reporte_desde != null) url.queryParam("fecha_reporte_desde", fecha_reporte_desde);
        if (fecha_reporte_hasta != null) url.queryParam("fecha_reporte_hasta", fecha_reporte_hasta);
        if (fecha_acontecimiento_desde != null) url.queryParam("fecha_acontecimiento_desde", fecha_acontecimiento_desde);
        if (fecha_acontecimiento_hasta != null) url.queryParam("fecha_acontecimiento_hasta", fecha_acontecimiento_hasta);
        if (latitud != null) url.queryParam("latitud", latitud);
        if (longitud != null) url.queryParam("longitud", longitud);
        if (ultimaConsulta != null) url.queryParam("ultimaConsulta", ultimaConsulta);

        return url.toUriString();
    }
}
