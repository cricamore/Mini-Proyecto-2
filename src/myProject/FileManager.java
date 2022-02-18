package myProject;

import java.io.*;
import java.util.ArrayList;

/**
 * Class FileManager permite leer y escribir en el arhivo de texto donde se almacenan los nombres de los usuarios
 * @author Cristian Montaño 202024223
 * @author Maicol Montenegro 202026993
 * @version v.1.0.0 date 17/02/2022
 */
public class FileManager {
    public static final String PATH = "src/myProject/files/diccionario.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * Permite leer las palabras del dicionario almacenadas en un archivo de texto
     * @return usuario
     */
    public ArrayList<String> lecturaFile() {
        ArrayList<String> frases = new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                frases.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frases;
    }

    /**
     * Permite escribir en archivos de texto
     */
    public void escribirTexto(String linea){
        try {
            fileWriter = new FileWriter(PATH,true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}