package ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.criterios;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("fecha_desde")
public class CriterioFechaDesde extends CriterioPertenencia{
    private LocalDateTime desde;

    public CriterioFechaDesde(LocalDateTime desde) {
        this.desde = desde;
    }

    public CriterioFechaDesde() {

    }

    @Override
    public boolean cumpleConCriterio(Hecho hecho) {
        return desde.isBefore(hecho.getFechaAcontecimiento());
    }
}
