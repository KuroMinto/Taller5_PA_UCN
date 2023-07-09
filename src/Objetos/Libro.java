package Objetos;

public class Libro {
    private final String isbn;
    private final String title;
    private final String author;
    private final String categoria;
    private final int paginas;
    private int stock;

    /**
     *
     * @param isbn del libro
     * @param title del libro
     * @param author del libro
     * @param categoria del libro
     * @param paginas del libro
     * @param stock del libro
     */
    public Libro(String isbn, String title, String author, String categoria, int paginas, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.categoria = categoria;
        this.paginas = paginas;
        this.stock = stock;
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

    public int getPaginas() {
        return paginas;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
