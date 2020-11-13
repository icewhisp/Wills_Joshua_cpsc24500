/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegas.baby;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Joshua Wills
 */
public class TileWriter {
    private String output;
    public TileWriter(ArrayList<Tile> tiles) throws IOException
    {
        for (Tile x : tiles)
        {
            output += x.toString() + "\n";
        }
        JOptionPane pane = new JOptionPane();
        int option = Integer.parseInt(JOptionPane.showInputDialog("Save as TXT(1), BIN(2), or XML(3)"));
        if (option == 1)
        {
            writeToText();
        }
        else if (option == 2)
        {
            writeToBinary(tiles);
        }
        else if (option == 3)
        {
            writeToXml(tiles);
        }
        
       
    
    }
    
    public void writeToXml(ArrayList<Tile> tiles) throws FileNotFoundException, IOException
    {
        FileOutputStream fileOS = new FileOutputStream("Files.xml");
        XMLEncoder en = new XMLEncoder(fileOS);
        for (Tile x : tiles)
        {
            en.writeObject(x);
        }
        en.close();
        fileOS.close();
        
        
    }
    public void writeToBinary(ArrayList<Tile> tiles) throws IOException
    {
    FileOutputStream fileOS = new FileOutputStream("Files.bin");
    ObjectOutputStream ObjOS  = new ObjectOutputStream(fileOS);
    for (Tile x : tiles)
        {
            ObjOS.writeObject(x);
        }
    
    ObjOS.flush();
    ObjOS.close();

    }
    public void writeToText() throws IOException
    {
        try {
            FileWriter myObj = new FileWriter("Files.txt"); 
            myObj.write(output);
            myObj.close();
        }
        catch (IOException e) {}
        
        
    }
        
    
    
}
