package ar.edu.utn.frba.ddsi.estatica.models.entities.importador;

import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.estatica.models.entities.importador.lector.Lector;
import ar.edu.utn.frba.ddsi.estatica.models.entities.importador.lector.LectorCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

@Component
public class Importador {
    private final LectorCSV lectorCSV;
    private final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    private final Map<String, Lector> lectores = new HashMap<>();
    private final String[] patrones = {"classpath:*.csv"};


    public Importador() {
        // TODO decidir cuando / donde instanciar los lectores
        this.lectorCSV = new LectorCSV();
        lectores.put("csv", lectorCSV
        );
        // En el futuro aca agregariamos mas importadores segun el tipo de archivo
    }

    public List<Hecho> importarHechos() {
        List<Hecho> hechosImportados = new ArrayList<>();

        try {
            Resource[] recursos = resolver.getResources("classpath:archivos/*");
            for (Resource recurso : recursos) {
                String filename = recurso.getFilename();
                try {
                    List<Hecho> hechosDesdeArchivo = importarSegunArchivo(recurso);
                    hechosImportados.addAll(hechosDesdeArchivo);
                } catch (Exception e) {
                    System.err.println("Error al procesar el recurso " + filename + ": " + e.getMessage());
                    continue; // Continuar con el siguiente recurso en caso de error
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return hechosImportados;

    }
    /*
    private List<Hecho> importarSegunArchivo(Resource recurso) throws Exception {
        String extensionArchivo = recurso.getFilename().substring(recurso.getFilename().lastIndexOf(".") + 1).toLowerCase();
        switch (extensionArchivo) {
            case "csv":
                return importadorCSV.importarCSV(recurso.getFilename());
            default:
                throw new Exception("Formato de archivo no soportado: " + extensionArchivo);
        }

    }
*/
    private List<Hecho> importarSegunArchivo(Resource recurso) throws Exception {
        String extension = recurso.getFilename().substring(recurso.getFilename().lastIndexOf(".") + 1).toLowerCase();
        Lector lector = lectores.get(extension);
        if (lector == null) {
            throw new Exception("Formato de archivo no soportado: " + extension);
        }
        return lector.leerArchivo(recurso);
    }
}
