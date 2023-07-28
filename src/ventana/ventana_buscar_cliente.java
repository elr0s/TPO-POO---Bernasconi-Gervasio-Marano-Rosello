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
import obj.Cliente;

public class ventana_buscar_cliente {
	private JFrame frame;
	private JButton btnBuscar;
	private static Controlador controlador;
	
	public ventana_buscar_cliente() {
		Controlador controlador =  Controlador.getInstancia();
		JFrame ventanaBuscarCliente = new JFrame("Buscar Cliente");
		ventanaBuscarCliente.setLayout(new GridLayout(0,2));
		
		JLabel lblDoc = new JLabel("Documento del cliente");
		JTextField txtDoc = new JTextField();
		JButton btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente c = controlador.buscarCliente(txtDoc.getText());
					String mensajeCompleto = "Datos de la reparación:\n\n" +
                            "Cliente: " + c.getNombre() + "\n" +
                            "Documento: " + c.getDoc() + "\n"+
                            "Cuenta Corriente: " + c.getCtaCte()+ "\n" +
                            "Limite: " + c.getLimiteCtaCte() + "\n";
                    JOptionPane.showMessageDialog(ventanaBuscarCliente, mensajeCompleto);
				} catch (ClienteException e1) {
					e1.printStackTrace();
				}	
			}
		});
		ventanaBuscarCliente.add(lblDoc);
		ventanaBuscarCliente.add(txtDoc);
		ventanaBuscarCliente.add(btnBuscar);
		ventanaBuscarCliente.pack();
		ventanaBuscarCliente.setVisible(true);
		
	}
	
	public static void main(String[] args) {
        ventana_buscar_cliente ventana = new ventana_buscar_cliente();
        }
}
