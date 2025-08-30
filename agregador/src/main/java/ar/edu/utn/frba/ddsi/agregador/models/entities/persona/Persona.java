package ar.edu.utn.frba.ddsi.agregador.models.entities.persona;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Persona {

    private UUID id;
    private String nombre;
    private String email;
    private int edad;

    public Persona(String nombre, String email, int edad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

}
