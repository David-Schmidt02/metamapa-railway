package ar.edu.utn.frba.ddsi.normalizador.models.entities.normalizador;
import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Hecho;

public interface INormalizador {
    Hecho normalizar(Hecho hecho);
}
