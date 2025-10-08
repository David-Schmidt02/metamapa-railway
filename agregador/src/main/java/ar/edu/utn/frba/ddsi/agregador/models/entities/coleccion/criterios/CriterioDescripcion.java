package ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.criterios;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@jakarta.persistence.DiscriminatorValue("descripcion")
public class CriterioDescripcion extends CriterioPertenencia{
    private String descripcion;

    public CriterioDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CriterioDescripcion() {

    }

    @Override
    public boolean cumpleConCriterio(Hecho hecho) {
        return hecho.getDescripcion().contains(descripcion);
    }
}
