package ar.edu.utn.frba.ddsi.estadistica.service;

import ar.edu.utn.frba.ddsi.estadistica.models.entities.AgregadorClient;
import ar.edu.utn.frba.ddsi.estadistica.models.entities.Categoria;
import ar.edu.utn.frba.ddsi.estadistica.models.entities.Ubicacion;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.json.JSONObject;

import java.time.LocalTime;

@Service
public class EstadisticaService {

    private final AgregadorClient agregadorClient = new AgregadorClient("http://localhost:8080/api/agregador");

    public String obtenerProvinciaDeColeccion(Integer Id) {
        Ubicacion ubicacionMasFrecuenteColeccion = agregadorClient.obtenerUbicacionDeColeccion(Id);
        return convertirAProvincia(ubicacionMasFrecuenteColeccion); // Hay que implementar esto (pasar de una ubicacion a una provincia)
    }

    public Categoria obtenerCategoriaConMasHechos() {
        return this.agregadorClient.obtenerCategoriaConMasHechos();
    }

    public String obtenerProvinciaDeCategoria(Integer id) {
        Ubicacion ubicacionMasFrecuenteCategoria = agregadorClient.obtenerUbicacionDeCategoria(id);
        return convertirAProvincia(ubicacionMasFrecuenteCategoria);
    }

    public LocalTime obtenerHoraMasFrecuenteDeCategoria(Integer id) {
        return this.agregadorClient.obtenerHoraMasFrecuenteDeCategoria(id);
    }

    public String convertirAProvincia(Ubicacion unaUbicacion) {
        // Usamos una API q convierte lat y long en provincia
        // TODO: probar

        WebClient webClient = WebClient.builder()
                .baseUrl("https://nominatim.openstreetmap.org")
                .defaultHeader("User-Agent", "SpringGeocoder/1.0")
                .build();

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reverse")
                        .queryParam("lat", unaUbicacion.getLatitud())
                        .queryParam("lon", unaUbicacion.getLongitud())
                        .queryParam("format", "json")
                        .queryParam("addressdetails", "1")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONObject json = new JSONObject(response);
        JSONObject address = json.getJSONObject("address");
        return address.optString("state", "Provincia no encontrada");
    }

    public Integer obtenerCantidadDeSolicitudesSpam() {
        return this.agregadorClient.obtenerCantidadDeSolicitudesSpam();
    }
}
