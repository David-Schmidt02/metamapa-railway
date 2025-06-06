package ar.edu.utn.frba.ddsi.dinamica.services;

import ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos.HechoMultimediaDTO;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos.HechoTextualDTO;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.dtos.SolicitudDTO;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.Hecho;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.HechoMultimedia;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.hecho.HechoTextual;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.repositories.DinamicaRepository;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion.Estado_Solicitud;
import org.springframework.stereotype.Service;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.solicitudEliminacion.SolicitudEliminacion;
import ar.edu.utn.frba.ddsi.dinamica.models.entities.repositories.SolicitudesRepository;

import java.util.UUID;

@Service
public class DinamicaService {
    private final DinamicaRepository dinamicaRepository;
    private final SolicitudesRepository solicitudesRepository;

    public DinamicaService(DinamicaRepository dinamicaRepository, SolicitudesRepository solicitudesRepository) {
        this.dinamicaRepository = dinamicaRepository;
        this.solicitudesRepository = solicitudesRepository;
    }

    // <---------------------------------- CREACION DE HECHOS ---------------------------------->

    public void crearHecho(Object hechoDTO) {
        if (hechoDTO instanceof HechoTextualDTO) {
            crearHechoTextual((HechoTextualDTO) hechoDTO);
        } else if (hechoDTO instanceof HechoMultimediaDTO) {
            crearHechoMultimedia((HechoMultimediaDTO) hechoDTO);
        } else {
            throw new IllegalArgumentException("Tipo de hecho no soportado");
        }
    }


    public void crearHechoTextual(HechoTextualDTO hechoDTO) {
        HechoTextual hecho = new HechoTextual(
            hechoDTO.getTitulo(),
            hechoDTO.getDescripcion(),
            hechoDTO.getCategoria(),
            hechoDTO.getUbicacion(),
            hechoDTO.getFechaAcontecimiento(),
            hechoDTO.getEtiquetas(),
            hechoDTO.getContribuyente(),
            hechoDTO.getCuerpo()
        );

        dinamicaRepository.save(hecho);
    }

    public void crearHechoMultimedia(HechoMultimediaDTO hechoDTO) {

        HechoMultimedia hecho = new HechoMultimedia(
            hechoDTO.getTitulo(),
            hechoDTO.getDescripcion(),
            hechoDTO.getCategoria(),
            hechoDTO.getUbicacion(),
            hechoDTO.getFechaAcontecimiento(),
            hechoDTO.getEtiquetas(),
            hechoDTO.getContribuyente(),
            hechoDTO.getContenidoMultimedia()
        );

        dinamicaRepository.save(hecho);
    }

    // <---------------------------------- ACTUALIZACION DE HECHOS ---------------------------------->

    public void actualizarHecho(UUID id, Object hechoDTO) {
        if (hechoDTO instanceof HechoTextualDTO) {
            actualizarHechoTextual(id, (HechoTextualDTO) hechoDTO);
        } else if (hechoDTO instanceof HechoMultimediaDTO) {
            actualizarHechoMultimedia(id, (HechoMultimediaDTO) hechoDTO);
        } else {
            throw new IllegalArgumentException("Tipo de hecho no soportado");
        }
    }


    public void actualizarHechoTextual(UUID id, HechoTextualDTO hechoDTO) {
            Hecho hechoAEditar = dinamicaRepository.findById(id);

            if (hechoAEditar == null) {
                throw new IllegalArgumentException("Hecho no encontrado con ID: " + id);
            }


            HechoTextual hechoTextualEditar = (HechoTextual) hechoAEditar;


            if (hechoTextualEditar.esEditable()) {
                hechoTextualEditar.setTitulo(hechoDTO.getTitulo());
                hechoTextualEditar.setDescripcion(hechoDTO.getDescripcion());
                hechoTextualEditar.setCategoria(hechoDTO.getCategoria());
                hechoTextualEditar.setUbicacion(hechoDTO.getUbicacion());
                hechoTextualEditar.setFechaAcontecimiento(hechoDTO.getFechaAcontecimiento());
                hechoTextualEditar.setEtiquetas(hechoDTO.getEtiquetas());
                hechoTextualEditar.setContribuyente(hechoDTO.getContribuyente());
                hechoTextualEditar.setCuerpo(hechoDTO.getCuerpo());

                dinamicaRepository.save(hechoTextualEditar);
            } else {
                throw new RuntimeException("El hecho no es editable");
            }
    }

    public void actualizarHechoMultimedia(UUID id, HechoMultimediaDTO hechoDTO) {
        Hecho hechoAEditar = dinamicaRepository.findById(id);

        if (hechoAEditar == null) {
            throw new IllegalArgumentException("Hecho no encontrado con ID: " + id);
        }


        HechoMultimedia hechoMultimediaEditar = (HechoMultimedia) hechoAEditar;


        if (hechoMultimediaEditar.esEditable()) {
            hechoMultimediaEditar.setTitulo(hechoDTO.getTitulo());
            hechoMultimediaEditar.setDescripcion(hechoDTO.getDescripcion());
            hechoMultimediaEditar.setCategoria(hechoDTO.getCategoria());
            hechoMultimediaEditar.setUbicacion(hechoDTO.getUbicacion());
            hechoMultimediaEditar.setFechaAcontecimiento(hechoDTO.getFechaAcontecimiento());
            hechoMultimediaEditar.setEtiquetas(hechoDTO.getEtiquetas());
            hechoMultimediaEditar.setContribuyente(hechoDTO.getContribuyente());
            hechoMultimediaEditar.setContenidoMultimedia(hechoDTO.getContenidoMultimedia());

            dinamicaRepository.save(hechoMultimediaEditar);
        } else {
            throw new RuntimeException("El hecho no es editable");
        }
    }

    public void crearSolicitudEliminacion(SolicitudDTO solicitud) {

        //TODO: El detector de spam iria aca?

        SolicitudEliminacion nuevaSolicitudEliminacion = new SolicitudEliminacion(
            solicitud.getId(),
            solicitud.getJustificacion()
        );

        if (!nuevaSolicitudEliminacion.esCorrecta()) {
            throw new IllegalArgumentException("La justificación debe tener al menos 500 caracteres.");
        }

        Hecho hechoAeliminar = dinamicaRepository.findById(nuevaSolicitudEliminacion.getIdHecho());

        if (hechoAeliminar == null) {
            throw new IllegalArgumentException("Hecho no encontrado con ID: " + nuevaSolicitudEliminacion.getIdHecho());
        }

        solicitudesRepository.save(nuevaSolicitudEliminacion);
    }

    public void modificarEstadoSolicitud(UUID id, Estado_Solicitud nuevoEstado) {
        //TODO: Implementar la lógica para modificar el estado de una solicitud de eliminación
    }
}





