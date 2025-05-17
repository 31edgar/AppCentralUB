package prog2.vista;

import javax.swing.*;

public class AppCentralUB extends JFrame{
    private JPanel panelCentralUB;
    private JLabel labelCentralUB;
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacioCentral;
    private JButton btnFinalitzarDia;
    private JButton btnGuardarICarregarDades;

    public AppCentralUB(){
        setTitle("App Central UB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelCentralUB);
        setSize(800,600);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB appCentralUB = new AppCentralUB();
            appCentralUB.setVisible(true);
        });
    }
}
