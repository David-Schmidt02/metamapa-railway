package ar.edu.utn.frba.ddsi.agregador.models.entities.repositories.clasificador;

import java.util.List;
import java.util.Objects;

import ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.Fuente;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;

public class Clasificador {

    public Clasificador() {
    }
    // Verifica si dos hechos son iguales comparando todos sus atributos
    public static boolean hechosIguales(Hecho hecho1, Hecho hecho2) {
        return Objects.equals(hecho1.getTitulo(), hecho2.getTitulo())
                    && Objects.equals(hecho1.getDescripcion(), hecho2.getDescripcion())
                    && Objects.equals(hecho1.getCategoria(), hecho2.getCategoria())
                    && Objects.equals(hecho1.getUbicacion(), hecho2.getUbicacion())
                    && Objects.equals(hecho1.getFechaAcontecimiento(), hecho2.getFechaAcontecimiento())
                    && Objects.equals(hecho1.getEtiquetas(), hecho2.getEtiquetas());
    }

    // Clasifica los hechos uniendo el título y la descripción, podemos modificarlo en un futuro
    public static List<Hecho> clasificarHechosPorMenciones(List<Hecho> hechos, List<Fuente> fuentesRestantes) {
        for (Hecho hecho : hechos) {
            int mencionesHecho = compararHechos(hecho, fuentesRestantes);
            hecho.setCantidadMenciones(mencionesHecho);
        }
        return hechos;
    }

    public static int compararHechos(Hecho hecho, List<Fuente> fuentesRestantes) {
        int cantidadMenciones = 0;
        for (Fuente fuente : fuentesRestantes) {
            cantidadMenciones += (int) fuente.getHechos().stream()
                    .filter(h -> hechosIguales(h, hecho))
                    .count();
        }
        return cantidadMenciones;
    }

}
