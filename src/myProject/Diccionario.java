package myProject;

import java.util.ArrayList;
import java.util.Random;

public class Diccionario {

    private ArrayList<String> diccionario = new ArrayList<>();

    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
    }

    public String getPalabra(){
        Random aleatorio = new Random();
        aleatorio.nextInt(diccionario.size());
        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }
}
