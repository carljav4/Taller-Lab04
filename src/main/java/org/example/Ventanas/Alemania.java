package org.example.Ventanas;

import javax.swing.*;
import java.awt.*;
import modelo.AlemaniaModel;

public class Alemania extends JFrame {
    private JTextArea textArea;
    private AlemaniaModel alemaniaModel;

    public Alemania() {
        alemaniaModel = new AlemaniaModel();

        setTitle("Equipo de Alemania");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocation(1350, 0);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        JButton guardarButton = new JButton("Guardar cambios");
        JButton salirButton = new JButton("Cerrar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);
        buttonPanel.add(salirButton);

        guardarButton.addActionListener(e -> alemaniaModel.guardarCambios(textArea.getText(), "C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\ger.txt"));

        salirButton.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        textArea.setText(alemaniaModel.cargarEquipoDesdeArchivo("C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\ger.txt"));
    }
}
