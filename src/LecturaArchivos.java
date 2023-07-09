import Objetos.Libro;
import Objetos.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * @author Marcelo Céspedes.
 */
public class LecturaArchivos {

    /*
        Para la correcta lectura de los archivos, estos deben estar en la carpeta del proyecto, fuera
        de la carpeta "src".
     */

    /**
     * Método encargado de leer el archivo de "libros.txt".
     */
    public static LinkedList<Libro> leerArchivoLibros() {

        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            LinkedList<Libro> listaLibros = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                Libro newLibro = new Libro(isbn,title,author,category,copies,price);
                listaLibros.add(newLibro);
            }
            return listaLibros;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     */
    public static LinkedList<Usuario> leerArchivoUsuarios() {

        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            LinkedList<Usuario> listaUsuarios = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                Usuario newUser = new Usuario(rut,name,lastname,password);
                listaUsuarios.add(newUser);
            }
            return listaUsuarios;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }
}