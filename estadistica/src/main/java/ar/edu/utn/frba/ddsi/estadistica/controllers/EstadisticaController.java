package ar.edu.utn.frba.ddsi.estadistica.controllers;

import ar.edu.utn.frba.ddsi.estadistica.models.entities.Categoria;
import ar.edu.utn.frba.ddsi.estadistica.service.EstadisticaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/estadisticas")
@RestController

@Tag(name = "Estadísticas", description = "Endpoints para obtener estadísticas de hechos y categorías")
public class EstadisticaController {

    private final EstadisticaService estadisticaService;

    public EstadisticaController(EstadisticaService estadisticaService) {
        this.estadisticaService = estadisticaService;
    }

    //De una colección, ¿en qué provincia se agrupan la mayor cantidad de hechos reportados?
    @GetMapping("/colecciones/{Id}/provincia-max-hechos")
    @Operation(summary = "en qué provincia se agrupan la mayor cantidad de hechos reportados de una coleccion")
    public String obtenerProvinciaDeColeccion(@PathVariable Integer Id) {
        return this.estadisticaService.obtenerProvinciaDeColeccion(Id);
    }

    //¿Cuál es la categoría con mayor cantidad de hechos reportados?
    @GetMapping("/hechos/max-categoria")
    @Operation(summary = "Categoría con más hechos reportados")
    public Categoria obtenerCategoriaConMasHechos() {
        return this.estadisticaService.obtenerCategoriaConMasHechos();
    }

    //¿En qué provincia se presenta la mayor cantidad de hechos de una cierta categoría?
    @GetMapping("/categoria/{id}/provincia-max-hechos")
    @Operation(summary = "en qué provincia se agrupan la mayor cantidad de hechos reportados de una categoria")
    public String obtenerProvinciaDeCategoria(@PathVariable Integer id) {
        return this.estadisticaService.obtenerProvinciaDeCategoria(id);
    }

    //¿A qué hora del día ocurren la mayor cantidad de hechos de una cierta categoría?
    @GetMapping("/categoria/{id}/hora")
    @Operation(summary = "A qué hora del día ocurren la mayor cantidad de hechos de una cierta categoría")
    public LocalTime obtenerHoraMasFrecuente(@PathVariable Integer id) {
        return this.estadisticaService.obtenerHoraMasFrecuenteDeCategoria(id);
    }

    //¿Cuántas solicitudes de eliminación son spam?
    @GetMapping("/solicitudes/spam" )
    @Operation(summary = "Cuantas solicitudes de eliminacion son spam")
    public Integer obtenerCantidadDeSolicitudesSpam() {
        return this.estadisticaService.obtenerCantidadDeSolicitudesSpam();
    }
}
