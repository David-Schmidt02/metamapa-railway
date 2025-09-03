package ar.edu.utn.frba.ddsi.normalizador.models.entities.normalizador;

import ar.edu.utn.frba.ddsi.normalizador.models.dtos.HechoDTO;
import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.normalizador.models.repositories.EquivalenciasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Normalizador {
    private final List<INormalizador> normalizadores = List.of(new NormalizadorCategorias(new EquivalenciasRepository(new ObjectMapper())));

    private static Normalizador instance;

    private Normalizador() {// Constructor privado
    }

    public static Normalizador getInstance() {
        if (instance == null) {
            instance = new Normalizador();
        }
        return instance;
    }

    public HechoDTO normalizar(HechoDTO hechoCrudo) {
        HechoDTO hechoNormalizado = normalizadores.stream().reduce(hechoCrudo,
                (hechoAcumulado, unNormalizador) -> unNormalizador.normalizar(hechoAcumulado),
                (hecho1, hecho2) -> hecho2
        );

        return hechoNormalizado;

    }
}
        /*
         * Hecho hechoNormalizado = unHecho
         * for (INormalizador unNormalizador : normalizadores) {
         *   hechoNormalizado = unNormalizador.normalizar(hechoNormalizado)
         * }
         * return hechoNormalizado;
         *
         */
