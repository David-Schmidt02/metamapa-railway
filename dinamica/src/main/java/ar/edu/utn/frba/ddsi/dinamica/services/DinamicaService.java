package ar.edu.utn.frba.ddsi.dinamica.services;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.repositories.DinamicaRepository;
import org.springframework.stereotype.Service;

@Service
public class DinamicaService {
    private final DinamicaRepository dinamicaRepository;

    public DinamicaService(DinamicaRepository dinamicaRepository) {
        this.dinamicaRepository = dinamicaRepository;
    }

}
