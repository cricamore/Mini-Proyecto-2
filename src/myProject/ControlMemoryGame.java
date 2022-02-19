package myProject;

/**
 * Class ControlMemoryGame se encarga de mostrar de forma aleatoria las palabras del nivel
 * @author Cristian Montaño 202024223
 * @author Maicol Montenegro 202026993
 * @version v.1.0.0 date 17/02/2022
 */
public class ControlMemoryGame {
    private Diccionario palabras;
    private Usuarios usuarios;
    private String palabra, errores, usuario, nivel;
    private int conteoErrores, paneles;
    private boolean pierde, pasaNivel, gana, fallo;

    public ControlMemoryGame(){
        palabras = new Diccionario();
        usuarios = new Usuarios();
    }

    public String pintarPalabra(){
        palabra=palabras.getPalabra();
        return palabra;
    }





    public String nivel(int nivel){
        return String.valueOf(nivel);
    }

    public boolean isFallo(){
        return fallo;
    }

    public String getPalabra(){
        return palabra;
    }
}
