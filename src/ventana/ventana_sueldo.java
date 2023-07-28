package ventana;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Controlador;

import exception.TecnicoException;

public class ventana_sueldo {
    private JFrame frame;
    private JButton btnCalcularSueldo;

    private static Controlador controlador;

    public ventana_sueldo() {
    	Controlador controlador = Controlador.getInstancia();
        JFrame ventanaCalcularSueldo = new JFrame("Calcular Sueldo");
        ventanaCalcularSueldo.setLayout(new GridLayout(0, 2));

        JLabel lbldniTecnico = new JLabel("DNI");
        JTextField txtDni = new JTextField();
        JButton btnCalcular = new JButton("Calcular");

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = txtDni.getText();
                try {
                    double sueldo = controlador.calcularSueldo(dni);
                    JOptionPane.showMessageDialog(btnCalcular, sueldo);
                } catch (TecnicoException ex) {
                    JOptionPane.showMessageDialog(ventanaCalcularSueldo, "Error: " + ex.getMessage());
                }
            }
        });

        ventanaCalcularSueldo.add(lbldniTecnico);
        ventanaCalcularSueldo.add(txtDni);
        ventanaCalcularSueldo.add(new JLabel());
        ventanaCalcularSueldo.add(btnCalcular);

        // Ajustar tamaño y hacer visible la ventana de búsqueda
        ventanaCalcularSueldo.pack();
        ventanaCalcularSueldo.setVisible(true);
    }

    public static void main(String[] args) {
        ventana_sueldo ventana = new ventana_sueldo();
    }
}
