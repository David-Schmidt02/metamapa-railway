package ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.criterios;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@jakarta.persistence.DiscriminatorValue("categoria")
public class CriterioCategoria extends CriterioPertenencia{
    private Categoria categoria;

    public CriterioCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CriterioCategoria() {

    }

    @Override
    public boolean cumpleConCriterio(Hecho hecho) {
        return hecho.getCategoria().equals(categoria);
    }

}
