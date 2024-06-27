package org.example.Ventanas;

import javax.swing.*;
import java.awt.*;
import modelo.ChileModel;

public class Chile extends JFrame {
    private JTextArea textArea;
    private ChileModel chileModel;

    public Chile() {
        chileModel = new ChileModel();

        setTitle("Equipo de Chile");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocation(450, 0);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        JButton guardarButton = new JButton("Guardar cambios");
        JButton salirButton = new JButton("Cerrar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);
        buttonPanel.add(salirButton);

        guardarButton.addActionListener(e -> chileModel.guardarCambios(textArea.getText(), "C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\chi.txt"));

        salirButton.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        textArea.setText(chileModel.cargarEquipoDesdeArchivo("C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\chi.txt"));
    }
}
