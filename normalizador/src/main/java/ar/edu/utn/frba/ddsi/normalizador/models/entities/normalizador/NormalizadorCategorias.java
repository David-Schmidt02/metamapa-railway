package ar.edu.utn.frba.ddsi.normalizador.models.entities.normalizador;

import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.normalizador.models.repositories.EquivalenciasRepository;

import java.util.Map;

public class NormalizadorCategorias {
    private final EquivalenciasRepository equivalenciasCategoriasRepo;

    public NormalizadorCategorias(EquivalenciasRepository equivalenciasCategoriasRepo) {
        this.equivalenciasCategoriasRepo = equivalenciasCategoriasRepo;
    }

    public Hecho normalizar(Hecho hechoCrudo) {
        Map<String, Categoria> mapaDeEquivalencias = equivalenciasCategoriasRepo.obtenerEquivalencias();
        Categoria categoriaAsociada = mapaDeEquivalencias.get(hechoCrudo.getCategoria().getDetalle().toLowerCase());

        if(categoriaAsociada != null) {
            hechoCrudo.setCategoria(categoriaAsociada);
        } else {
            // llamar al modo complejo que aplica un algoritmo...

            equivalenciasCategoriasRepo.agregarCategoriaNueva(hechoCrudo.getCategoria());
        }
        //commit

        return hechoCrudo;
    }
}
