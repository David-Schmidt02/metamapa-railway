package ar.edu.utn.frba.ddsi.estatica.services;
import ar.edu.utn.frba.ddsi.estatica.models.repositories.HechosRepository;
import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HechosServices implements IHechosServices{
    private HechosRepository hechosRepository;

    public HechosServices(HechosRepository hechosRepository) {
        this.hechosRepository = hechosRepository;
    }

// Obtener todos los hechos
public List<Hecho> ObtenerHechos() {return this.hechosRepository.findAll();}
}
