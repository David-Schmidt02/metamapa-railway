package ar.edu.utn.frba.ddsi.agregador.models.entities.normalizador;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;

import java.util.ArrayList;
import java.util.List;

public class Normalizador {
    private static final List<INormalizador> normalizadores = new ArrayList<>();

    static public Hecho normalizar(Hecho unHecho) {
        Hecho hechoNormalizado = normalizadores.stream().reduce(unHecho,
                (hechoAcumulado, unNormalizador) -> unNormalizador.normalizar(hechoAcumulado),
                (hecho1, hecho2) -> hecho2
        );


        return hechoNormalizado;

        /*
         * Hecho hechoNormalizado = unHecho
         * for (INormalizador unNormalizador : normalizadores) {
         *   hechoNormalizado = unNormalizador.normalizar(hechoNormalizado)
         * }
         * return hechoNormalizado;
         *
         */
    }
}
