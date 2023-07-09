import Objetos.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class menuBuscarLibro extends JDialog {

    private JPanel menuBuscarLibro;
    private JTextField menuBLISBN;
    private JButton botonBuscan;
    private JLabel menu1Nombre;
    private JLabel menu1Autor;
    private JLabel menu1Categoria;
    private JLabel menu1CantPags;
    private JLabel menu1Stock;
    private JTextArea textPane1;
    private JTextArea textPane2;
    private JTextArea textPane3;
    private JTextArea textPane4;
    private JTextArea textPane5;
    private JButton regresarBtn;

    public menuBuscarLibro(JFrame parent) {
        super(parent);
        setTitle("Panel de Trabajo");
        setContentPane(menuBuscarLibro);
        setMinimumSize(new Dimension(550, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        botonBuscan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLibro();
            }
        });
        regresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuInterno menuInterno1 = new menuInterno(null);
            }
        });
        setVisible(true);
    }

    private void mostrarLibro() {
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
                String titulo = libros.get(i).getTitle();
                String autor = libros.get(i).getAuthor();
                String categoria = libros.get(i).getCategoria();
                String copias = String.valueOf(libros.get(i).getPaginas());
                String stock = String.valueOf(libros.get(i).getStock());
                textPane1.setText(titulo);
                textPane2.setText(autor);
                textPane3.setText(categoria);
                textPane4.setText(copias);
                textPane5.setText(stock);
                return;
            }
        }

        JOptionPane.showMessageDialog(this,
                "El libro solicitado no existe",
                "Intentelo de nuevo",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
}
