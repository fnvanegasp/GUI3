/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
/**
 *
 * @author Estudiante
 */
public class TestPaintComponent extends JFrame{
    public TestPaintComponent(){
        add(new NewPanel());
    }
    
public static void main(String[] args){
    TestPaintComponent frame = new TestPaintComponent();
    frame.setTitle("Test");
    frame.setSize(250,400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
}



class NewPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        
        int[] x1 = {180 ,200, 180, 160};
        int[] y1 = {140, 160, 160, 140};
        
        int[] x2 = {140 ,120, 140, 160};
        int[] y2 = {140, 160, 160, 140};
        
        int[] x3 = {100 ,120, 100, 80};
        int[] y3 = {140, 160, 160, 140};
        
        int[] x4 = {60 ,40, 60, 80};
        int[] y4 = {140, 160, 160, 140};
        
        g.fillRect(60, 60, 120, 80);    

        g.drawPolyline(x1, y1, 4);
        g.drawPolyline(x2, y2, 4);
        g.drawPolyline(x3, y3, 4);
        g.drawPolyline(x4, y4, 4);

    }
}