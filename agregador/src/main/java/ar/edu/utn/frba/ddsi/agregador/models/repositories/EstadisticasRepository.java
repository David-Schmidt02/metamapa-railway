package ar.edu.utn.frba.ddsi.agregador.models.repositories;

import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EstadisticasRepository extends JpaRepository<Hecho, Integer> { // Pongo <Hecho, Integer> para poder usar JPA, pero el repo devuelve distintos tipos de dato.

    @Query( value = """
            SELECT h.latitud, h.longitud
            FROM hecho h
            JOIN fuente f ON h.url_fuente = f.url
            JOIN coleccion_fuente cf ON cf.fuente_url = f.url
            JOIN coleccion c ON cf.coleccion_id = c.id
            WHERE c.id = ?1
        """,
            nativeQuery = true)
    List<Ubicacion> obtenerUbicaciones(Integer id); // el WHERE c.coleccion_id = ?1 compara el id de la coleccion con el primer parametro que recibe el metodo.

    @Query( value = """ 
            SELECT h.detalle
            FROM Hecho h
            GROUP BY h.detalle
            ORDER BY count(h.detalle) DESC LIMIT 1
        """,
            nativeQuery = true)
    Categoria obtenerCategoriaConMasHechos();
}
