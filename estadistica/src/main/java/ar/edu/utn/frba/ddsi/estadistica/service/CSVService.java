package ar.edu.utn.frba.ddsi.estadistica.service;

import ar.edu.utn.frba.ddsi.estadistica.models.entities.Categoria;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class CSVService {


    public ResponseEntity<?> convertirACSV(Map<Integer, String> resultados, String nombreArchivo) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("Id,Provincia\n");
        resultados.forEach((key, value) -> csvBuilder.append(key).append(",").append(value).append("\n"));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+nombreArchivo+".csv")
                .contentType(MediaType.valueOf("text/csv"))
                .body(csvBuilder.toString());
    }

    public ResponseEntity<?> convertirHorasACSV(Map<Integer, LocalTime > resultados, String nombreArchivo) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("idCategoria,Hora\n");
        resultados.forEach((key, value) -> csvBuilder.append(key).append(",").append(value).append("\n"));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+nombreArchivo+".csv")
                .contentType(MediaType.valueOf("text/csv"))
                .body(csvBuilder.toString());
    }


    public ResponseEntity<?> convertirACSV(Categoria resultado, String nombreArchivo) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("idCategoria,detalle\n");
        csvBuilder.append(resultado.getId())
                .append(",")
                .append(resultado.getDetalle())
                .append("\n");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+nombreArchivo+".csv")
                .contentType(MediaType.valueOf("text/csv"))
                .body(csvBuilder.toString());
    }

    public CSVService() {
    }
}
