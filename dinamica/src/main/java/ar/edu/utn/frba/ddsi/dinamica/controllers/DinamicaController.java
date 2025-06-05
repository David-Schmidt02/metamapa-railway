package ar.edu.utn.frba.ddsi.dinamica.controllers;

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
    public void crearHecho(@RequestBody Object hechoDTO) {
        dinamicaService.crearHecho(hechoDTO);
    }

    @PutMapping("/hechos/{id}")
    public void actualizarHecho(@PathVariable UUID id, @RequestBody Object hechoDTO) {
        dinamicaService.actualizarHecho(id, hechoDTO);
    }


    //@PostMapping("/solicitudes")
}
