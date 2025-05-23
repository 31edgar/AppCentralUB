package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmGestioComponentsCentral extends JDialog {

    private JLabel etGestioComponents;
    private JTextField txtIntroduirInsercioBarresControl;
    private JSlider sldBarresControl;
    private JButton btnIntroduirInsercioBarresControl;
    private JLabel etBarresControl;
    private JButton btnAplicarModificacions;
    private JButton btnCancelarModificacions;
    private JLabel etComponents;
    private JCheckBox checkBomba0;
    private JCheckBox checkBomba2;
    private JCheckBox checkBomba1;
    private JCheckBox checkBomba3;
    private JPanel panelGestioComponentsCentral;
    private JCheckBox checkReactor;
    private JLabel etBombesForaDeServei;
    private JTextArea listBombesForaDeServei;

    public FrmGestioComponentsCentral(JFrame parent) {
        super(parent, "Gestió de components", true); // true = modal

        setSize(800, 600);
        setLocationRelativeTo(parent);
        setContentPane(panelGestioComponentsCentral);

        // Cada vegada que obrim la finestra, hem d'actualitzar les dades
        txtIntroduirInsercioBarresControl.setText(String.valueOf((int)Adaptador.getInsercioBarres()));
        sldBarresControl.setValue((int)Adaptador.getInsercioBarres());

        listBombesForaDeServei.append(Adaptador.mostraSistemaRefrigeracio());
        ArrayList<Boolean> bombes = Adaptador.getEstatBombes();

        checkBomba0.setSelected(bombes.get(0));
        checkBomba1.setSelected(bombes.get(1));
        checkBomba2.setSelected(bombes.get(2));
        checkBomba3.setSelected(bombes.get(3));
        checkReactor.setSelected(Adaptador.isReactorActivat());

        // Escoltadors
        btnIntroduirInsercioBarresControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nombre = Integer.parseInt(txtIntroduirInsercioBarresControl.getText());
                sldBarresControl.setValue(nombre);
            }
        });

        sldBarresControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sldBarresControl.getValue();
                txtIntroduirInsercioBarresControl.setText(String.valueOf(valor));
            }
        });

        btnCancelarModificacions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnAplicarModificacions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarDades();
                dispose();
            }
        });

    }

    void aplicarDades() {
        // Guardem el percentatge d'inserció de barres
        float insercioBarres = sldBarresControl.getValue();

        Adaptador.setInsercioBarres(insercioBarres);

        // Guardem l'estat de les bombes
        if (checkBomba0.isSelected())
            try{Adaptador.activaBomba(0);
            } catch (CentralUBException e){
                JOptionPane.showMessageDialog(
                        null,
                        "Error activant la bomba 0:\n" + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        else Adaptador.desactivaBomba(0);

        if (checkBomba1.isSelected())
            try{Adaptador.activaBomba(1);
            } catch (CentralUBException e){
                JOptionPane.showMessageDialog(
                        null,
                        "Error activant la bomba 1:\n" + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        else Adaptador.desactivaBomba(1);

        if (checkBomba2.isSelected())
            try{Adaptador.activaBomba(2);
            } catch (CentralUBException e){
                JOptionPane.showMessageDialog(
                        null,
                        "Error activant la bomba 2:\n" + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        else Adaptador.desactivaBomba(2);

        if (checkBomba3.isSelected())
            try{Adaptador.activaBomba(3);
            } catch (CentralUBException e){
                JOptionPane.showMessageDialog(
                        null,
                        "Error activant la bomba 3:\n" + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        else Adaptador.desactivaBomba(3);

        // Guardem l'estat del reactor
        if (checkReactor.isSelected())
            Adaptador.activaReactor();
        else Adaptador.desactivaReactor();
    }


}
