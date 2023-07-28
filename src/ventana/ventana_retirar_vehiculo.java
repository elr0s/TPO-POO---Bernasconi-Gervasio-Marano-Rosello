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
import exception.ReparacionException;
import obj.Reparacion;

public class ventana_retirar_vehiculo {
	public ventana_retirar_vehiculo() {
		Controlador controlador = Controlador.getInstancia();
    	JFrame ventanaRetirarVehiculo = new JFrame("Retirar Vehiculo");
    	ventanaRetirarVehiculo.setLayout(new GridLayout(0, 2));
    	
    	JLabel lblIdReparacion     = new JLabel("ID Reparacion: ");
        JTextField txtIdReparacion = new JTextField();
        JButton btnRetirar         = new JButton("Retirar");
     
    	btnRetirar.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			try {
    				int idReparacion = Integer.parseInt(txtIdReparacion.getText());
					Reparacion reparacion = controlador.buscarReparacion(idReparacion);
					try {
						float total = controlador.retirarVehiculo(reparacion);
						JOptionPane.showMessageDialog(ventanaRetirarVehiculo,"Ha retirado se vehiculo. El total de la reparacion es: "+total);
						ventanaRetirarVehiculo.dispose();
					}catch(ReparacionException e2) {
						JOptionPane.showMessageDialog(ventanaRetirarVehiculo, "Error: " + e2.getMessage());
						ventanaRetirarVehiculo.dispose();
					}catch(ClienteException e3) {
						JOptionPane.showMessageDialog(ventanaRetirarVehiculo, "Error: " + e3.getMessage());
						ventanaRetirarVehiculo.dispose();
					}
				} catch (ReparacionException e1) {
					JOptionPane.showMessageDialog(ventanaRetirarVehiculo, "Error: " + e1.getMessage());
					ventanaRetirarVehiculo.dispose();
				}
    		}
    	});
    	
    	ventanaRetirarVehiculo.add(lblIdReparacion);
    	ventanaRetirarVehiculo.add(txtIdReparacion);
    	ventanaRetirarVehiculo.add(btnRetirar);
    	
    	ventanaRetirarVehiculo.pack();
    	ventanaRetirarVehiculo.setVisible(true);
	}
	public static void main(String[] args) {
		ventana_retirar_vehiculo ventana = new ventana_retirar_vehiculo();
        }
}
