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
        return palabra;
    }


    public String getPalabra(){
        return palabra;
    }
}
