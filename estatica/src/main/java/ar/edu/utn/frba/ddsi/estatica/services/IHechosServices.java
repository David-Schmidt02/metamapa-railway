package ar.edu.utn.frba.ddsi.estatica.services;

import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public interface IHechosServices {
    List<Hecho> obtenerHechos();
    void importarTodosHechosDesdeCSV();
    void importarHechosDesdeCSV(String nombreArchivo) throws IOException, CsvValidationException;
}
