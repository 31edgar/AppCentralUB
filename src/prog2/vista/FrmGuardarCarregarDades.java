package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

public class FrmGuardarCarregarDades extends JDialog implements Serializable {
    public FrmGuardarCarregarDades(JFrame parent) {
        super(parent, "Guardar i carregar dades", true);

        setSize(300, 200);
        setLocationRelativeTo(parent);

        // Creem objectes
        JPanel panelOpcionsVisualitzar = new JPanel();
        JComboBox<String> cmboxOpcionsVisualitzar = new JComboBox<>(new String[]{"Guardar dades de la central actual", "Carregar dades d'una central guardada"});
        JButton btnEnter = new JButton("Enter");
        JFileChooser fileChooser = new JFileChooser();

        // Afegim els objectes al panel
        panelOpcionsVisualitzar.add(cmboxOpcionsVisualitzar);
        panelOpcionsVisualitzar.add(btnEnter);

        setContentPane(panelOpcionsVisualitzar);

        // Usuari li dona a "enter"
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = cmboxOpcionsVisualitzar.getSelectedIndex();
                File file;

                switch (index) {
                    case 0: // Guardar Central
                        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                            file = fileChooser.getSelectedFile();
                            Adaptador.guardaDades(file.getAbsolutePath());
                            JOptionPane.showMessageDialog(null, "Central guardada correctament.");
                            dispose();
                        }
                        break;

                    case 1: // Carregar Central
                        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            file = fileChooser.getSelectedFile();
                            Adaptador.carregaDades(file.getAbsolutePath());
                            JOptionPane.showMessageDialog(null, "Central carregada correctament.");
                            dispose();

                            AppCentralUB appCentralUB = new AppCentralUB();
                            appCentralUB.setVisible(true);
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opció no reconeguda");
                }
            }
        });
    }
}

