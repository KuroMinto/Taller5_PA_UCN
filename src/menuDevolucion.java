import Objetos.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class menuDevolucion extends JDialog{
    private JTextField menuBLISBN;
    private JButton botonDevolver;
    private JButton menuPLRegresar;
    private JPanel jfMenuDevolucion;

    public menuDevolucion(JFrame parent) {
        super(parent);
        setTitle("Panel de Trabajo");
        setContentPane(jfMenuDevolucion);
        setMinimumSize(new Dimension(550, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        botonDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    prestarLibro();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        menuPLRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuInterno menuInterno1 = new menuInterno(null);
            }
        });

        setVisible(true);
    }

    private void prestarLibro() throws IOException {
        LinkedList<Libro> libros = LecturaArchivos.leerArchivoLibros();

        String isbn = menuBLISBN.getText();

        if (isbn.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese el ISBN del libro",
                    "Intentelo de nuevo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i< (libros != null ? libros.size() : 0); i++) {
            if (isbn.equals(libros.get(i).getIsbn())) {
                if (libros.get(i).getPaginas() > 0) {
                    JOptionPane.showMessageDialog(this,
                            "El libro ha sido devuelto con exito",
                            "Libro prestado",
                            JOptionPane.INFORMATION_MESSAGE);
                    actualizarLibros(libros,isbn);
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this,
                "El libro solicitado no existe",
                "Intentelo de nuevo",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    private void actualizarLibros(LinkedList<Libro> libros, String isbn) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt"));

        for (int i = 0; i< (libros != null ? libros.size() : 0); i++) {
            if (isbn.equals(libros.get(i).getIsbn())) {

                int numCopias = libros.get(i).getStock();
                libros.get(i).setStock(numCopias+1);
            }
        }

        for (int i = 0; i< (libros != null ? libros.size() : 0); i++) {
            isbn = libros.get(i).getIsbn();
            String titulo = libros.get(i).getTitle();
            String autor = libros.get(i).getAuthor();
            String categoria = libros.get(i).getCategoria();
            int cantPaginas = libros.get(i).getPaginas();
            int stock = libros.get(i).getStock();
            writer.write(isbn+","+titulo+","+autor+","+categoria+","+cantPaginas+","+stock);
            writer.newLine();
        }
        writer.close();
    }
}
