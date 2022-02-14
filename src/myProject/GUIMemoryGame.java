package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUIMemoryGame extends JFrame {

    private Header headerProject;
    private PanelDerecho panelDerecho;
    private PanelIzquierdo panelIzquierdo;
    private ControlMemoryGame controlMemoryGame;
    private JPanel panelInicial;
    private Escucha escucha;
    private JButton inicio, salir, ok, si, no, empezar;
    private JTextField nombreUsuario;
    private Timer timer;
    private int counter;
    private Random random;
    private Diccionario diccionario;

    /**
     * Constructor of GUI class
     */
    public GUIMemoryGame(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("The Title app");
        this.setSize(200,100);
        this.pack();
        //this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        controlMemoryGame = new ControlMemoryGame();
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("I KNOW THAT WORD!", Color.BLACK);
        this.add(headerProject,BorderLayout.PAGE_START); //Change this line if you change JFrame Container's Layout
        panelDerecho = new PanelDerecho(controlMemoryGame.pintarPalabra());
        add(panelDerecho,BorderLayout.EAST);
        panelDerecho.setLayout(null);
        panelIzquierdo = new PanelIzquierdo();
        add(panelIzquierdo,BorderLayout.WEST);
        panelIzquierdo.setLayout(null);

        inicio = new JButton("INICIAR NIVEL");
        inicio.setBounds(93,25,200,30);
        panelDerecho.add(inicio);
        inicio.setVisible(false);
        inicio.setEnabled(false);
        inicio.addActionListener(escucha);

        salir = new JButton("SALIR");
        salir.setBounds(4,4,70,30);
        panelIzquierdo.add(salir);
        salir.addActionListener(escucha);

        ok = new JButton("OK");
        panelIzquierdo.add(ok);
        ok.setBounds(150,150,55,40);
        ok.addActionListener(escucha);

        timer = new Timer(500, escucha);
        timer.start();

        empezar = new JButton("Empezar");
        empezar.setBounds(93,25,200,30);
        panelDerecho.add(empezar);
        empezar.setVisible(false);
        empezar.setEnabled(false);


    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIMemoryGame miProjectGUI = new GUIMemoryGame();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends KeyAdapter implements ActionListener {

        public Escucha(){
            random = new Random();
            counter = 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==salir){
                System.exit(0);
            }

            if(e.getSource()==ok){

                inicio.setVisible(true);
                inicio.setEnabled(true);
                panelIzquierdo.almacenar();
                panelIzquierdo.cambiarDePanel();
                ok.setVisible(false);
                ok.setEnabled(false);
            }

            if(e.getSource()==inicio){
                panelDerecho.mostrarEnunciado();
                inicio.setVisible(false);
                inicio.setEnabled(false);
                if(e.getSource()==timer) {
                    counter++;
                    if(counter<5) {
                        panelDerecho.setPalabra(controlMemoryGame.getPalabra());
                    }
                }
            }
        }
    }
}
