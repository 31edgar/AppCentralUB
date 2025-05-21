package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame{
    // Atributs
    public final static float DEMANDA_MAX = 1800;
    public final static float DEMANDA_MIN = 250;
    public final static float VAR_NORM_MEAN = 1000;
    public final static float VAR_NORM_STD = 800;
    public final static long VAR_NORM_SEED = 123;

    private VariableNormal variableNormal;
    private float demandaPotencia;

    private JPanel panelCentralUB;
    private JLabel labelCentralUB;
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacioCentral;
    private JButton btnFinalitzarDia;
    private JButton btnGuardarICarregarDades;
    private JPanel panellDadesMenuPrincipal;
    private JLabel labelNDiaMenuPrincipal;
    private JLabel labelDemandaMenuPrincipal;
    private JLabel labelGuanysMenuPrincipal;
    private JLabel demanda;
    private JLabel guanys;
    private JLabel dia;

    // Constructor
    public AppCentralUB(){
        variableNormal = new VariableNormal(VAR_NORM_MEAN, VAR_NORM_STD, VAR_NORM_SEED);
        demandaPotencia = generaDemandaPotencia();

        setTitle("App Central UB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelCentralUB);
        setSize(800,600);
        setLocationRelativeTo(null);

        demanda.setText(String.valueOf(demandaPotencia));
        dia.setText(String.valueOf(Adaptador.getDia()));
        guanys.setText(String.valueOf(Adaptador.getGuanysAcumulats()));

        // --------- ESCOLTADORS ----------------------------------------------------

        // Visualitzar informació
        btnVisualitzarInformacioCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarInformacio visualitzarInformacio = new FrmVisualitzarInformacio(AppCentralUB.this);
                visualitzarInformacio.setLocationRelativeTo(null);
                visualitzarInformacio.setVisible(true);
            }
        });

        // Gestionar components central
        btnGestioComponentsCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioComponentsCentral gestioComponents = new FrmGestioComponentsCentral(AppCentralUB.this);
                gestioComponents.setLocationRelativeTo(null);
                gestioComponents.setVisible(true);
            }
        });

        // Finalitzar dia
        btnFinalitzarDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Finalitzem el dia i guardem la bitàcola del dia
                String text = Adaptador.finalitzaDia(demandaPotencia);

                // Generem la demanda
                demandaPotencia = generaDemandaPotencia();

                // Actualitzem les dades
                demanda.setText(String.valueOf(demandaPotencia));
                dia.setText(String.valueOf(Adaptador.getDia()));
                guanys.setText(String.valueOf(Adaptador.getGuanysAcumulats()));

                // Mostrem la bitàcola del dia
                JOptionPane.showMessageDialog(
                        null,
                        text,
                        "Bitàcola del dia",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    private float generaDemandaPotencia(){
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > DEMANDA_MAX)
            return DEMANDA_MAX;
        else
        if (valor < DEMANDA_MIN)
            return DEMANDA_MIN;
        else
            return valor;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB appCentralUB = new AppCentralUB();
            appCentralUB.setVisible(true);
        });
    }
}
