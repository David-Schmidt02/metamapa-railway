package ar.edu.utn.frba.ddsi.proxy.conexionDemo;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Hecho;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ConexionEjemplo implements Conexion {

    private URL url;

    @Override
    public Map<String, Object> siguienteHecho(URL url, LocalDate fechaUltimaConsulta) {

        return Map.of();
    }

    @Override
    public URL url() {
        return url;
    }
}