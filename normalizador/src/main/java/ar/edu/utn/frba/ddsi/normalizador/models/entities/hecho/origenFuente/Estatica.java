package ar.edu.utn.frba.ddsi.normalizador.models.entities.hecho.origenFuente;

import ar.edu.utn.frba.ddsi.normalizador.models.entities.archivoProcesado.ArchivoProcesado;
import lombok.Getter;

@Getter
public class Estatica extends OrigenFuente {
    private ArchivoProcesado archivoProcesado;

    public Estatica(ArchivoProcesado archivoProcesado) {
        super();
        this.archivoProcesado = archivoProcesado;
    }
}
