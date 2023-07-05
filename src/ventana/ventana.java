package ventana;

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

    public ventana() {
        frame = new JFrame("Registrar Reparación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblCliente = new JLabel("Cliente:");
        JLabel lblVehiculo = new JLabel("Vehículo:");
        txtCliente = new JTextField(20);
        txtVehiculo = new JTextField(20);
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
