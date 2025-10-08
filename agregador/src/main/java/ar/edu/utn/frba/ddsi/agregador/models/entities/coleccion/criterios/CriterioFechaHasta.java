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
@DiscriminatorValue("fecha_hasta")
public class CriterioFechaHasta extends CriterioPertenencia{
    private LocalDateTime hasta;

    public CriterioFechaHasta(LocalDateTime hasta) {
        this.hasta = hasta;
    }

    public CriterioFechaHasta() {

    }

    @Override
    public boolean cumpleConCriterio(Hecho hecho) {
        return hasta.isAfter(hecho.getFechaAcontecimiento());
    }

}
