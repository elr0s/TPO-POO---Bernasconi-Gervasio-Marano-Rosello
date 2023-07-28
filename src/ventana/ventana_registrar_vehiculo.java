package ventana;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Controlador;
import exception.ClienteException;

public class ventana_registrar_vehiculo {
	private JFrame frame;
    private JButton btnRegistrarVehiculo;
    
    private static Controlador controlador;
	public ventana_registrar_vehiculo() {
		Controlador controlador = Controlador.getInstancia();
    	JFrame ventanaRegistro = new JFrame("Registro de Vehiculo");
        ventanaRegistro.setLayout(new GridLayout(0, 2));

        // Componentes de la ventana de registro
        JLabel lblPatente  = new JLabel("Patente:");
        JLabel lblMarca    = new JLabel("Marca:");
        JLabel lblModelo   = new JLabel("Modelo:");
        JLabel lblAño      = new JLabel("Año:");
        JLabel lblDocDueño = new JLabel("Doc Dueño:");

        JTextField txtPatente  = new JTextField(20);
        JTextField txtMarca    = new JTextField(20);
        JTextField txtModelo   = new JTextField(20);
        JTextField txtAño      = new JTextField(20);
        JTextField txtDocDueño = new JTextField(20);
        
        JButton btnRegistrarVehiculo = new JButton("Registrar Vehiculo");
        
        btnRegistrarVehiculo.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		 String patente     = txtPatente.getText();
        		 String marca       = txtMarca.getText();
        	     String modelo      = txtModelo.getText();
        	     int año            = Integer.parseInt(txtAño.getText());
        	     String docDueño = txtDocDueño.getText();
        	     
        	     try {
					controlador.registrarVehiculo(patente, marca, modelo, año, docDueño);
					JOptionPane.showMessageDialog(ventanaRegistro, "Se ha registrado el vehiculo con exito");
				} catch (ClienteException e1) {
					JOptionPane.showMessageDialog(ventanaRegistro, "Error: " + e1.getMessage());
				}
            }
        });
        
        ventanaRegistro.add(lblPatente);
        ventanaRegistro.add(txtPatente);
        ventanaRegistro.add(lblMarca);
        ventanaRegistro.add(txtMarca);
        ventanaRegistro.add(lblModelo);
        ventanaRegistro.add(txtModelo);
        ventanaRegistro.add(lblAño);
        ventanaRegistro.add(txtAño);
        ventanaRegistro.add(lblDocDueño);
        ventanaRegistro.add(txtDocDueño);
        ventanaRegistro.add(new JLabel());
        ventanaRegistro.add(btnRegistrarVehiculo);

        // Ajustar tamaño y hacer visible la ventana de búsqueda
        ventanaRegistro.pack();
        ventanaRegistro.setVisible(true);
	}
	public static void main(String[] args) {
		ventana_registrar_vehiculo ventana_registrar_cliente = new ventana_registrar_vehiculo();
    }
}
