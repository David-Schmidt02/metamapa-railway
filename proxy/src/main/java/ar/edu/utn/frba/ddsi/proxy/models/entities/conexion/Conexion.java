package ar.edu.utn.frba.ddsi.proxy.models.entities.conexion;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Categoria;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Origen_Fuente;
import ar.edu.utn.frba.ddsi.proxy.models.entities.Ubicacion;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public interface Conexion {
    public Map<String, Object> siguienteHecho(URL url, LocalDate fechaUltimaConsulta);
    public URL url();
}