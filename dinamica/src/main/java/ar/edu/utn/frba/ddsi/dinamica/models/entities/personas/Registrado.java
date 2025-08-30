package ar.edu.utn.frba.ddsi.dinamica.models.entities.personas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeName("registrado")
public class Registrado extends Contribuyente {

    private UUID id;
    private String nombre;

    public Registrado(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    @JsonProperty("tipo")
    public String getTipo() {
        return "registrado";
    }


}
