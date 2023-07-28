package ventana;

import controlador.Controlador;
import exception.ClienteException;
import exception.VehiculoException;
import obj.*;
import exception.*;


import javax.swing.*;

import controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;


public class ventana {
    private JFrame frame;
    private JTextField txtCliente;
    private JTextField txtVehiculo;
    private JButton btnRegistrar;

    private JButton btnBuscarReparacion;

    public ventana() {
        frame = new JFrame("Registrar Reparación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblCliente = new JLabel("Cliente:");
        JLabel lblVehiculo = new JLabel("Vehículo:");
        txtCliente = new JTextField(20);
        txtVehiculo = new JTextField(20);

        btnRegistrar = new JButton("Registrar Reparación");
        btnBuscarReparacion = new JButton("Buscar Reparación");

        // Acción del botón Registrar Reparación
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una nueva ventana para ingresar los datos de la reparación
                crearVentanaRegistroReparacion();
            }
        });

        // Agregar componentes a la ventana
        //frame.add(lblCliente);
        //frame.add(txtCliente);
        //frame.add(lblVehiculo);
        //frame.add(txtVehiculo);
        frame.add(btnRegistrar);
        frame.add(btnBuscarReparacion);

        // Ajustar tamaño y hacer visible la ventana
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void crearVentanaRegistroReparacion() {
        JFrame ventanaRegistro = new JFrame("Registro de Reparación");
        ventanaRegistro.setLayout(new FlowLayout());

        // Componentes de la ventana de registro
        JLabel lblCliente          = new JLabel("Cliente:");
        JLabel lblVehiculo         = new JLabel("Vehículo:");
        JTextField txtNombre       = new JTextField(20);
        JTextField txtDoc          = new JTextField(20);
        JTextField txtTipoDoc      = new JTextField(20);
        JTextField txtCtaCte       = new JTextField(20);
        JTextField txtLimiteCtaCte = new JTextField(20);
        JTextField txtVehiculo     = new JTextField(20);

        JButton btnRegistrar   = new JButton("Registrar");

        // Acción del botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados
                String cliente  = txtNombre.getText();
                String tipoDni  = txtTipoDoc.getText();
                String dni      = txtDoc.getText();
                float  ctaCte         = Float.parseFloat(txtCtaCte.getText());
                float  LimiteCtaCte   = Float.parseFloat(txtLimiteCtaCte.getText());
                String vehiculo = txtVehiculo.getText();

                try {
                    // Validar si el cliente ya está registrado
                    if (Controlador.getInstancia().clienteRegistrado(dni)) {
                        JOptionPane.showMessageDialog(ventanaRegistro, "El cliente ya está registrado.");
                        return;
                    }

                    // Registrar un nuevo cliente
                    Controlador.getInstancia().registrarCliente(cliente,tipoDni,dni,ctaCte,LimiteCtaCte);

                    // Validar si el vehículo está registrado
                    if (!Controlador.getInstancia().vehiculoRegistrado(vehiculo)) {
                        JOptionPane.showMessageDialog(ventanaRegistro, "El vehículo no está registrado. Por favor, registre el vehículo antes de continuar.");
                        return;
                    }

                    // Crear una nueva reparación
                    int idReparacion = Controlador.getInstancia().nuevaReparacion(cliente, vehiculo);

                    JOptionPane.showMessageDialog(ventanaRegistro, "Reparación registrada con éxito. ID de Reparación: " + idReparacion);
                } catch (VehiculoException ex) {
                    JOptionPane.showMessageDialog(ventanaRegistro, "Error al buscar el vehículo: " + ex.getMessage());
                } catch (ClienteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Agregar componentes a la ventana de registro
        ventanaRegistro.add(lblCliente);
        ventanaRegistro.add(txtCliente);
        ventanaRegistro.add(lblVehiculo);
        ventanaRegistro.add(txtVehiculo);
        ventanaRegistro.add(btnRegistrar);

        // Ajustar tamaño y hacer visible la ventana de registro
        ventanaRegistro.setSize(300, 200);
        ventanaRegistro.setVisible(true);
    


        btnRegistrar = new JButton("Registrar");

        // Acción del botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados
                String cliente = txtCliente.getText();
                String vehiculo = txtVehiculo.getText();

                try {
                    // Validar si el cliente está registrado
                    if (!Controlador.getInstancia().clienteRegistrado(cliente)) {
                        JOptionPane.showMessageDialog(frame, "El cliente no está registrado. Por favor, registre al cliente antes de continuar.");
                        return;
                    }

                    // Validar si el vehículo está registrado
                    if (!Controlador.getInstancia().vehiculoRegistrado(vehiculo)) {
                        JOptionPane.showMessageDialog(frame, "El vehículo no está registrado. Por favor, registre el vehículo antes de continuar.");
                        return;
                    }

                    // Obtener instancias de Cliente y Vehiculo
                    /*Cliente clienteObj = Controlador.getInstancia().buscarCliente(cliente);
                    Vehiculo vehiculoObj = Controlador.getInstancia().buscarVehiculo(vehiculo);
                    */


                    // Crear una nueva reparación
                    int idReparacion = Controlador.getInstancia().nuevaReparacion(cliente, vehiculo);

                    JOptionPane.showMessageDialog(frame, "Reparación registrada con éxito. ID de Reparación: " + idReparacion);
                } catch (ClienteException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al buscar el cliente: " + ex.getMessage());
                } catch (VehiculoException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al buscar el vehículo: " + ex.getMessage());
                }
            }
        });

        // Agregar componentes a la ventana
        frame.add(lblCliente);
        frame.add(txtCliente);
        frame.add(lblVehiculo);
        frame.add(txtVehiculo);
        frame.add(btnRegistrar);

        // Ajustar tamaño y hacer visible la ventana
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

