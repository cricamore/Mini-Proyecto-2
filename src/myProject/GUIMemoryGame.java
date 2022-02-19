package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used as a view Memory Game Class
 * @autor Cristian Camilo Montaño Rentería cristian.camilo.montano@correounivalle.edu.co
 * @autor Maicol Jair Ordoñez Montenegro maicol.ordonez@correounivalle.edu.co
 * @version v.1.0.0 date:17/02/2022
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
    private JTextArea palabra, comprobarPalabra;
    private Timer timer, timerDos;
    private Random random;
    private Diccionario diccionario;

    /**
     * Constructor of GUI class
     */
    public GUIMemoryGame(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I KNOW THAT WORD!");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
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
        panelDerecho = new PanelDerecho(null);
        add(panelDerecho,BorderLayout.EAST);
        panelDerecho.setLayout(null);
        panelIzquierdo = new PanelIzquierdo();
        add(panelIzquierdo,BorderLayout.WEST);
        panelIzquierdo.setLayout(null);

        inicio = new JButton("INICIAR NIVEL");
        //initTimer.addActionListener(escucha);
        //initTimer.setVisible(false);
        inicio.setEnabled(false);
        add(inicio,BorderLayout.SOUTH);

        //timer

        timer = new Timer(100,escucha);

        inicio.setBounds(93,(200/2)-15,200,30);
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

        //timer segunda etapa

        timerDos = new Timer(4000, escucha);

        empezar = new JButton("CONTINUAR");
        empezar.setBounds(93,100,200,30);
        panelDerecho.add(empezar);
        empezar.setVisible(false);
        empezar.setEnabled(false);

        diccionario = new Diccionario();

        palabra = new JTextArea();
        palabra.setBounds(100, 100,170,40);
        palabra.setEditable(false);
        palabra.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        panelDerecho.add(palabra);
        palabra.setVisible(false);
        palabra.setEnabled(false);
        palabra.setBackground(Color.LIGHT_GRAY);

        comprobarPalabra = new JTextArea();
        comprobarPalabra.setBounds(100, 100,170,40);
        comprobarPalabra.setEditable(false);
        comprobarPalabra.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        panelDerecho.add(comprobarPalabra);
        comprobarPalabra.setVisible(false);
        comprobarPalabra.setEnabled(false);
        comprobarPalabra.setBackground(Color.LIGHT_GRAY);

        si = new JButton("SÍ");
        si.setBounds(73,150,70,30);
        si.setVisible(false);
        si.setEnabled(false);
        si.addActionListener(escucha);

        no = new JButton("NO");
        no.setBounds(173,150,70,30);
        no.setVisible(false);
        no.setEnabled(false);
        no.addActionListener(escucha);

    }

    /**c
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

        private int counter=0;
        ArrayList<String>palabras1=new ArrayList<>();
        ArrayList<String>nivel=new ArrayList<>();

        public Escucha(){
            random = new Random();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==timer){
                if (counter<10){
                    palabra.setText(controlMemoryGame.pintarPalabra());
                    palabras1.add(palabra.getText());
                    counter++;
                }else {
                    timer.stop();
                    panelDerecho.remove(palabra);
                    System.out.println(palabras1);
                    palabra.setVisible(false);
                    palabra.setEnabled(false);
                    empezar.setVisible(true);
                    empezar.setEnabled(true);
                    empezar.addActionListener(escucha);
                    panelDerecho.add(comprobarPalabra);
                    counter=0;
                    nivel = palabras1;
                    revalidate();
                    repaint();
                }
            }




            if(e.getSource()==no){
                counter++;
                if(palabras1.contains(comprobarPalabra.getText())){
                    System.out.println("error");
                    //timerDos.restart();
                }else {
                    System.out.println("acierto");
                }
            }

            if(e.getSource()==inicio){
                timer.start();
                panelDerecho.mostrarEnunciado();
                inicio.setVisible(false);
                inicio.setEnabled(false);
                palabra.setVisible(true);
                palabra.setEnabled(true);

            }

            if(e.getSource()==timerDos){
                if(counter<20){
                    if(nivel.size()<20){
                        nivel.add(controlMemoryGame.pintarPalabra());
                    }
                    comprobarPalabra.setText( nivel.get(counter) );
                    comprobarPalabra.setVisible(true);
                    comprobarPalabra.setEnabled(true);
                    counter++;

                }else {
                    timerDos.stop();
                    counter=0;
                    System.out.println( nivel );
                    panelDerecho.remove(comprobarPalabra);
                    comprobarPalabra.setVisible(false);
                    comprobarPalabra.setEnabled(false);
                }
                if(e.getSource()==si){
                    counter++;
                    if(palabras1.contains(comprobarPalabra.getText())){
                        System.out.println("acierto");
                        //timerDos.restart();
                    }else {
                        System.out.println("error");
                    }
                }
            }


            if(e.getSource()==empezar){
                palabra.setVisible(true);
                palabra.setEnabled(true);
                panelDerecho.mostrarEnunciado();
                timerDos.start();
                empezar.setVisible(false);
                empezar.setEnabled(false);
                empezar.removeActionListener(escucha);
                panelDerecho.remove(empezar);
                panelDerecho.add(no);
                panelDerecho.add(si);
                si.setVisible(true);
                si.setEnabled(true);
                no.setVisible(true);
                no.setEnabled(true);
            }

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
                panelDerecho.mostrarEnunciado();
            }




        }

    }

    }
