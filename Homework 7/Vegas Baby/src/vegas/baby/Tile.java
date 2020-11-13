/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegas.baby;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Joshua Wills
 */
public class Tile implements java.io.Serializable{
    /*
    * Using boolean to represent if it's a circle or not a circle
    */
    private boolean circle;
    /*
    * Using an int to describe it's color 1: Yellow, 2: orange, 3: red, 4: blue
    */
    private int color;
    /*
    *default Constructor set the shape to red circle
    */
    public Tile()
    {
        circle = true;
        color = 3;
    }

    /**
     * Set a tile with parameters
     * @param circle
     * @param color
     */

    public Tile(boolean circle, int color)
    {
        this.circle = circle;
        this.color = color;
    }
    
    /**
     * sets color of tile
     * @param color
     */
    public void setColor (int color)
    {
        this.color = color;
    }
    
    /**
     * Sets the shape of the tile
     * @param circle
     */
    public void setShape(boolean circle)
    {
        this.circle = circle;
    }

    /**
     * gets the color of the tile
     * @return number corrisonding to the color
     */
    public int getColor()
    {
        return color;
    }
    
    /**
     * gets the shape of the tile
     * @return true if circle
     */
    public boolean getShape()
    {
        return circle;
    }

    /**
     * Randomly changes state of the tile
     */
    public void randomize()
    {
        int randomizer = (int)((Math.random()*2));
        circle = randomizer == 1;
        color = (int)(Math.random()*4)+1;
        
        
        
    }
    @Override
    public String toString()
    {
        String toS = "A ";
        if (circle)
        {
            toS += "circle that is the color ";
        }
        else
        {
             toS += "square that is the color ";
        }
        switch (color){
            case(1):
            {
                toS += "yellow";
                break;
            }
            case(2):
            {
                toS += "orange";
                break;
            }
            case(3):
            {
                toS += "red";
                break;
            }
            case(4):
            {
                toS += "blue";
                break;
            }
        }
        return toS;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
       
    }
    
    
}
