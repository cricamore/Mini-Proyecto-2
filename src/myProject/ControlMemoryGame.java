package myProject;

public class ControlMemoryGame {
    private Diccionario palabras;
    private String palabra, errores;
    private int conteoErrores, paneles;
    private boolean pierde, pasaNivel, gana;

    public ControlMemoryGame(){
        palabras = new Diccionario();
    }

    public String pintarPalabra(){
        palabra=palabras.getPalabra();
        for(int i=0;i<=20;i++){
            palabra
        }
    }


    public String getPalabra(){
        return palabra;
    }
}
