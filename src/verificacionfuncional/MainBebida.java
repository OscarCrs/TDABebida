package verificacionfuncional;

import javax.swing.*;
import java.awt.*;

/**
 * Autor: Oscar Cortes Solares
 * Propósito: Ventana interactiva Swing para manipular el TDA BebidaCafe.
 */
public class MainBebida extends JFrame {

    private BebidaCafe miCafe;
    private final JTextArea txtConsola;

    public MainBebida() {
        // Objeto TDA inicializado
        miCafe = new BebidaCafe("Cappuccino EduCafé", "Arábica", 45.0, 20);

        // Ventana
        setTitle("Gestión de BebidaCafe - TDA");
        setSize(560, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Cabecera
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(41, 128, 185));
        JLabel lblAutor = new JLabel("Autor: Oscar Cortes Solares | Universidad Tecnológica de la Huasteca Hidalguense");
        lblAutor.setForeground(Color.WHITE);
        lblAutor.setFont(new Font("SansSerif", Font.BOLD, 11));
        panelHeader.add(lblAutor);
        add(panelHeader, BorderLayout.NORTH);

        // Consola
        txtConsola = new JTextArea();
        txtConsola.setEditable(false);
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(txtConsola), BorderLayout.CENTER);

        // Botones de los métodos del TDA
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 8, 8));

        JButton btnVender = new JButton("Vender 1 Unidad");
        JButton btnAbastecer = new JButton("Abastecer 5 Unidades");
        JButton btnValorTotal = new JButton("Calcular Valor Inventario");
        JButton btnFidelidad = new JButton("Precio Fidelidad (Recursivo)");

        btnVender.addActionListener(e -> {
            if (miCafe.vender(1)) {
                log("Venta realizada con éxito. Stock restante de " + miCafe.getNombre() + ": " + miCafe.getCantidadStock() + " unidades.");
            } else {
                log("Error: Stock insuficiente.");
            }
        });

        btnAbastecer.addActionListener(e -> {
            miCafe.abastecer(5);
            log("Inventario abastecido. Nuevo stock: " + miCafe.getCantidadStock() + " unidades.");
        });

        btnValorTotal.addActionListener(e -> {
            double total = miCafe.calcularValorInventario();
            log("Valor total del inventario: $" + String.format("%.2f", total));
        });

        btnFidelidad.addActionListener(e -> {
            double precioFinal = miCafe.calcularPrecioFidelidadRecursivo(3, miCafe.getPrecioBase());
            log("Precio original: $" + miCafe.getPrecioBase() + " | Con nivel 3 de fidelidad recursivo: $" + String.format("%.2f", precioFinal));
        });

        panelBotones.add(btnVender);
        panelBotones.add(btnAbastecer);
        panelBotones.add(btnValorTotal);
        panelBotones.add(btnFidelidad);

        add(panelBotones, BorderLayout.SOUTH);

        log("=== SISTEMA INICIADO ===");
        log("Producto: " + miCafe.getNombre() + " | Grano: " + miCafe.getTipoGrano() + " | Precio: $" + miCafe.getPrecioBase() + " | Stock: " + miCafe.getCantidadStock());
    }

    private void log(String texto) {
        txtConsola.append("> " + texto + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainBebida().setVisible(true);
        });
    }
}
