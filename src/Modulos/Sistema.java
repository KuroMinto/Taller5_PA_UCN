package Modulos;

import Objetos.Libro;
import Objetos.Usuario;
import java.util.LinkedList;

public interface Sistema {
    Libro buscarLibro(LinkedList<Libro> listaLibros , String isbn);

    void prestarLibro();

    void agregarLibro();

    void devolverLibro();

    void cerrarSesion();
}
