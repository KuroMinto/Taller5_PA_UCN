import Objetos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Login extends JDialog{

    private JTextField jfRut;
    private JPasswordField jfPass;
    private JButton jfBtnLogin;
    private JPanel jfLoginPanel;
    private JButton jfBtnClose;

    public Login(JFrame parent) {
        super(parent);
        setTitle("Inicio de Sesion de Usuarios");
        setContentPane(jfLoginPanel);
        setMinimumSize(new Dimension(550, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jfBtnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
        jfBtnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    private void buscarUsuario() {
        LinkedList<Usuario> usuarios = LecturaArchivos.leerArchivoUsuarios();
        String rut = jfRut.getText();
        String password = String.valueOf(jfPass.getPassword());

        if (rut.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese todos los datos correctamente.",
                    "Intentelo de nuevo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i< (usuarios != null ? usuarios.size() : 0) -1; i++) {
            if (rut.equals(usuarios.get(i).getRut()) && password.equals(usuarios.get(i).getPass())) {
                setVisible(false);
                menuInterno menuInterno1 = new menuInterno(null);
                return;
            }
        }
        JOptionPane.showMessageDialog(this,
                "Usuario no perteneciente al sistema." +
                        "\nIntentelo de nuevo.",
                "Usuario no existente",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
}
