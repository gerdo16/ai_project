package scr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener {

    private final SimpleDriver sd;

    public KeyListener(SimpleDriver sd){
        this.sd = sd;
        takeTrainingCommands();
    }

    private void takeTrainingCommands(){
        // Imposta la finestra per catturare gli input da tastiera
        JFrame frame = new JFrame("Continuous Character Reader");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JTextField inputField = new JTextField(20);
        frame.add(inputField);
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //I tasti premuti sono stati associati alle varie azioni da compiere
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        sd.azione.accelerate = 0.8;
                        sd.azione.isUpPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        sd.azione.brake = 0.5;
                        sd.azione.accelerate = 0.0;
                        sd.azione.isDownPressed = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        if(sd.azione.isUpPressed)
                            sd.azione.steering = +0.2;
                        else
                            sd.azione.steering = +0.5;
                        sd.azione.isLeftPressed = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(sd.azione.isUpPressed)
                            sd.azione.steering = -0.2;
                        else
                            sd.azione.steering = -0.5;
                        sd.azione.isRightPressed = true;
                        break;
                    case KeyEvent.VK_SHIFT: //shift per la retromarcia
                        if(sd.azione.gear <= 1) {
                            sd.azione.gear = -1;
                            sd.azione.accelerate = 0.6;
                            sd.azione.isShiftPressed = true;
                            break;
                        }
                    case KeyEvent.VK_P:     // Serve ad attivare/disattivare la lettura
                        sd.registra = !sd.registra;   // da tastiera.
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //Quando i tasti vengono rilasciati, i corrispondenti comandi vengono resettati
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        sd.azione.accelerate = 0.0;
                        sd.azione.isUpPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        sd.azione.brake = 0.0;
                        sd.azione.isDownPressed = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        sd.azione.steering = 0.0;
                        sd.azione.isLeftPressed = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        sd.azione.steering = 0.0;
                        sd.azione.isRightPressed = false;
                        break;
                    case KeyEvent.VK_SHIFT:
                        sd.azione.gear = 0;
                        sd.azione.accelerate = 0.0;
                        sd.azione.isShiftPressed = false;
                        break;
                }
            }
        });
        frame.setVisible(true);
    }
}
