package ar.edu.utn.frba.ddsi.dinamica.models.entities.repositories;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion.SolicitudEliminacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SolicitudesRepository {
    private final List<SolicitudEliminacion> solicitudes = new ArrayList<>();

    public void save(SolicitudEliminacion nuevaSolicitud){
        solicitudes.add(nuevaSolicitud);
    }


















}
