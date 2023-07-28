package ventana;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Controlador;
import exception.ClienteException;
import exception.ReparacionException;
import exception.TecnicoException;
import exception.VehiculoException;
import obj.Cliente;
import obj.Reparacion;

public class ventana_registrar_reparacion {
    private JFrame frame;
    private JButton btnRegistrar;
    private JButton btnBuscarReparacion;
    private JButton btnFinalizarReparacion;
    private static Controlador controlador;

    public  ventana_registrar_reparacion() {
        frame = new JFrame("Registrar Reparación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        btnRegistrar = new JButton("Registrar Reparación");
        btnBuscarReparacion = new JButton("Buscar Reparación");
        btnFinalizarReparacion = new JButton("Finalizar Reparacion");
        
        btnFinalizarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	crearVentanaFinalizarReparacion();
            	frame.dispose();
            }	
            });
            
        // Acción del botón Registrar Reparación
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para ingresar los datos de la reparación
                crearVentanaRegistroReparacion();
                frame.dispose();
            }
        });

        // Acción del botón Buscar Reparación
        btnBuscarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para buscar la reparación por ID
                crearVentanaBuscarReparacion();
                frame.dispose();
            }
        });


        // Agregar componentes a la ventana
        frame.add(btnRegistrar);
        frame.add(btnBuscarReparacion);
        frame.add(btnFinalizarReparacion);
      

        // Ajustar tamaño y hacer visible la ventana
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Inicializar el controlador
        controlador = Controlador.getInstancia();
    }

    public void crearVentanaRegistroReparacion() {
        JFrame ventanaRegistro = new JFrame("Registro de Reparación");
        ventanaRegistro.setLayout(new GridLayout(0, 2));

        // Componentes de la ventana de registro
        JLabel lblDoc = new JLabel("Documento:");
        JLabel lblVehiculo = new JLabel("Patente:");
        JLabel lblDescripcion = new JLabel("Descripción:");
        JTextField txtDoc = new JTextField(20);
        JTextField txtVehiculo = new JTextField(20);
        JTextField txtDescripcion = new JTextField(20);

        JButton btnRegistrarReparacion = new JButton("Registrar Reparación");

        // Acción del botón Registrar Reparación
        btnRegistrarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados y registrar la reparación
                String doc = txtDoc.getText();
                String vehiculo = txtVehiculo.getText();
                String descripcion = txtDescripcion.getText();
                
                try {
                    // Validar si el cliente ya está registrado
                    if (!controlador.clienteRegistrado(doc)) {
                        JOptionPane.showMessageDialog(ventanaRegistro, "El cliente no está registrado.");
                        return;
                    }

                    // Registrar la reparación
                    int idReparacion = controlador.nuevaReparacion(doc, vehiculo);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(ventanaRegistro,
                            "Reparación registrada exitosamente. ID de reparación: " + idReparacion);
                    ventanaRegistro.dispose();
                } catch (ClienteException ex) {
                    JOptionPane.showMessageDialog(ventanaRegistro, "Error al registrar el cliente: " + ex.getMessage());
                    ventanaRegistro.dispose();
                } catch (VehiculoException e1) {
                	JOptionPane.showMessageDialog(ventanaRegistro,"Error no existe el vehiculo: "+e1);
                	ventanaRegistro.dispose();
                }
            }
        });

        // Agregar componentes a la ventana de registro
        ventanaRegistro.add(lblDoc);
        ventanaRegistro.add(txtDoc);
        ventanaRegistro.add(lblVehiculo);
        ventanaRegistro.add(txtVehiculo);
        ventanaRegistro.add(lblDescripcion);
        ventanaRegistro.add(txtDescripcion);
        ventanaRegistro.add(new JLabel()); // Espacio en blanco
        ventanaRegistro.add(btnRegistrarReparacion);

        // Ajustar tamaño y hacer visible la ventana de registro
        ventanaRegistro.pack();
        ventanaRegistro.setVisible(true);
    }

    public void crearVentanaBuscarReparacion() {
        JFrame ventanaBuscar = new JFrame("Buscar Reparación");
        ventanaBuscar.setLayout(new GridLayout(0, 2));

        // Componentes de la ventana de búsqueda
        JLabel lblIdReparacion = new JLabel("ID de Reparación:");
        JTextField txtIdReparacion = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");

        // Acción del botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el ID de reparación ingresado
                String idReparacionText = txtIdReparacion.getText();

                try {
                    int idReparacion = Integer.parseInt(idReparacionText);

                    // Buscar la reparación por ID
                    Reparacion reparacion = controlador.buscarReparacion(idReparacion);

                    // Obtener el cliente de la reparación
                    Cliente cliente = reparacion.getCliente();

                    // Obtener el documento del cliente
                    String docCliente = cliente.getDoc();

                    // Obtener la fecha de la reparación
                    LocalDate fechaReparacion = reparacion.getFecha();

                    // Formatear la fecha
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fechaFormateada = fechaReparacion.format(formatter);

                    // Mostrar el mensaje de datos
                    String mensajeCompleto = "Datos de la reparación:\n\n" +
                            "Cliente: " + cliente.getNombre() + "\n" +
                            "Documento: " + docCliente + "\n" +
                            "Vehículo: " + reparacion.getVehiculo().getPatente() + "\n" +
                            "Fecha: " + fechaFormateada;

                    JOptionPane.showMessageDialog(ventanaBuscar, mensajeCompleto);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventanaBuscar, "El ID de reparación debe ser un número entero.");
                } catch (ReparacionException e1) {
                    JOptionPane.showMessageDialog(ventanaBuscar, e1.getMessage());
                }
            }
        });

        // Agregar componentes a la ventana de búsqueda
        ventanaBuscar.add(lblIdReparacion);
        ventanaBuscar.add(txtIdReparacion);
        ventanaBuscar.add(new JLabel()); // Espacio en blanco
        ventanaBuscar.add(btnBuscar);

        // Ajustar tamaño y hacer visible la ventana de búsqueda
        ventanaBuscar.pack();
        ventanaBuscar.setVisible(true);
    }
    public void crearVentanaFinalizarReparacion() {
        Controlador controlador = Controlador.getInstancia();
    	JFrame ventanaRegistro = new JFrame("Registro de Reparación");
        ventanaRegistro.setLayout(new GridLayout(0, 2));

        // Componentes de la ventana de registro
        JLabel lblIDReparacion = new JLabel("ID reparacion:");
        JTextField txtIDReparacion = new JTextField(20);

        JButton btnFinalizarReparacion = new JButton("Finalizar Reparación");

        // Acción del botón Registrar Reparación
        btnFinalizarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados y registrar la reparación
                int idReparacion = Integer.parseInt(txtIDReparacion.getText());
                
                try {
                	controlador.terminarReparacion(idReparacion);
                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(ventanaRegistro,
                            "Reparación finalizada exitosamente. ID de reparación: " + idReparacion);
                    ventanaRegistro.dispose();
                }catch (ReparacionException e1) {
                	JOptionPane.showMessageDialog(ventanaRegistro, "Error: " + e1.getMessage());
                    ventanaRegistro.dispose();
				}
            }
        });

        // Agregar componentes a la ventana de registro
        ventanaRegistro.add(lblIDReparacion);
        ventanaRegistro.add(txtIDReparacion);
        ventanaRegistro.add(new JLabel()); // Espacio en blanco
        ventanaRegistro.add(btnFinalizarReparacion);

        // Ajustar tamaño y hacer visible la ventana de registro
        ventanaRegistro.pack();
        ventanaRegistro.setVisible(true);
        }
    
    
    public static void main(String[] args) {
    	ventana_registrar_reparacion ventana = new ventana_registrar_reparacion();
    }
	
}