package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Australia extends JFrame {
    private JTextArea textArea;

    public Australia() {
        setTitle("Equipo de Australia");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocation(900, 0);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        JButton guardarButton = new JButton("Guardar cambios");
        JButton salirButton = new JButton("Cerrar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);
        buttonPanel.add(salirButton);

        guardarButton.addActionListener(e -> guardarCambios("C:\\Users\\diego\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\aus.txt"));

        salirButton.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        cargarEquipoDesdeArchivo("C:\\Users\\diego\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\aus.txt");
    }

    private void cargarEquipoDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            StringBuilder equipo = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                equipo.append(linea).append("\n");
            }
            textArea.setText(equipo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarCambios(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Cambios guardados correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Australia ventanaAustralia = new Australia();
            ventanaAustralia.setVisible(true);
        });
    }
}
