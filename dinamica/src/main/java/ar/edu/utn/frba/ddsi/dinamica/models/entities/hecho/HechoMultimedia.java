package ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.personas.Contribuyente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HechoMultimedia extends Hecho {
    private List<String> contenidoMultimedia;

    public HechoMultimedia(String titulo,
                           String descripcion,
                           Categoria categoria,
                           Ubicacion ubicacion,
                           LocalDateTime fechaAcontecimiento,
                           List<Etiqueta> etiquetas,
                           UUID contribuyente_id,
                           List<String> contenidoMultimedia) {

        super(titulo, descripcion, categoria, ubicacion, fechaAcontecimiento, etiquetas, contribuyente_id);

        this.contenidoMultimedia = contenidoMultimedia;
    }
}
