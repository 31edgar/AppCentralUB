package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame{
    // Atributs
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

    // Constructor
    public AppCentralUB(){
        setTitle("App Central UB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelCentralUB);
        setSize(800,600);
        setLocationRelativeTo(null);

        // --------- ESCOLTADORS ----------------------------------------------------
        // Gestió components
        btnGestioComponentsCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestioComponentsVista gestio = new GestioComponentsVista();
                gestio.setVisible(true);
            }
        });

        // Visualitzar informació
        btnVisualitzarInformacioCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                VisualitzarInformacioVista visualitzar = new VisualitzarInformacioVista();
                visualitzar.setVisible(true);
                 */
            }
        });

        // Finalitzar dia
        btnFinalitzarDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB appCentralUB = new AppCentralUB();
            appCentralUB.setVisible(true);
        });
    }
}
