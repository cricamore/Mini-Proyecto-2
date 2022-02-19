package myProject;

import javax.swing.*;
import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Random;

/**
 * Class PanelDerecho es encarga de proyectar la ejecución de la fase de juego.
 * @author Cristian Montaño 202024223
 * @author Maicol Montenegro 202026993
 * @version v.1.0.0 date 17/02/2022
 */
public class  PanelDerecho extends JPanel {
    public static final int WIDTH = 370;
    public static final int HEIGHT = 200;
    public static final int altura = 50;
    private Diccionario diccionario;
    private int enunciado;
    private Timer timer;
    private JButton inicio;
    private String palabra;
    private Random random;

    /**
     * Constructor
     * @param palabra
     */
    public PanelDerecho(String palabra){
        this.palabra=palabra;
        enunciado=0;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    /**
     * muestra los diferentes enunciados de la fase del juego
     */
    public void mostrarEnunciado(){
        enunciado++;
        repaint();
    }

    /**
     * Asigna una palabra
     * @param palabra
     */
    public void setPalabra(String palabra){
        this.palabra=palabra;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);


        switch (enunciado){

            case 0: g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);

                g.drawString("El juego consiste en ",WIDTH/4,altura);
                g.drawString("memorizar la mayor",WIDTH/4,altura+19);
                g.drawString("cantidad de palabras que",WIDTH/4,altura+34);
                g.drawString("se muestran. A medida ",WIDTH/4,altura+49);
                g.drawString("que se avanza en nivel, ",WIDTH/4,altura+64);
                g.drawString("aumenta el número de", WIDTH/4,altura+79);
                g.drawString("palabras a memorizar. ",WIDTH/4,altura+94);
                break;
            case 1: g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("Presione el botón para"+"\n dar inicio al nivel",20,HEIGHT/3);
            break;

            case 2: g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("Memorice las palabras que se mostrarán",4,70);
                g.drawString("a continuación:",4,88);
                break;

            case 3:g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("¿Esta palabra apareció?",4,70);
                break;
        }

    }

    /**
     * permite restablecer la palabra
     * @param palabra
     */
    public void reset(String palabra){
        this.palabra=palabra;
        repaint();
    }
}
