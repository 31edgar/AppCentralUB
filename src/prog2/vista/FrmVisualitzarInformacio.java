package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVisualitzarInformacio extends JDialog{
    private JPanel panelVisualitzarInformacio;
    private JLabel etVisualitzarInformacio;
    private JLabel etOpcionsVisualitzar;

    private JComboBox cmboxOpcionsVisualitzar;

    private JButton btnVisualitzar;
    private JTextArea textAreaVisualitzaInformacio;

    public FrmVisualitzarInformacio (JFrame parent) {
        super(parent, "Visualitzar Informació", true);

        setSize(800, 600);
        setLocationRelativeTo(parent);

        setContentPane(panelVisualitzarInformacio);

        // Escoltadors
        btnVisualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = cmboxOpcionsVisualitzar.getSelectedIndex();

                String text = switch (index) {
                    case 0 -> Adaptador.mostraEstatCentral();
                    case 1 -> Adaptador.mostraBitacola();
                    case 2 -> Adaptador.mostraIncidencies();
                    default -> "";
                };

                textAreaVisualitzaInformacio.setText(text);
            }
        });
    }
}
