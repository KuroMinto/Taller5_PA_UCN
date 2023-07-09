package Objetos;

public class Libro {
    private final String isbn;
    private final String title;
    private final String author;
    private final String categoria;
    private int copias;
    private final int precio;

    public Libro(String isbn, String title, String author, String categoria, int copias, int precio) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.categoria = categoria;
        this.copias = copias;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCopias() {
        return copias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
}
