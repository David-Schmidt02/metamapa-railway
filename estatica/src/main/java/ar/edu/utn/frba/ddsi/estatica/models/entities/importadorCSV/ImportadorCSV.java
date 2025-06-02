package ar.edu.utn.frba.ddsi.estatica.models.entities.importadorCSV;

import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.estatica.models.entities.hecho.Ubicacion;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImportadorCSV implements Importador  {
    private static LectorCSV lector = new LectorCSV();

    public List<Hecho> importarHechosDeCSV(String nombreArchivo) throws IOException, CsvValidationException {
        List<String[]> filas = lector.leerCSV(nombreArchivo);
        List<Hecho> hechosImportados = new ArrayList<>();
        for (String[] fila : filas) {
            Hecho hecho = this.obtenerHechoPorFila(fila);
            hechosImportados.add(hecho);
        }
        return hechosImportados;
    }

    public Hecho obtenerHechoPorFila(String[] fila) {
        String titulo = fila[0].trim();
        String descripcion = fila[1].trim();
        String categoria = fila[2].trim();
        Double latitud = Double.parseDouble(fila[3].trim());
        Double longitud = Double.parseDouble(fila[4].trim());
        LocalDate fechaAcontecimiento = LocalDate.parse(fila[5].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Hecho hecho = new Hecho(titulo, descripcion, new Categoria(categoria), new Ubicacion(latitud, longitud), fechaAcontecimiento);
        return hecho;
    }
}
