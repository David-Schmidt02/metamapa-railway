package ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HechoMultimediaDTO extends HechoDTO{
    private List<String> contenidoMultimedia;
}
