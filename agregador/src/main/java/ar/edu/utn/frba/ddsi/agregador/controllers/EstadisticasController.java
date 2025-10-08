package ar.edu.utn.frba.ddsi.agregador.controllers;


import ar.edu.utn.frba.ddsi.agregador.models.entities.dtos.UbicacionDTO;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Categoria;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Ubicacion;
import ar.edu.utn.frba.ddsi.agregador.services.EstadisticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agregador/estadisticas")
public class EstadisticasController {
    private final EstadisticasService estadisticasService;

    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    //APIs que va a consumir el módulo de estadísticas, el agregador le brinda los datos y la estadistica los procesa.

    @GetMapping("/colecciones/{Id}/ubicaciones")
    public List<UbicacionDTO> obtenerUbicaciones(@PathVariable Integer Id) {
        List<Ubicacion> ubicaciones = this.estadisticasService.obtenerUbicaciones(Id);
        return ubicaciones.stream()
                .map(Ubicacion::toDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @GetMapping("/hechos/max-categoria")
    public Categoria obtenerCategoriaConMasHechos() {
        return this.estadisticasService.obtenerCategoriaConMasHechos();
    }
}
