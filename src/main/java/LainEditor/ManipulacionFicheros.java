package LainEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    File ArchivoSeleccionado;
    /**
     *Metodo que se encarga de abrir el archivo de texto y almacena el contenido
     *en una variable StringBuider
     * 
     */
    public void abrirArchivo() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            ArchivoSeleccionado = fc.getSelectedFile();
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
    
    public void guardarArchivo(String niuContenido){
        try{
            BufferedWriter escritura = new BufferedWriter(new FileWriter (ArchivoSeleccionado));
            escritura.write(niuContenido);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "Error en la Escritura de archivo", 1);
        }
    }
    /*
    public void guardarComo(){
        
    }
    
    public void nuevoArchivo(){
        
    }
    */

    public String getContenido() {
        return contenido.toString();
    }
}
