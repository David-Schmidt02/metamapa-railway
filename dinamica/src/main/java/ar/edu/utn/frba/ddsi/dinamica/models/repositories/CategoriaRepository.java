package ar.edu.utn.frba.ddsi.dinamica.models.repositories;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Categoria;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.personas.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Categoria findCategoriaByDetalle(String detalle);
}
