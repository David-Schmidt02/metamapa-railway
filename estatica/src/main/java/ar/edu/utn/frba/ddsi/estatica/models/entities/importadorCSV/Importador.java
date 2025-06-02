package ar.edu.utn.frba.ddsi.estatica.models.entities.importadorCSV;

import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public interface Importador {
    List<Hecho> importarHechosDeCSV(String nombreArchivo) throws IOException, CsvValidationException;
}
