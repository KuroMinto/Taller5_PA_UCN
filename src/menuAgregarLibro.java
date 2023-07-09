import Objetos.Libro;
import ucn.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class menuAgregarLibro extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton menuPLRegresar;
    private JButton agregarBtn;
    private JPanel jfAgregar;

    public menuAgregarLibro(JFrame parent) {
        super(parent);
        setTitle("Panel de Trabajo");
        setContentPane(jfAgregar);
        setMinimumSize(new Dimension(550, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizarLibros();
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

    private void actualizarLibros() throws IOException {
        LinkedList<Libro> libros = LecturaArchivos.leerArchivoLibros();

        String isbn;
        String titulo;
        String autor;
        String categoria;
        int cantPaginas;
        int stock;

        if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese el parametro faltante.",
                    "Intentelo de nuevo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Libro libro : libros) {
            if (textField1.getText().equals(libro.getIsbn())) {
                JOptionPane.showMessageDialog(this,
                        "El libro ya existe",
                        "Intentelo de nuevo",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt"));

        for (Libro libro : libros) {
            isbn = libro.getIsbn();
            titulo = libro.getTitle();
            autor = libro.getAuthor();
            categoria = libro.getCategoria();
            cantPaginas = libro.getPaginas();
            stock = libro.getStock();
            writer.write(isbn + "," + titulo + "," + autor + "," + categoria + "," + cantPaginas + "," + stock);
            writer.newLine();
        }

        isbn = textField1.getText();
        titulo = textField2.getText();
        autor = textField3.getText();
        categoria = textField4.getText();
        cantPaginas = Integer.parseInt(textField5.getText());
        writer.write(isbn+","+titulo+","+autor+","+categoria+","+cantPaginas+","+1);
        writer.close();
    }
}
