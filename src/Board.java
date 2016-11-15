

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    //Permite lanzar constantemente eventos de tipo ActionListener.
    private Timer timer;
    
    private Circle circle;
    private Rectangle rectangle;
    private Polygon[] polygons;
    private final int DELAY = 10;
    private final int B_WIDTH = 1024;
    private final int B_HEIGHT = 512;

    public Board() throws Exception {
       initBoard();
    }
    
    private void initBoard() throws Exception {
        //Adiciona la clase que permite gestionar los eventos del teclado.
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
        //Objetos del juego.
        circle = new Circle(40,300,30,30);
        rectangle = new Rectangle(60, 360, 120, 80);
        
        int[] x1 = {180 ,200, 180, 160};
        int[] y1 = {440, 460, 460, 440};
        
        int[] x2 = {140 ,120, 140, 160};
        int[] y2 = {440, 460, 460, 440};
        
        int[] x3 = {100 ,120, 100, 80};
        int[] y3 = {440, 460, 460, 440};
        
        int[] x4 = {60 ,40, 60, 80};
        int[] y4 = {440, 460, 460, 440};
        
        this.polygons = new Polygon[4];
        
        polygons[0] = new Polygon(x1,y1,4,10,10,10,4);
        polygons[1] = new Polygon(x2,y2,4,10,10,10,4);
        polygons[2] = new Polygon(x3,y3,4,10,10,10,4);
        polygons[3] = new Polygon(x4,y4,4,10,10,10,4);
        
        
        //El constructor indica cada cuanto tiempo debe lanzar un ActionListener
        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       
        
        ImageIcon ii = new ImageIcon("fondo.png");
        Image bardejov = ii.getImage();
        g2d.drawImage(bardejov, 0, 0, null);
      
       
        g2d.setColor(Color.RED);
        g2d.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
        g2d.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        g2d.drawPolyline(polygons[0].getCoorx(), polygons[0].getCoory(), 4);
        g2d.drawPolyline(polygons[1].getCoorx(), polygons[1].getCoory(), 4);
        g2d.drawPolyline(polygons[2].getCoorx(), polygons[2].getCoory(), 4);
        g2d.drawPolyline(polygons[3].getCoorx(), polygons[3].getCoory(), 4);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circle.move();
        rectangle.move();
        for(int i = 0; i < 4; i++){
            polygons[i].move();
        }
        repaint();  
    }
        
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            circle.keyReleased(e);
            rectangle.keyReleased(e);
            for(int i = 0; i < 4; i++){
            polygons[i].keyReleased(e);
        }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            circle.keyPressed(e);
            rectangle.keyPressed(e);
            for(int i = 0; i < 4; i++){
            polygons[i].keyPressed(e);
        }
        }
    }
}