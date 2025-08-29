package ar.edu.utn.frba.ddsi.agregador.models.entities.dtos;

import java.util.UUID;

public class ContribuyenteDTO {

    private UUID id;
    private String nombre;

    public ContribuyenteDTO(String nombre, String email, int edad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
    }

}
