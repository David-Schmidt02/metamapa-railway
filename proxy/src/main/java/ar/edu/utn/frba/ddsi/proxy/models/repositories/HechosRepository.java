package ar.edu.utn.frba.ddsi.proxy.models.repositories;

import ar.edu.utn.frba.ddsi.proxy.models.entities.Hecho.Hecho;
import ar.edu.utn.frba.ddsi.proxy.conexionDemo.Conexion;
import ar.edu.utn.frba.ddsi.proxy.conexionDemo.ConexionHelper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class HechosRepository {

    private Map<String, Conexion> conexiones = new HashMap<>(); // Clave: nombreConexion, Valor: objeto Conexion
    private Map<String, List<Hecho>> hechos = new HashMap<>();  // Clave: nombreConexion, Valor: lista de hechos


    @PostConstruct // IMPORTANTE: esto se ejecuta cuando arranca la aplicacion y llena la lista de hechos segun conexion
    public void obtenerHechos() {

        for (String nombre : conexiones.keySet()) {
            Conexion conexion = conexiones.get(nombre);
            List<Hecho> hechosDeConexion = ConexionHelper.getInstance().obtenerHechos(conexion);
            if (hechosDeConexion != null && !hechosDeConexion.isEmpty()) {
                this.hechos.put(nombre, hechosDeConexion);
            }
        }
    }

    public List<Hecho> findByName(String nombreConexion) {
        return this.hechos.get(nombreConexion);
    } // Get a la lista de hechos de una conexion específica

    public void registrarHechos(String nombreConexion, List<Hecho> listaDeHechos) {
        this.hechos.put(nombreConexion, listaDeHechos);
    }
}


