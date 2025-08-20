package ar.edu.utn.frba.ddsi.agregador.models.entities.normalizador;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;

public interface INormalizador {
    Hecho normalizar(Hecho hecho);
}
