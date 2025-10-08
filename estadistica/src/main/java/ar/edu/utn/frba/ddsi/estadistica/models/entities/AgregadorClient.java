package ar.edu.utn.frba.ddsi.estadistica.models.entities;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class AgregadorClient {
    private final WebClient webClient;

    public AgregadorClient(String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    // Trae la ubicacion que esta en la mayor cantidad de hechos de una coleccion
    public Ubicacion obtenerUbicacionDeColeccion (Integer Id) {
        Ubicacion ubicacionConMasHechos = webClient.get()
                .uri("/colecciones/{Id}/ubicacionMasFrecuente", Id)
                .retrieve()
                .bodyToMono(Ubicacion.class)
                .block();
        if(ubicacionConMasHechos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la provincia o la coleccion buscada");
        }
        return ubicacionConMasHechos;
    }

    public Categoria obtenerCategoriaConMasHechos() {
        Categoria categoriaConMasHechos = webClient.get()
                .uri("/hechos/max-categoria")
                .retrieve()
                .bodyToMono(Categoria.class)
                .block();
        if(categoriaConMasHechos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la categoria buscada");
        }
        return categoriaConMasHechos;
    }

    // Trae la ubicacion que esta en la mayor cantidad de hechos de una categoria
    public Ubicacion obtenerUbicacionDeCategoria (Integer Id) {
        Ubicacion ubicacionConMasHechos = webClient.get()
                .uri("/categoria/{Id}/ubicacionMasFrecuente", Id)
                .retrieve()
                .bodyToMono(Ubicacion.class)
                .block();
        if(ubicacionConMasHechos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la provincia o la categoria buscada");
        }
        return ubicacionConMasHechos;
    }

    public LocalTime obtenerHoraMasFrecuenteDeCategoria (Integer Id) {
        LocalTime horaMasFrecuente = webClient.get()
                .uri("/categoria/{Id}/hora", Id)
                .retrieve()
                .bodyToMono(LocalTime.class)
                .block();
        if(horaMasFrecuente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la hora buscada");
        }
        return horaMasFrecuente;
    }

    public Integer obtenerCantidadDeSolicitudesSpam() {
        Integer cantidadSolicitudesSpam = webClient.get()
                .uri("/solicitudes/spam")
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        if(cantidadSolicitudesSpam == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la cantidad de solicitudes spam");
        }
        return cantidadSolicitudesSpam;
    }
}
