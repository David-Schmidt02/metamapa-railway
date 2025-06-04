package ar.edu.utn.frba.ddsi.dinamica.models.entities.personas;

public class Contribuyente {
    private String nombre;
    private String email;
    private int edad;

    public Contribuyente(String nombre, String email, int edad){
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }
}
