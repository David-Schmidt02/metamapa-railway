package ar.edu.utn.frba.ddsi.normalizador.models.entities.normalizador;
import ar.edu.utn.frba.ddsi.normalizador.models.dtos.HechoDTO;
import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Hecho;

public interface INormalizador {
    HechoDTO normalizar(HechoDTO hecho);
}
