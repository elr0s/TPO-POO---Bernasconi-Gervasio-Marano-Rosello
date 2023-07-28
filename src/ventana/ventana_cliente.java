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
import javax.swing.SwingUtilities;

import controlador.Controlador;
import exception.ClienteException;


public class ventana_cliente {
    private JFrame frame;
    private JButton btnRegistrarCliente;

    private static Controlador controlador;

    public ventana_cliente() {
    	Controlador controlador = Controlador.getInstancia();
    	JFrame ventanaRegistro = new JFrame("Registro de Cliente");
        ventanaRegistro.setLayout(new GridLayout(0, 2));

        // Componentes de la ventana de registro
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblTipoDoc = new JLabel("Tipo de Documento:");
        JLabel lblDoc = new JLabel("Documento:");

        JTextField txtNombre = new JTextField(20);
        JTextField txtTipoDoc = new JTextField(20);
        JTextField txtDoc = new JTextField(20);

        JButton btnRegistrarCliente = new JButton("Registrar Cliente");

            // Acción del botón Registrar Cliente
            btnRegistrarCliente.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener los datos ingresados
                    String nombre = txtNombre.getText();
                    String tipoDoc = txtTipoDoc.getText();
                    String doc = txtDoc.getText();

                    // Registrar el cliente
                    try {
						controlador.registrarCliente(nombre, tipoDoc, doc, 0, 0);
						JOptionPane.showMessageDialog(ventanaRegistro, "Cliente registrado exitosamente.");
					} catch (ClienteException e1) {
						JOptionPane.showMessageDialog(ventanaRegistro, e1);
					}
                }
            });

            // Agregar componentes a la ventana de registro
            ventanaRegistro.add(lblNombre);
            ventanaRegistro.add(txtNombre);
            ventanaRegistro.add(lblTipoDoc);
            ventanaRegistro.add(txtTipoDoc);
            ventanaRegistro.add(lblDoc);
            ventanaRegistro.add(txtDoc);
            ventanaRegistro.add(new JLabel()); // Espacio en blanco
            ventanaRegistro.add(btnRegistrarCliente);

            // Ajustar tamaño y hacer visible la ventana de registro
            ventanaRegistro.pack();
            ventanaRegistro.setVisible(true);
        
    }
}