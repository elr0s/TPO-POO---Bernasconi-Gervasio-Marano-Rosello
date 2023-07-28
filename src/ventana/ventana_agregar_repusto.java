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
import exception.ReparacionException;
import exception.RepuestoException;


public class ventana_agregar_repusto {
    private JFrame frame;
    private JButton btnAgregarRepuesto;
    private static Controlador controlador;

    public ventana_agregar_repusto() {
    	Controlador controlador = Controlador.getInstancia();
    	JFrame ventanaAgregarRepuesto = new JFrame("Agregar Repuesto");
    	ventanaAgregarRepuesto.setLayout(new GridLayout(0, 2));
    	
    	JLabel lblIdRespuesto       = new JLabel("ID Repuesto");
        JTextField txtIdRespuesto   = new JTextField();
        JLabel lblCantidad          = new JLabel("Cantidad");
        JTextField txtCantidad      = new JTextField();
        JLabel lblIdReparacion      = new JLabel("ID Reparacion");
        JTextField txtIdReparacion  = new JTextField();
        JButton btnAgregarRespuesto = new JButton("Agregar Repuesto");
     
        btnAgregarRespuesto.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int idReparacion = Integer.parseInt(txtIdReparacion.getText());
    			int idRepuesto   = Integer.parseInt(txtIdRespuesto.getText()); 
    			int cantidad     = Integer.parseInt(txtCantidad.getText());
    			try {
    				controlador.agregarRepuesto(idReparacion, idRepuesto, cantidad);
    				JOptionPane.showMessageDialog(ventanaAgregarRepuesto,"Agregaste un repuesto a la reparacion; "+idReparacion);
    			}catch(RepuestoException e1) {
    				JOptionPane.showMessageDialog(ventanaAgregarRepuesto, "Error: " + e1.getMessage());
    			} catch (ReparacionException e2) {
    				JOptionPane.showMessageDialog(ventanaAgregarRepuesto, "Error: " + e2.getMessage());
				}
    		}
    	});
        ventanaAgregarRepuesto.add(lblIdReparacion);
        ventanaAgregarRepuesto.add(txtIdReparacion);
        ventanaAgregarRepuesto.add(lblIdRespuesto);
        ventanaAgregarRepuesto.add(txtIdRespuesto);
        ventanaAgregarRepuesto.add(lblCantidad);
        ventanaAgregarRepuesto.add(txtCantidad);
        ventanaAgregarRepuesto.add(btnAgregarRespuesto);
        
        ventanaAgregarRepuesto.pack();
        ventanaAgregarRepuesto.setVisible(true);
    }
    
    public static void main(String[] args) {
        ventana_agregar_repusto ventana = new ventana_agregar_repusto();
    }
   }

                    