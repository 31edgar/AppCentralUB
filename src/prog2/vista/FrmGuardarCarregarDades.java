package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

public class FrmGuardarCarregarDades extends JDialog implements Serializable {

    private JComboBox cmbxOption;
    private JPanel panel1;
    private JButton goButton;
    private final JFileChooser fileChooser;

    public FrmGuardarCarregarDades(JFrame parent) {

        super(parent, "Guardar i carregar dades", true);

        setSize(300, 200);
        setLocationRelativeTo(parent);

        setContentPane(panel1);
        fileChooser = new JFileChooser();

        // Usuari li dona a "enter"
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = cmbxOption.getSelectedIndex();
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

                            // Actualitzem la GUI (guardant la demanda)
                            AppCentralUB appCentralUB = new AppCentralUB();
                            appCentralUB.setDemandaText();
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


