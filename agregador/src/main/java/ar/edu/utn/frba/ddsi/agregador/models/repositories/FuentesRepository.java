package ar.edu.utn.frba.ddsi.agregador.models.repositories;

import ar.edu.utn.frba.ddsi.agregador.models.entities.coleccion.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuentesRepository extends JpaRepository<Fuente, String> {
    Fuente findFuenteByNombre(String nombre);

    
}
