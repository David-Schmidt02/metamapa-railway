package ar.edu.utn.frba.ddsi.estatica.models.entities.importador.lector;

import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import org.springframework.core.io.Resource;

import java.util.List;

public interface Lector {

    List<Hecho> leerArchivo(Resource recurso) throws Exception;

}
