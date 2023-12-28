package LainEditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author luna
 */
public class ManipulacionFicheros {

    StringBuilder contenido = new StringBuilder();

    public void abrirArchivo() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File ArchivoSeleccionado = fc.getSelectedFile();
            try {
                BufferedReader lector = new BufferedReader(new FileReader(ArchivoSeleccionado));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                lector.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e, "Error en la Lectura de archivo", 1);
            } 

            }
        }
    
    

    public String getContenido() {
        return contenido.toString();
    }
}
