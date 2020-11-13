/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegas.baby;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Holder for the array list of current Tiles and state of how the panel should look
 * @author Joshua Wills
 */
public class TilePanel extends JFrame{
    JPanel objects = new JPanel();
   public ArrayList<Tile> tiles;

    /**
     * Constructor
     * @param tiles
     */
    public TilePanel(ArrayList<Tile> tiles){
       this.tiles = tiles;
   }

    /**
     * Default constructor 
     */
    public TilePanel()
    {
        
    }

    /**
     * Prints all the titles
     * @param g
     * @return 
     */
    public JPanel printTile(Graphics g)
    {
        
        int baseX = 50;
        int baseY = 150;
        objects.setLayout(new FlowLayout());
        for(Tile x: tiles){
            if(x.getShape()){
                switch(x.getColor()){
                    case(1):{
                        g.setColor(Color.yellow);
                        g.fillOval(baseX, baseY, 100, 100);
                        break;
                    }
                    case(2):{
                        g.setColor(Color.red);
                        g.fillOval(baseX, baseY, 100, 100);
                        break;
                    }
                    case(3):{
                        g.setColor(Color.orange);
                        g.fillOval(baseX, baseY, 100, 100);
                        break;
                    }
                    case(4):{
                        g.setColor(Color.blue);
                        g.fillOval(baseX, baseY, 100, 100);
                        break;
                    }
                }
            }
           else
                switch(x.getColor()){
                    case(1):{
                        g.setColor(Color.yellow);
                        g.fillRect(baseX, baseY, 100, 100);
                        break;
                    }
                    case(2):{
                        g.setColor(Color.red);
                        g.fillRect(baseX, baseY, 100, 100);
                        break;
                    }
                    case(3):{
                        g.setColor(Color.orange);
                        g.fillRect(baseX, baseY, 100, 100);
                        break;
                    }
                    case(4):{
                        g.setColor(Color.blue);
                        g.fillRect(baseX, baseY, 100, 100);
                        break;
                    }
                }
            baseX+= 175;
            }
        
    

        

        return objects;
        
    }


    /**
     *
     * @return an array of tiles
     */

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    public void changeTile(int tile)
    {
        tiles.get(tile).randomize();
    }
}
