package Modulos;
import Objetos.Libro;
import Objetos.Usuario;
import edu.princeton.cs.stdlib.*;

import java.util.LinkedList;

public class SistemaImpl implements Sistema{
    public SistemaImpl() {
    }

    @Override
    public Libro buscarLibro(LinkedList<Libro> listaLibros , String isbn) {
        for (int i=0; i<listaLibros.size()-1;i++) {
            if (listaLibros.get(i) == null) {
                return null;
            }

            if (listaLibros.get(i).getIsbn().equals(isbn)) {
                return listaLibros.get(i);
            }
        }
        return null;
    }

    @Override
    public void prestarLibro() {

    }

    @Override
    public void agregarLibro() {

    }

    @Override
    public void devolverLibro() {

    }

    @Override
    public void cerrarSesion() {

    }
}
