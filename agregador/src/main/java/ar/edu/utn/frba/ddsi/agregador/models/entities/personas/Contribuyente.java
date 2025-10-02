package ar.edu.utn.frba.ddsi.agregador.models.entities.personas;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Registrado.class, name = "registrado"),
        @JsonSubTypes.Type(value = Anonimo.class, name = "anonimo")
})


@Entity @Table(name="Contribuyente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class Contribuyente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // Por ahora la defino como abstracta y sin metodos. TODO ver que agregar
    public Contribuyente() {}
}
