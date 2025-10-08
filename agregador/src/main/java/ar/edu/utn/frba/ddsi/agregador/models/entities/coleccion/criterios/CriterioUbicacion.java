package ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.criterios;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Ubicacion;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@jakarta.persistence.DiscriminatorValue("ubicacion")
public class CriterioUbicacion extends CriterioPertenencia{
    private Ubicacion ubicacion;

    public CriterioUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public CriterioUbicacion() {

    }

    @Override
    public boolean cumpleConCriterio(Hecho hecho) {
        return hecho.getUbicacion().equals(ubicacion);
    }
}
