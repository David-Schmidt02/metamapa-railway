package ar.edu.utn.frba.ddsi.estatica.controllers;

import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.estatica.services.IHechosServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@RestController
@RequestMapping("/api/estatica")

public class EstaticaController {

    private final IHechosServices hechosServices;

    public EstaticaController(IHechosServices hechosServices) {
        this.hechosServices = hechosServices;
    }

    @GetMapping
    public List<Hecho> ObtenerHechos() {
        return hechosServices.obtenerHechos();
    }







}
