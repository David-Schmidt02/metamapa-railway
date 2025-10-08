package ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.criterios;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="criterios_pertenencia")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class CriterioPertenencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public boolean cumpleConCriterio(Hecho hecho) {
        return false;
    }
}


/*
* hechosParaColeccion = hechos.stream().filter(coleccion.getCriterioPertenencia()::cumpleConCriterio).toList();
*
* */