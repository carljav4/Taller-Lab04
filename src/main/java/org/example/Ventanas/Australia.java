package org.example.Ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.EquipoModel;

public class Australia extends JFrame {
    private JTable table;
    private EquipoModel equipoModel;

    public Australia() {
        equipoModel = new EquipoModel();

        setTitle("Players");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"Number", "Name", "Position"},
                0
        );

        cargarDatos("C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\aus.txt", tableModel);

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton editButton = new JButton("Edit player");
        JButton saveButton = new JButton("Save changes");
        JButton backButton = new JButton("Back");

        saveButton.addActionListener(e -> {
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    content.append(tableModel.getValueAt(i, j)).append(";");
                }
                content.setLength(content.length() - 1);
                content.append("\n");
            }
            equipoModel.guardarCambios(content.toString(), "C:\\Users\\Carlos\\IdeaProjects\\Taller-Lab04\\Datos\\Datos\\aus.txt");
        });

        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void cargarDatos(String filePath, DefaultTableModel tableModel) {
        String equipo = equipoModel.cargarEquipoDesdeArchivo(filePath);
        String[] lineas = equipo.split("\n");
        for (String linea : lineas) {
            String[] columns = linea.split(";");
            tableModel.addRow(columns);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Australia frame = new Australia();
            frame.setVisible(true);
        });
    }
}
