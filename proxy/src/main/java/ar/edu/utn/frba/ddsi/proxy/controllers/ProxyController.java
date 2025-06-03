package ar.edu.utn.frba.ddsi.proxy.controllers;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.utn.frba.ddsi.proxy.service.HechosServices;

import java.net.URL;
import java.util.List;

@RequestMapping("/api/proxy")
@RestController
public class ProxyController {
    private final HechosServices hechosServices;

    public ProxyController(HechosServices hechosServices) {
        this.hechosServices = hechosServices;
    }

    @GetMapping("/hechos")
    public List<Hecho> ObtenerHechos() {
        URL url = null; // Agregar logica para obtener la URL deseada
        return hechosServices.obtenerHechos(url);
    }
}

