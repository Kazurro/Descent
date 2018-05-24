package util;

import ch.aplu.xboxcontroller.*;
import characters.Sprite;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Gamepad {
    
    private final XboxController xc;
    private int y = 0;
    private int x = 0;
    
    public Gamepad(JLabel personaje, Sprite sprite) {
        
        xc = new XboxController();
        xc.setLeftThumbDeadZone(0.2);
        xc.addXboxControllerListener(new XboxControllerAdapter(){
            
        @Override public void isConnected(boolean connected) {
                
            if (!connected){
                    
                JOptionPane.showMessageDialog(null, "El mando se ha desconectado.");
                //xc.release(); // Libera xc
            }
        }
            
        // Pad Cuadriculado
            
        @Override public void dpad(int direction, boolean pressed){
                    
            x = (int) personaje.getLocation().getX();
            y = (int) personaje.getLocation().getY();
            
            switch(direction){
                case 0: personaje.setIcon(sprite.getTopAnimation()); y -= 10; break;
                case 1: break;
                case 2: personaje.setIcon(sprite.getRightAnimation()); x += 10; break;
                case 3: break;
                case 4: personaje.setIcon(sprite.getBottomAnimation()); y += 10; break;
                case 5: break;
                case 6: personaje.setIcon(sprite.getLeftAnimation()); x -= 10; break;
                case 7: break;
            }
                
            personaje.setLocation(x, y);
        }
   
        // Thumb Izquierdo
            
        @Override public void leftThumbDirection(double direction) {

            if (direction > 315 && direction < 360|| direction > 0 && direction < 45) {
                personaje.setIcon(sprite.getTopAnimation()); y -= 10;
            } else if (direction > 45 && direction < 135) {
                personaje.setIcon(sprite.getRightAnimation()); x += 10;
            } else if (direction > 135 && direction < 225) {
                personaje.setIcon(sprite.getBottomAnimation()); y += 10;
            } else if (direction > 225 && direction < 315) {
                personaje.setIcon(sprite.getLeftAnimation()); x -= 10;
            }
                
            personaje.setLocation(x, y);
        }

        @Override public void buttonA(boolean bln) {
            System.out.println("Boton A presionado");
        }

            @Override public void buttonB(boolean bln) {
                System.out.println("Boton B presionado");
            }

            @Override public void buttonX(boolean bln) {
                System.out.println("Boton X presionado");
            }

            @Override public void buttonY(boolean bln) {
                System.out.println("Boton Y presionado");
            }

            @Override public void back(boolean bln) {
                System.out.println("Boton Back presionado");
            }

            @Override public void start(boolean bln) {
                System.out.println("Boton Start presionado");
            }

            @Override public void leftShoulder(boolean bln) {
                System.out.println("Boton LT presionado");
            }

            @Override public void rightShoulder(boolean bln) {
                System.out.println("Boton RT presionado");
            }

        });
    }
}
