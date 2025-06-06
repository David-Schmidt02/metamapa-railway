package ar.edu.utn.frba.ddsi.dinamica.controllers;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos.SolicitudDTO;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion.Estado_Solicitud;
import ar.edu.utn.frba.ddsi.dinamica.services.DinamicaService;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/dinamica")
@RestController

public class DinamicaController {
    private final DinamicaService dinamicaService;

    public DinamicaController(DinamicaService dinamicaService) {
        this.dinamicaService = dinamicaService;
    }

    @PostMapping("/hechos")
    public void subirHecho(@RequestBody Object hechoDTO) {
        dinamicaService.crearHecho(hechoDTO);
    }

    @PutMapping("/hechos/{id}")
    public void modificarHecho(@PathVariable UUID id, @RequestBody Object hechoDTO) {
        dinamicaService.actualizarHecho(id, hechoDTO);
    }


    @PostMapping("/solicitudes")
    public void subirSolicitud(@RequestBody SolicitudDTO solicitudDTO) {
        dinamicaService.crearSolicitudEliminacion(solicitudDTO);
    }

    @PutMapping("/solicitudes/{id}")
    public void modificarSolicitud(@PathVariable UUID id, @RequestBody Estado_Solicitud nuevoEstado) {
        dinamicaService.modificarEstadoSolicitud(id, nuevoEstado);
    }


}
