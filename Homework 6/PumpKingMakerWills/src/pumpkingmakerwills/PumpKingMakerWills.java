/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pumpkingmakerwills;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Joshua Wills
 */
public class PumpKingMakerWills extends JFrame implements  ActionListener {
    /**
     * Variable for distance from the left for the pumpkin
     */
    public int left = 200;
    /**
     * Variable for distance from the top for the pumpkin
     */
    public int down = 100;
    /**
     * Variable for how wide the pumpkin should be
     */
    public int pumpkinWidth = 100;
    /**
     * Variable for how tall the pumpkin should be
     */
    public int pumpkinHeight = 100;
    /**
     * Variable for the shape of the pumpkin's eyes
     */
    public char eye = 'c';
    /**
     * Variable for the shape of the pumpkin's nose
     */
    public char nose = 's';
    /**
     * Variable for the shape of the pumpkin's mouth
     */
    public char mouth = 'o';
    /**
     * import of graphics
     */
    public Graphics G;
    /**
     * Creating the panel to add components to
     */
    JPanel panel = new JPanel();

    /**
     * Textfield for how far left
     */
    JTextField lP= new JTextField();
    /**
     * Textfield for how far right
     */
    JTextField tP= new JTextField();
    /**
     * Textfield for how wide
     */
    JTextField wP= new JTextField(); // Width,Height,Eyes,Nose,Mouth fields
    /**
     * Textfield for how tall
     */
    JTextField hP= new JTextField();
    /**
     * Textfield for eye shape
     */
    JTextField eP= new JTextField();
    /**
     * Textfield for nose shape
     */
    JTextField nP= new JTextField();
    /**
     * Textfield for mouth shape
     */
    JTextField mP= new JTextField();
    /**
     * label for how far left
     */
    JLabel lPT = new JLabel("Left:");
    /**
     * label for how far from the top
     */
    JLabel tPT = new JLabel("Top:");
    /**
     * label for width entry
     */
    JLabel wPT = new JLabel("Width:");
    /**
     * label for how height entry
     */
    JLabel hPT = new JLabel("Height:");
    /**
     * label for how eye entry
     */
    JLabel ePT = new JLabel("Eye (C S T):");
    /**
     * label for how nose entry
     */
    JLabel nPT = new JLabel("Nose (C S T):");
    /**
     * label for how mouth entry
     */
    JLabel mPT = new JLabel("Mouth (O R):");
    /**
    * Constructor
    * 
    */     
    public PumpKingMakerWills()
    {
        buildLayout();
    }
     /**
    * Creates a default frame
    * 
    */ 
    public void buildLayout()
    {
        setTitle("Pumpkin Maker");
        setSize(800,480);
        panel.setLayout(new FlowLayout());
        JButton draw = new JButton("Draw");
        draw.addActionListener(this);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        wP.setText("100");
        hP.setText("100");
        eP.setText("c");
        nP.setText("s");
        mP.setText("o");
        lP.setText("200");
        tP.setText("100");
        panel.add(lPT);
        panel.add(lP);
        panel.add(tPT);
        panel.add(tP);
        panel.add(wPT);
        panel.add(wP);
        panel.add(hPT);
        panel.add(hP);
        panel.add(ePT);
        panel.add(eP);
        panel.add(nPT);
        panel.add(nP);
        panel.add(mPT);
        panel.add(mP);
        panel.add(draw);
        add(panel, BorderLayout.PAGE_END);
        
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
    * Draws a pumpkin using all variables
     * @param g
    */ 
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        
        int offsetHeight = pumpkinHeight/4;
        int offsetWidth = pumpkinWidth/4;
        g.setColor(Color.ORANGE);
        g.drawOval(left,down,pumpkinWidth,pumpkinHeight);
        g.fillOval(left,down,pumpkinWidth,pumpkinHeight);
        //drawing eyes
        if(eye == 'c')
        {
            g.setColor(Color.WHITE);
            g.fillOval(left+offsetWidth,down+offsetHeight,pumpkinWidth/6,pumpkinHeight/6);
            g.fillOval(left+offsetWidth*3-pumpkinWidth/6,down+offsetHeight,pumpkinWidth/6,pumpkinHeight/6);
        }
        else if(eye == 's')
        {
            g.setColor(Color.WHITE);
            g.fillRect(left+offsetWidth,down+offsetHeight,pumpkinWidth/6,pumpkinHeight/6);
            g.fillRect(left+offsetWidth*3-pumpkinWidth/6,down+offsetHeight,pumpkinWidth/6,pumpkinHeight/6);
        }
        else if(eye == 't')
        {
            g.setColor(Color.WHITE);
            //The upcoming math was mostly trial and error, with a small amount of alergbra to get me close
            g.fillPolygon(new int[] {left+offsetWidth, left+offsetWidth*5/4, left+offsetWidth*5/3}, new int[] {down+offsetHeight*3/2, down+offsetHeight*2/3, down+offsetHeight*3/2}, 3);
            g.fillPolygon(new int[] {left+offsetWidth*5/2, left+offsetWidth*5/4+offsetWidth*6/4, left+offsetWidth*5/3+offsetWidth*6/4}, new int[] {down+offsetHeight*3/2, down+offsetHeight*2/3, down+offsetHeight*3/2}, 3);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You entered an invald entry for eyes defaulting to circles");
            g.setColor(Color.WHITE);
            g.fillOval(left+offsetWidth,down+offsetHeight,pumpkinWidth/6,pumpkinHeight/6);
            g.fillOval(left+offsetWidth*5/2,down+offsetHeight,pumpkinWidth/6,pumpkinHeight/6);
        }
        //Drawing Nose
        offsetHeight = pumpkinHeight/15;
        offsetWidth = pumpkinWidth*1/16;
        if(nose == 'c')
        {
            g.setColor(Color.WHITE);
            g.fillOval(left+pumpkinWidth/2-offsetWidth,down+pumpkinHeight/2-offsetHeight,pumpkinWidth/8,pumpkinHeight/8);
        }
        else if(nose == 's')
        {
            g.setColor(Color.WHITE);
            g.fillRect(left+pumpkinWidth/2-offsetWidth,down+pumpkinHeight/2-offsetHeight,pumpkinWidth/8,pumpkinHeight/8);
        }
        else if(nose == 't')
        {
            g.setColor(Color.WHITE);
            //The upcoming math was mostly trial and error, with a small amount of alergbra to get me close
            g.fillPolygon(new int[] {left+pumpkinWidth/2-offsetWidth, left+pumpkinWidth/2, left+pumpkinWidth/2+offsetWidth}, new int[] {down+pumpkinHeight/2+offsetHeight, down+pumpkinHeight/2-offsetHeight, down+pumpkinHeight/2+offsetHeight}, 3);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You entered an invald entry for nose defaulting to circles");
            g.setColor(Color.WHITE);
            g.fillOval(left-offsetWidth,down+offsetHeight,pumpkinWidth/8,pumpkinHeight/8);
        }
        //Drawing Mouth
        offsetHeight = pumpkinHeight*2/9;
        offsetWidth = pumpkinWidth/7;
        
        if (mouth == 'o')
        {
            g.setColor(Color.WHITE);
            g.fillOval(left+pumpkinWidth/2-offsetWidth*2,down+pumpkinHeight/2+offsetHeight,pumpkinWidth-offsetWidth*3,pumpkinHeight/8);  
        }
        else if (mouth == 'r')
        {
            g.setColor(Color.WHITE);
            g.fillRect(left+pumpkinWidth/2-offsetWidth*2,down+pumpkinHeight/2+offsetHeight,pumpkinWidth-offsetWidth*3,pumpkinHeight/8);  
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You entered an invald entry for mouth defaulting to circles");
            g.setColor(Color.WHITE);
            g.fillOval(left+pumpkinWidth/2-offsetWidth*2,down+pumpkinHeight/2+offsetHeight,pumpkinWidth-offsetWidth*3,pumpkinHeight/8);  
        }
        //Drawing Stem
        g.setColor(Color.WHITE);
        g.fillRect(left+pumpkinWidth/2-pumpkinWidth/20,down-pumpkinHeight/10,pumpkinWidth/10,pumpkinHeight/10);  
    }
    
    /**
    * Starts the program
    * 
     * @param args
    */
    public static void main(String[] args) {
        PumpKingMakerWills start = new PumpKingMakerWills();
    }
    /**
     * @param e
     * Listens to the button being clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        left = Integer.parseInt(lP.getText());
        down = Integer.parseInt(tP.getText());
        pumpkinWidth = Integer.parseInt(wP.getText());
        pumpkinHeight = Integer.parseInt(hP.getText());
        eye = eP.getText().charAt(0);
        nose = nP.getText().charAt(0);
        mouth = mP.getText().charAt(0);
        repaint();
          
        }
    
}
