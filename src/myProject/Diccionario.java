package myProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

/**
 * Class Diccionario permite obtener un String aleatorio del archivo de texto
 * @author Cristian Montaño 202024223
 * @author Maicol Montenegro 202026993
 * @version v.1.0.0 date 17/02/2022
 */
public class Diccionario {

    private ArrayList<String> diccionario = new ArrayList<>();

    public void leerTodo(){
        for(int i=0;i<diccionario.size();i++){
            diccionario.get(i);
        }
    }

    /**
     * Constructor
     */
    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
    }

    /**
     * Permite obtener una palabra aleatoria
     * @return String
     */
    public String getPalabra(){
        Random aleatorio = new Random();
        aleatorio.nextInt(diccionario.size());
        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }
}
