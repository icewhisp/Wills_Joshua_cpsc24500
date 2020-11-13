/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegas.baby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Joshua Wills
 */
public class SlotMachineFrame extends JFrame implements  ActionListener, MouseListener{
     /**
     * Creating the panel to add components to
     */
    JPanel panel = new JPanel();
    JPanel panelS = new JPanel();
    TilePanel tileContainer;
     
     
    /**
    * Constructor
    */
    public SlotMachineFrame(){
        super.addMouseListener(this);
        ArrayList<Tile> starter = new ArrayList<Tile>();
        starter.add(new Tile());
        starter.add(new Tile());
        starter.add(new Tile());
        starter.add(new Tile());
        for (Tile x : starter){
            x.randomize();
        }
        tileContainer = new TilePanel(starter);
        buildLayout();
    }

    public void buildLayout() 
    {
        
  
        JMenuBar mb=new JMenuBar();  
        JMenu fileM=new JMenu("File");
        JMenu helpM=new JMenu("Help");
        JMenuItem lT = new JMenuItem("Load Tiles");
        JMenuItem sT = new JMenuItem("Save Tiles");
        JMenuItem pR = new JMenuItem("Print");
        JMenuItem rT = new JMenuItem("Restart");
        JMenuItem eX = new JMenuItem("Exit");
        JMenuItem aB = new JMenuItem("About");
        
        eX.addActionListener((ActionEvent ev) -> {
            System.exit(0);
        });
        
        lT.addActionListener((ActionEvent ev) -> {
            TileReader reader = new TileReader();
          ArrayList<Tile> newTile = reader.getTiles();
        });
        
        sT.addActionListener((ActionEvent ev) -> {
            try {
                TileWriter writer = new TileWriter(tileContainer.getTiles());
            } catch (IOException ex) {}
        });
        aB.addActionListener((ActionEvent ev) -> {
            JOptionPane.showMessageDialog(null,"Written by Joshua Wills \n Here is my GitHub repo:");
        });
        
        fileM.add(lT);
        fileM.add(sT);
        fileM.add(pR);
        fileM.add(rT);
        fileM.add(eX);
        helpM.add(aB);
        mb.add(fileM);
        mb.add(helpM);
        setJMenuBar(mb);
        setTitle("Casino Simulator");
        this.getContentPane().setBackground(Color.white);
        setSize(800,480);
        panel.setLayout(new FlowLayout());
        JButton draw = new JButton("Draw");
        draw.addActionListener(this);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        panelS = tileContainer.printTile(g);
        add(panelS, BorderLayout.PAGE_END);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        int locX = me.getX();
        int locY = me.getY();
        if (locY< 275 && locY>125) //I'm giving some wiggle room as as long as you click close to one you'll change it
        {
            if(locX > 25 && locX <175){
                tileContainer.changeTile(0);
            }
            else if (locX > 200 && locX <350){
                tileContainer.changeTile(1);
            }
            else if (locX > 375 && locX <525){
                tileContainer.changeTile(2);
            }
            else if (locX > 550 && locX <700){
                tileContainer.changeTile(3);
            }
        }
        repaint();
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
