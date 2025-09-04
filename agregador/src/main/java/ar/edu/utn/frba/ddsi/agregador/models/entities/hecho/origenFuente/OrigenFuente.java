package ar.edu.utn.frba.ddsi.agregador.models.entities.hecho.origenFuente;

public abstract class OrigenFuente {

    public static OrigenFuente getOrigenFuente(String tipo) {

        return switch (tipo) {
            case "DINAMICA" -> new Dinamica();
            case "PROXY" -> new Proxy();
            case "ESTATICA" -> new Estatica(null);

            default -> throw new IllegalArgumentException();
        };
    }

}
