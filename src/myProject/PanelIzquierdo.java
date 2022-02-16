package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PanelIzquierdo extends JPanel {
    public static final int WIDTH = 370;
    public static final int HEIGHT = 200;
    private JButton salir, ok;
    private String usuario, nivel;
    private JTextField nombreUsuario;
    private int paneles;

    public PanelIzquierdo(){
        paneles=0;
        usuario = "";
        nivel = "1";
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(80,100,200,30);
    }

    public void cambiarDePanel(){
        paneles++;
        repaint();
    }

    public void reset(){
        paneles=0;
        repaint();
    }

    public void almacenar(){
        Usuarios usuarios = new Usuarios();
        usuario = nombreUsuario.getText();
        usuarios.escribirTexto(nivel + ". " + usuario);
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
                g.drawString("Errores:",4,120);
                g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
                break;
        }

    }
}
