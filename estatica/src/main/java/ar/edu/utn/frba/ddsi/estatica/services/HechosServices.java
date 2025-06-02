package ar.edu.utn.frba.ddsi.estatica.services;
import ar.edu.utn.frba.ddsi.estatica.models.entities.importadorCSV.ImportadorCSV;
import ar.edu.utn.frba.ddsi.estatica.models.repositories.HechosRepository;
import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class HechosServices implements IHechosServices{
    private HechosRepository hechosRepository;
    private final ResourceLoader resourceLoader; //Me permite abrir los recursos

    public HechosServices(HechosRepository hechosRepository, ResourceLoader resourceLoader) {
        this.hechosRepository = hechosRepository;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public List<Hecho> obtenerHechos() {
        return this.hechosRepository.findAll();
    }

    @Override
    public void importarHechosDesdeCSV(String nombreArchivo) throws IOException, CsvValidationException {
        ImportadorCSV importador = new ImportadorCSV();
        List<Hecho> hechosImportados = importador.importarHechosDeCSV(nombreArchivo);
        this.hechosRepository.addHechos(hechosImportados);
    }

    @PostConstruct
    @Override
    public void importarTodosHechosDesdeCSV() {
        try {
            ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader); // Es un buscador que encuentra los archivos con patron CSV
            Resource[] recursos = resolver.getResources("classpath:*.csv"); // Busca todos los archivos CSV en el classpath

            Arrays.stream(recursos).forEach(recurso -> {
                try {
                    String nombreArchivo = recurso.getFilename();
                    importarHechosDesdeCSV(nombreArchivo);
                } catch (Exception e) {
                    System.err.println("Error al importar archivo " + recurso.getFilename() + ": " + e.getMessage());
                }
            });

        } catch (Exception e) {
            System.err.println("Error al buscar archivos CSV: " + e.getMessage());
        }
    }



}
