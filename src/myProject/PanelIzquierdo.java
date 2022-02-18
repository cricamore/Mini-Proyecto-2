package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta clase se encarga de mostrar el boton SALIR para finalizar la ejecucion,
 * muestra el campo para que el jugador ingrese su nombre o alias luego visualizarlo
 * junto con el nivel y el numero de errores.
 * @author Cristian Montaño 202024223
 * @author Maicol Montenegro 202026993
 * @version v.1.0.0 date 17/02/2022
 */

public class PanelIzquierdo extends JPanel {
    public static final int WIDTH = 370;
    public static final int HEIGHT = 200;
    private JButton salir, ok;
    private String usuario, nivel, error;
    private JTextField nombreUsuario;
    private int paneles;
    private Usuarios usuarios;
    private ControlMemoryGame errores;
    private ArrayList<String> usuarioAlmacenado = new ArrayList<>();

    /**
     * Constructor
     */
    public PanelIzquierdo(){
        paneles=0;
        usuario = "";
        nivel = "0";
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(80,100,200,30);

        Usuarios leerUsuario = new Usuarios();
        usuarioAlmacenado = leerUsuario.lecturaFile();
    }

    /**
     * Permite cambiar de panel según el estado en el que se encuentre
     */
    public void cambiarDePanel(){
        paneles++;
        repaint();
    }

    /**
     * permite restablecer los paneles
     */
    public void reset(){
        paneles=0;
        repaint();
    }


    /**
     * Permite escribir en el archivo de texto usuarios.txt el nombre ingresado en el campo de texto
     */
    public void almacenar(){
        usuario = "";
        usuarios = new Usuarios();
        usuario = nombreUsuario.getText();

        for(int i=0;i<usuarioAlmacenado.size();i++){
            if(usuario == String.valueOf(i)){
                usuarios = null;
            }
        }
        usuarios.escribirTexto(usuario);

    }


    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);

        switch (paneles){
            case 0:
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
            g.setColor(Color.BLACK);
            g.drawString("Ingresa tu nombre de usuario:", 60, 80);
                nombreUsuario.setVisible(true);
                nombreUsuario.setEnabled(true);
            add(nombreUsuario);

            break;
            case 1:
                nombreUsuario.setVisible(false);
                nombreUsuario.setOpaque(false);
                nombreUsuario.setEnabled(false);
                g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("Nombre de usuario:",4,50);
                g.setFont(new Font(Font.DIALOG,Font.PLAIN,17));
                g.setColor(Color.BLACK);
                g.drawString(usuario,168 ,50);


                g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString("Nivel:",4 ,77);
                g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                g.setColor(Color.BLACK);
                g.drawString(nivel,55 ,77);

                g.setColor(Color.BLACK);
                g.drawString("Errores: "+ error,4,120);
                g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                break;
        }

    }
}
