
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Polygon extends Sprite{
    private int dx;
    private int dy;
    private int[] coorx;
    private int[] coory;
    private int nPoints;

    public Polygon(int[] coorx, int[] coory, int nPoints,  int x, int y, int width, int height) {
        super(x, y, width, height);
        this.coorx = coorx;
        this.coory = coory;
        this.nPoints = nPoints;
    }

    public void move() {
        
        for(int i = 0;i < 4; i++){
            coorx[i] += dx;
            coory[i] += dy;
        }
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

    public int[] getCoorx() {
        return coorx;
    }

    public int[] getCoory() {
        return coory;
    }
    
    
}
