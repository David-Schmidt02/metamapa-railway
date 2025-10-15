package ar.edu.utn.frba.ddsi.dinamica.models.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
public class ImagenesRepository {

    private WebClient webClient;

    @Value("${supabase.url}")
    private String baseUrl;

    @Value("${supabase.bucket}")
    private String bucket;

    @Value("${supabase.service-key}")
    private String serviceKey;

    public ImagenesRepository() {
        this.webClient = WebClient.builder()
                .build();

    }

    public String cargarImagenSupabase(MultipartFile file) {
        String nombreArchivo = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String url = baseUrl + "/storage/v1/object/" + bucket + "/" + nombreArchivo;
        try {
            webClient.post()
                    .uri(url) // La URL base ya incluye el bucket
                    .header("Authorization", "Bearer " + serviceKey)
                    .header("Content-Type", file.getContentType())
                    .bodyValue(file.getBytes())
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

            return nombreArchivo;
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar la imagen: " + e.getMessage());
        }
    }




}
