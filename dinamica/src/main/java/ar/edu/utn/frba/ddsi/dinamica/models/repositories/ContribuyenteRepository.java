package ar.edu.utn.frba.ddsi.dinamica.models.repositories;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.personas.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Integer> {

}
