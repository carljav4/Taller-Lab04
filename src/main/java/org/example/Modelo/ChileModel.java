package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ChileModel {
    public String cargarEquipoDesdeArchivo(String nombreArchivo) {
        StringBuilder equipo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                equipo.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return equipo.toString();
    }

    public void guardarCambios(String contenido, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
            JOptionPane.showMessageDialog(null, "Cambios guardados correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
