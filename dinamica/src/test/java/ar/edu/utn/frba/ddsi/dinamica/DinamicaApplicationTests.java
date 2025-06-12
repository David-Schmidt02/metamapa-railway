package ar.edu.utn.frba.ddsi.dinamica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.*;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.personas.Anonimo;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.personas.Registrado;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.repositories.HechosRepository;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("removal")
@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HechosRepository hechosRepository;

    @Test
    void debeRetornarHechos() throws Exception {
        HechoTextual hecho1 = new HechoTextual(
                "Noticia importante",
                "Descripción de la noticia",
                new Categoria("Accidente"),
                new Ubicacion(34.6037, -58.3816),
                LocalDateTime.now().minusDays(1),
                List.of(new Etiqueta("urgente"), new Etiqueta("tránsito")),
                new Registrado("Juan Pérez", "juan@example.com", 30),
                "Contenido completo de la noticia con todos los detalles del accidente..."

        );

        HechoMultimedia hecho2 = new HechoMultimedia(
                "Evento cultural",
                "Descripción del evento",
                new Categoria("Cultura"),
                new Ubicacion(34.6037, -58.3816),
                LocalDateTime.now().minusDays(2),
                List.of(new Etiqueta("arte"), new Etiqueta("música")),
                Anonimo.getInstance(),
                List.of("https://example.com/image1.jpg", "https://example.com/video1.mp4")
        );

        Mockito.when(hechosRepository.findAll())
                .thenReturn(List.of(hecho1, hecho2));

        mockMvc.perform(get("/api/dinamica/hechos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].titulo").value("Noticia importante"))
                .andExpect(jsonPath("$[1].titulo").value("Evento cultural"));

    }
}