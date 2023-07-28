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
import exception.ManoDeObraException;
import exception.ReparacionException;


public class ventana_agreagar_mano_de_obra {
    private JFrame frame;
    private JButton btnAgregarManodeObra;
    private static Controlador controlador;

    public ventana_agreagar_mano_de_obra() {
    	Controlador controlador = Controlador.getInstancia();
    	JFrame ventanaAgregarManoDeObra = new JFrame("Agregar Mano De Obra");
    	ventanaAgregarManoDeObra.setLayout(new GridLayout(0, 2));
    	
    	JLabel lblIdCodigoManoDeObra     = new JLabel("ID Repuesto");
        JTextField txtIdCodigoManoDeObra = new JTextField();
        JLabel lblDuracion               = new JLabel("Duracion");
        JTextField txtDuracion           = new JTextField();
        JLabel lblIdReparacion           = new JLabel("ID Reparacion");
        JTextField txtIdReparacion       = new JTextField();
        JButton btnAgregarManoDeObra     = new JButton("Agregar Repuesto");
     
        btnAgregarManoDeObra.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int idReparacion       = Integer.parseInt(txtIdReparacion.getText());
    			int idCodigoManoDeObra = Integer.parseInt(txtIdCodigoManoDeObra.getText()); 
    			float duracion         = Float.parseFloat(txtDuracion.getText());
    			try {
    				controlador.agregarManoDeObra(idReparacion, idCodigoManoDeObra, duracion);
    				JOptionPane.showMessageDialog(ventanaAgregarManoDeObra,"Agregaste Mano de Obra a la reparacion; "+idReparacion);
    			}catch(ReparacionException e1) {
    				JOptionPane.showMessageDialog(ventanaAgregarManoDeObra, "Error: " + e1.getMessage());
    			} catch (ManoDeObraException e2) {
    				JOptionPane.showMessageDialog(ventanaAgregarManoDeObra, "Error: " + e2.getMessage());
				}
    		}
    	});
        ventanaAgregarManoDeObra.add(lblIdReparacion);
        ventanaAgregarManoDeObra.add(txtIdReparacion);
        ventanaAgregarManoDeObra.add(lblIdCodigoManoDeObra);
        ventanaAgregarManoDeObra.add(txtIdCodigoManoDeObra);
        ventanaAgregarManoDeObra.add(lblDuracion);
        ventanaAgregarManoDeObra.add(txtDuracion);
        ventanaAgregarManoDeObra.add(btnAgregarManoDeObra);
        
        ventanaAgregarManoDeObra.pack();
        ventanaAgregarManoDeObra.setVisible(true);
    }
    
    public static void main(String[] args) {
        ventana_agreagar_mano_de_obra ventana = new ventana_agreagar_mano_de_obra();
    }
   }

                    