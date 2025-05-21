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
    private JList listBombesForaDeServei;
    private JLabel etBombesForaDeServei;

    public FrmGestioComponentsCentral(JFrame parent) {
        super(parent, "Gestió de components", true); // true = modal

        setSize(800, 600);
        setLocationRelativeTo(parent);

        setContentPane(panelGestioComponentsCentral);

        txtIntroduirInsercioBarresControl.setText(String.valueOf((int)Adaptador.getInsercioBarres()));
        sldBarresControl.setValue((int)Adaptador.getInsercioBarres());

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
                guardarDades();
                dispose();
            }
        });


    }

    void guardarDades() {
        // Guardem el percentatge d'inserció de barres
        float insercioBarres = sldBarresControl.getValue();

        Adaptador.setInsercioBarres(insercioBarres);

        // Guardem l'estat de les bombes -------------------- CAL LLENÇAR EXCEPCIO AMB JDIALOG I AFEGIR SI FORA DE SERVEI BLABLABLA
        if (checkBomba0.isSelected()) Adaptador.activaBomba(0);
        else Adaptador.desactivaBomba(0);

        if (checkBomba1.isSelected()) Adaptador.activaBomba(1);
        else Adaptador.desactivaBomba(1);

        if (checkBomba2.isSelected()) Adaptador.activaBomba(2);
        else Adaptador.desactivaBomba(2);

        if (checkBomba3.isSelected()) Adaptador.activaBomba(3);
        else Adaptador.desactivaBomba(3);

        // Guardem l'estat del reactor
        if (checkReactor.isSelected()) Adaptador.activaReactor();
        else Adaptador.desactivaReactor();
    }


}
