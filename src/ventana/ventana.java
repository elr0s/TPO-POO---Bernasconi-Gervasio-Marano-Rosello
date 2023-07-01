package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// CREAR ARRAY PARA QUE NO REPITAN LOS ID
// QUE SE GENEREN SOLOS LOS ID (I++1)
// EN LA ESTRUCTURA "BUSCAR" VALIDAR Q EXISTA EL ID Y SINO IMPRIMIR MENSAJE DE Q NO EXISTE Y QUE SE MUESTREN LOS DATOS ASOCIADOS AL ID RERPARACION 
// AGREGAR EL PACKAGE DE LOS OBJETOS PARA VALIDAR QUE CORRESPONDAN A SU TIPO Y ADPATARLOS A LOS QUE SE INGRESAN ACA

public class ventana {
    private JFrame frame;
    private JButton registrarBtn;
    private JButton buscarBtn;

    public ventana() {
        frame = new JFrame("Sistema de Reparaciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        registrarBtn = new JButton("Registrar Reparación");
        buscarBtn = new JButton("Buscar Reparación");

        //estructurta para registrar
        registrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registrarFrame = new JFrame("Registrar Reparación");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                // CASILLAS DE TXT
                JTextField dato1 = new JTextField(20);
                JTextField dato2 = new JTextField(20);
                JTextField dato3 = new JTextField(20);
                JTextField dato4 = new JTextField(20);
                JTextField dato5 = new JTextField(20);
                JTextField dato6 = new JTextField(20);
                
                //BOTON BUSCAR
                JButton registrarButton = new JButton("Registrar");

                //ATRIBUTOS
                panel.add(new JLabel("Doc:"));
                panel.add(dato1);
                panel.add(new JLabel("ID de Reparacion:"));
                panel.add(dato2);
                panel.add(new JLabel("FechaIngreso de reparacion:"));
                panel.add(dato3);
                panel.add(new JLabel("Descripcion de ManoDeObra:"));
                panel.add(dato4);
                panel.add(new JLabel("Patente del vehiculo:"));
                panel.add(dato5);
                panel.add(new JLabel("Empleado a cargo:"));
                panel.add(dato6);
                panel.add(registrarButton);

                registrarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //aca agregar la lógica para procesar los datos ingresados y registrar la reparación
                        JOptionPane.showMessageDialog(null, "Reparación registrada exitosamente.");
                        registrarFrame.dispose();
                    }
                });

                registrarFrame.add(panel);
                registrarFrame.setSize(300, 300);
                registrarFrame.setVisible(true);
            }
        });

        //estructurta para buscar reparacionn
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame buscarFrame = new JFrame("Buscar Reparación");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                // CASILLAS DE TXT
                JTextField datoBusqueda1 = new JTextField(20);
                
                // BOTON BUSCAR
                JButton buscarButton = new JButton("Buscar");

                //ATRIBUTO
                panel.add(new JLabel("ID de Reparacion:"));
                panel.add(datoBusqueda1);

                panel.add(buscarButton);

                buscarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // aca la lógica para buscar utilizando los datos ingresados
                        // y mostrar los resultados correspondientes
                        JOptionPane.showMessageDialog(null, "Resultados de búsqueda:\n" +
                                "ID de Reparacion:: " + datoBusqueda1.getText() + "\n");
                        buscarFrame.dispose();
                    }
                });

                buscarFrame.add(panel);
                buscarFrame.setSize(300, 300);
                buscarFrame.setVisible(true);
            }
        });

        frame.add(registrarBtn);
        frame.add(buscarBtn);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    
}



