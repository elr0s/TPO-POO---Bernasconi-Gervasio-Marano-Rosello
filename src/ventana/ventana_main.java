package ventana;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ventana_main {
    private JFrame frame;
    private JButton btnRegistrarCliente;
    private JButton btnRegistrarReparacion;
    private JButton btnAgregarRepuesto;
    private JButton btnCalcularSueldo;
    private JButton btnAgregarManoDeObra;
    private JButton btnRegistrarVehiculo;
    private JButton btnBuscarCliente;
    private JButton btnRetirarVehiculo;

    public ventana_main() {
        frame = new JFrame("Ventana Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        btnRegistrarCliente = new JButton("Registrar Cliente");
        btnRegistrarReparacion = new JButton("Reparación");
        btnAgregarRepuesto = new JButton("Agregar Repuesto");
        btnAgregarManoDeObra = new JButton("Agregar Mano de Obra");
        btnRegistrarVehiculo = new JButton("Registrar Vehiculo");
        btnCalcularSueldo = new JButton("Calcular Sueldo");
        btnBuscarCliente = new JButton("Buscar Cliente");
        btnRetirarVehiculo = new JButton("Retirar Vehiculo"); 

        btnRetirarVehiculo.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		ventana_retirar_vehiculo ventana_retirar_vehiculo = new ventana_retirar_vehiculo(); 
        	}
        });
        
        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ventana_buscar_cliente ventana_buscar_cliente = new ventana_buscar_cliente();
            }
            });
        
        btnCalcularSueldo.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ventana_sueldo ventana_sueldo = new ventana_sueldo();
            }
        })
        		);

        // Acción del botón Registrar Cliente
        btnRegistrarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para registrar un cliente
            	ventana_registrar_vehiculo ventana_registrar_cliente = new ventana_registrar_vehiculo();
            }
        });
        // Acción del botón Registrar Cliente
        btnRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para registrar un cliente
            	ventana_cliente ventanaCliente = new ventana_cliente();
            }
        });

        // Acción del botón Registrar Reparación
        btnRegistrarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para registrar una reparación
                ventana_registrar_reparacion ventanaReparacion = new ventana_registrar_reparacion();
            }
        });

        // Acción del botón Agregar Repuesto
        btnAgregarRepuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para agregar un repuesto
                ventana_agregar_repusto ventanaRepuesto = new ventana_agregar_repusto();
            }
        });

        // Acción del botón Agregar Mano de Obra
        btnAgregarManoDeObra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para agregar mano de obra
                ventana_agreagar_mano_de_obra ventanaManoDeObra = new ventana_agreagar_mano_de_obra();
            }
        });

        // Agregar componentes a la ventana
        frame.add(btnRegistrarCliente);
        frame.add(btnRegistrarReparacion);
        frame.add(btnAgregarRepuesto);
        frame.add(btnAgregarManoDeObra);
        frame.add(btnRegistrarVehiculo);
        frame.add(btnCalcularSueldo);
        frame.add(btnRetirarVehiculo);

        // Ajustar tamaño y hacer visible la ventana
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ventana_main ventana = new ventana_main();
    }
}
