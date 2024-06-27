package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Seleccionar Equipo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton chileButton = new JButton("Chile", new ImageIcon("C:\\Users\\diego\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\chi.png"));
        JButton australiaButton = new JButton("Australia", new ImageIcon("C:\\Users\\diego\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\aus.png"));
        JButton alemaniaButton = new JButton("Alemania", new ImageIcon("C:\\Users\\diego\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\ger.png"));
        JButton cmrButton = new JButton("Camerún", new ImageIcon("C:\\Users\\diego\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\cmr.png"));
        JButton salirButton = new JButton("Salir");

        panel.add(chileButton);
        panel.add(australiaButton);
        panel.add(alemaniaButton);
        panel.add(cmrButton);
        panel.add(salirButton);

        chileButton.addActionListener(e -> abrirVentanaEquipo("Chile"));
        australiaButton.addActionListener(e -> abrirVentanaEquipo("Australia"));
        alemaniaButton.addActionListener(e -> abrirVentanaEquipo("Alemania"));
        cmrButton.addActionListener(e -> abrirVentanaEquipo("Camerún"));
        salirButton.addActionListener(e -> System.exit(0));

        add(panel);
    }

    private void abrirVentanaEquipo(String equipo) {
        JFrame ventanaEquipo;
        switch (equipo) {
            case "Chile":
                ventanaEquipo = new Chile();
                break;
            case "Australia":
                ventanaEquipo = new Australia();
                break;
            case "Alemania":
                ventanaEquipo = new Alemania();
                break;
            case "Camerún":
                ventanaEquipo = new CMR();
                break;
            default:
                ventanaEquipo = new JFrame("Equipo no encontrado");
                break;
        }
        ventanaEquipo.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);
        });
    }
}