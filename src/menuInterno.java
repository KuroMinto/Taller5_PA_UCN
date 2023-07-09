import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuInterno extends JDialog{
    private JPanel menuInterno1;
    private JButton buscarLibroButton;
    private JButton prestarLibroButton;
    private JButton agregarNuevoLibroButton;
    private JButton devolverLibroButton;
    private JButton menuInternoReturn;

    public menuInterno(JFrame parent) {
        super(parent);
        setTitle("Panel de Trabajo");
        setContentPane(menuInterno1);
        setMinimumSize(new Dimension(550, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Metodo cuando el usuario quiere ir a buscar un libro
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuBuscarLibro buscarLibro = new menuBuscarLibro(null);
            }
        });
        //Metodo cuando el usuario quiere prestar un libro
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuPrestarLibro prestarLibro = new menuPrestarLibro(null);
            }
        });
        //Metodo cuando el usuario quiere agregar un libro nuevo
        agregarNuevoLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuAgregarLibro agregarLibro = new menuAgregarLibro(null);
            }
        });
        //Metodo cuando el usuario quiere recibir un libro que ha sido prestado
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuDevolucion devolverLibro = new menuDevolucion(null);
            }
        });
        //Metodo cuando el usuario quiere volver al menu de inicio de sesion
        menuInternoReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login inicial = new Login(null);
            }
        });
        setVisible(true);
    }
}
