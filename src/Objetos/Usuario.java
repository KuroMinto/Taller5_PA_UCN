package Objetos;

public class Usuario {
    private String rut;
    private String nombre;
    private String apellido;
    private String pass;

    public Usuario(String rut, String nombre, String apellido, String pass) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPass() {
        return pass;
    }
}
