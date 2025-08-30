package ar.edu.utn.frba.ddsi.agregador.models.repositories;

import ar.edu.utn.frba.ddsi.agregador.models.entities.persona.Persona;
import ar.edu.utn.frba.ddsi.agregador.models.entities.personas.Registrado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PersonasRepository {

    private final List<Persona> personas = new ArrayList<>();

    public Registrado findById(UUID id) {
        Persona buscado = personas.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst()
                .orElse(null);


        return new Registrado(buscado.getId(), buscado.getNombre());
    }

}
