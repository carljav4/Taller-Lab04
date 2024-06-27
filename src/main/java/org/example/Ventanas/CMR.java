package org.example;

import javax.swing.*;
import java.awt.*;
import modelo.CMRModel;

public class CMR extends JFrame {
    private JTextArea textArea;
    private CMRModel cmrModel;

    public CMR() {
        cmrModel = new CMRModel();

        setTitle("Equipo de Camerún");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocation(1800, 0);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        JButton guardarButton = new JButton("Guardar cambios");
        JButton salirButton = new JButton("Cerrar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);
        buttonPanel.add(salirButton);

        guardarButton.addActionListener(e -> cmrModel.guardarCambios(textArea.getText(), "C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\cmr.txt"));

        salirButton.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        textArea.setText(cmrModel.cargarEquipoDesdeArchivo("C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\cmr.txt"));
    }
}
