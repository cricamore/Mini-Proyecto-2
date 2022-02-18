package myProject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;

/**
 * Class Usuarios permite leer y escribir en el arhivo de texto donde se almacenan los nombres de los usuarios
 * @author Cristian Montaño 202024223
 * @author Maicol Montenegro 202026993
 * @version v.1.0.0 date 17/02/2022
 */
public class Usuarios {
    public static final String PATH = "src/myProject/files/usuarios.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;
    private ArrayList<String> usuario = new ArrayList<>();



    public String getUsuario(){
        for (int i=0;i<=usuario.size();i++){
            return usuario.get(i);
        }
        return null;
    }

    /**
     * Permite leer los nombres de los jugadores de un archivo de texto
     * @return usuario
     */
    public ArrayList<String> lecturaFile(){
        try {
            fileReader = new FileReader(PATH);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                usuario.add(line);
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
        return usuario;
    }

    /**
     * Permite escribir los usuarios en archivo de texto
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






