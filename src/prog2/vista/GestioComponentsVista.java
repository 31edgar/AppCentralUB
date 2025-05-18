package prog2.vista;

import prog2.adaptador.Adaptador;

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

        // Escoltadors ------------------------------------------------------------------------------------------------
        // Gestionar reactor
        checkBoxReactor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxReactor.isSelected()) Adaptador.activaReactor();
                else Adaptador.desactivaReactor();
            }
        });

        // Gestionar bomba 1
        checkBoxBomba1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxBomba1.isSelected()) Adaptador.activaBomba(0);
                else Adaptador.desactivaBomba(0);
            }
        });

        // Gestionar bomba 2
        checkBoxBomba2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxBomba2.isSelected()) Adaptador.activaBomba(1);
                else Adaptador.desactivaBomba(1);
            }
        });

        // Gestionar bomba 3
        checkBoxBomba3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxBomba3.isSelected()) Adaptador.activaBomba(2);
                else Adaptador.desactivaBomba(2);
            }
        });

        // Gestionar bomba 4
        checkBoxBomba4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxBomba4.isSelected()) Adaptador.activaBomba(3);
                else Adaptador.desactivaBomba(3);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestioComponentsVista ap = new GestioComponentsVista();
            ap.setVisible(true);
        });
    }
}

