package ar.edu.utn.frba.ddsi.normalizador.services;

import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.normalizador.models.entities.normalizador.Normalizador;
import org.springframework.stereotype.Service;

@Service
public class NormalizadorService {

    public NormalizadorService() {

    }

    public Hecho normalizar(Hecho hechoCrudo) {
        Normalizador normalizador = Normalizador.getInstance();
        return normalizador.normalizar(hechoCrudo); // Retorna el hecho normalizado (aquí solo retorna el mismo hecho para el ejemplo)
    }

}
