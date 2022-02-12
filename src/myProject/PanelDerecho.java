package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelDerecho extends JPanel {
    public static final int WIDTH = 370;
    public static final int HEIGHT = 200;
    private int enunciado;
    private JButton inicio;


    public PanelDerecho(){
        enunciado=0;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    public void mostrarEnunciado(){
        enunciado++;
        repaint();
    }

    public void reset(){
        enunciado=0;
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
                g.drawString("Presione el botón para"+"\n dar inicio al nivel",4,17);
            break;
            case 1: g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("Memorice las palabras que se mostrarán",4,70);
                g.drawString("a continuación:",4,88);
                break;


            case 2:g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("¿Esta palabra apareció?",4,1);
                break;
        }

    }

}
