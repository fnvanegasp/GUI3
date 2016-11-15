/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;
/**
 *
 * @author Estudiante
 */
public class Rectangle extends Sprite{
    private int dx;
    private int dy;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public void move() {
        y =  360;
        x += dx;
        y += dy;
        /*if(x == 180 && y == 400){
            x = 400;
            y = 400;
        }*/
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
        }
        
        if (key == KeyEvent.VK_A) {
            dx = -5;
        }

        if (key == KeyEvent.VK_D) {
           dx = 5;
          
        }

        if (key == KeyEvent.VK_W) {
            dy = -100;
        }

        if (key == KeyEvent.VK_S) {
            dy = 5;
        }
    }
    
    public void keyReleased(KeyEvent e) {
    
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}
