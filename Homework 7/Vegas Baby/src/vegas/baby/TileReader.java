/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegas.baby;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joshua Wills
 */
public class TileReader {
    //private FileNameExtensionFilter filter = new FileNameExtensionFilter( "Tile Files", "xml", "txt", "bin");
    private JFileChooser filechooser = new JFileChooser();
    ArrayList<Tile> tiles;
    
    
    public void TileReader(){
        //filechooser.setFileFilter(filter);
        int returnVal = filechooser.showOpenDialog(null);
    }
    private void readText()
    {

    }
    /*
    * Returns new tiles to use
    */
    public ArrayList<Tile> getTiles()
    {
        return tiles;
    }
    
}
