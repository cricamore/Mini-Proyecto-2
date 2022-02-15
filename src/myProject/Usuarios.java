package myProject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    public static final String PATH = "src/myProject/files/usuarios.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    public ArrayList<String> lecturaFile(){
        ArrayList<String> usuario = new ArrayList<String>();
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






