package ar.edu.utn.frba.ddsi.normalizador.controllers;

import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.normalizador.services.NormalizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/normalizador")
@RestController
public class NormalizadorController {
    private final NormalizadorService normalizadorService;

    @Autowired
    public NormalizadorController(NormalizadorService normalizadorService) {
        this.normalizadorService = normalizadorService;
    }

    @GetMapping("/normalizar")
    public Hecho normalizar(@RequestParam() Hecho hechoCrudo) {
        return this.normalizadorService.normalizar(hechoCrudo);
    }

    @GetMapping("/health")
    public String health() {
        return "Normalizador Service is up and running";
    }

}
