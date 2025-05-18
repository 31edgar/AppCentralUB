package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioComponentsVista extends JFrame {
    private JLabel labelGestioComponents;
    private JPanel panellGestioComponentsVista;
    private JSlider slider1;
    private JCheckBox checkBoxReactor;
    private JCheckBox checkBoxBomba1;
    private JCheckBox checkBoxBomba2;
    private JCheckBox checkBoxBomba3;
    private JCheckBox checkBoxBomba4;
    private JLabel labelSliderGestioComponents;
    private JLabel labelCBReactorGestioComponents;
    private JLabel labelCBBombesGestioComponents;

    public GestioComponentsVista() {
        setTitle("App Central UB");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setContentPane(panellGestioComponentsVista);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestioComponentsVista ap = new GestioComponentsVista();
            ap.setVisible(true);
        });
    }
}

