package ar.edu.utn.frba.ddsi.proxy.metaMapa;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Hecho;
import ar.edu.utn.frba.ddsi.proxy.models.entities.solicitudes.SolicitudEliminacion;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

public class MetaMapaClient {
    private final WebClient webClient;

    public MetaMapaClient(String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl) // Cambialo por la URL real
                .build();
    }

    public List<Hecho> obtenerHechos(FiltroRequest filtro) {

        String uri = filtro.aplicarFiltroARequest(UriComponentsBuilder
                .fromPath("/hechos")); //Por ejemplo, podría agregar parámetros como ?tipo=evento&fecha=2025.

        return webClient.get()                 // Inicia construcción de un GET
                .uri(uri)                      // Usa la URI construida con filtros
                .retrieve()                    // Realiza la solicitud (envía el GET)
                .bodyToFlux(Hecho.class)      // Convierte la respuesta JSON en un flujo de objetos `Hecho`
                .collectList()                // Junta el flujo en una lista
                .block();                     // Bloquea y espera la respuesta (estilo imperativo)
    }

    public List<Hecho> obtenerHechosPorColeccion(FiltroRequest filtro, String handle) {

        String uri = filtro.aplicarFiltroARequest(UriComponentsBuilder
                .fromPath("/colecciones/" + handle + "/hechos"));
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Hecho.class)
                .collectList()
                .block();
    }

    public SolicitudEliminacion crearSolicitudDeEliminacion(UUID idHecho, String justificacion) {
        Hecho hechoReferenciado = webClient.get()
                .uri("/hechos/"+ idHecho)
                .retrieve()
                .bodyToMono(Hecho.class) // convierte el cuerpo en un mono 🐒
                .block();
        if (hechoReferenciado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el hecho con ID: " + idHecho);
        }
        return webClient.post()
                .uri("/solicitudes/" + idHecho)
                .bodyValue(new SolicitudEliminacion(idHecho, justificacion))
                .retrieve()
                .bodyToMono(SolicitudEliminacion.class)
                .block();
    }

}
