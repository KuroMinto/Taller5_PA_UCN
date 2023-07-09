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
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                menuBuscarLibro buscarLibro = new menuBuscarLibro(null);
            }
        });
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Menu de prestar libro
            }
        });
        agregarNuevoLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Menu de agregar nuevo libro
            }
        });
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Menu de devolverLibro
            }
        });
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
