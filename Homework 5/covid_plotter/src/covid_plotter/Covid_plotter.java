/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid_plotter;
import java.util.*;
import java.io.File;   
import java.io.FileNotFoundException;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author Joshua Wills
 */
public class Covid_plotter extends JFrame {

    /**
     * Constructor for class
     */
    public Covid_plotter() throws FileNotFoundException{
        super("Homework"); 
        System.out.println("*************************");
        System.out.println("******Covid Plotter******");
        System.out.println("*************************");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the covid file");
        
        String fileN = input.nextLine();
        File fileOpen = new File(fileN);
        
        Scanner sc = new Scanner(fileOpen);
        String choice = "";

        while (!choice.toUpperCase().equals("QUIT"))
        {
            System.out.println("Enter Counties to plot, or type quit to end");
            choice = input.nextLine();
            String[] information = choice.split(",");
            ArrayList<String> goodInfo = getCountries(information, fileOpen); //Pass in array of countries typed out
            if (!choice.toUpperCase().equals("QUIT"))
            {
                System.out.println("[D]aily or [C]umulative");
                choice = input.nextLine();
                if (choice.toUpperCase().equals("C"))
                {
                    graphC(goodInfo);
                }
                else
                {
                    graphD(goodInfo);
                }
                
            }
        }
    }
    
        
    private  ArrayList<String> getCountries(String[] countries, File file) throws FileNotFoundException
    {
        ArrayList<String> foundLoc = new ArrayList<String>(); 
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
        {
            String temp = sc.nextLine();
            //String[] information = temp.split("\\s+");
            for (String x: countries)
            {
                if( temp.contains(x) )
                {
                    System.out.println("We found the country " +x+ " in the file");
                    foundLoc.add(temp);
                }
            }
        }
        return foundLoc;
    }
    private void graphC(ArrayList<String> countiesInfo)
    {
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        for (String x : countiesInfo)
        {
            int counter = 0;
            String[] information = x.split("\\s+");

            XYSeries series = new XYSeries(information[0]);
            for (String z : information)
            {
                try{
                    int deaths = Integer.parseInt(z);
                    series.add(counter,deaths);
                    counter ++;
                    }   
                catch(Exception NumberFormatException) 
                    {
                        
                    }
            }
            dataset.addSeries(series);
        }
        XYDataset datasetPrimary = dataset;
        JFreeChart chart = ChartFactory.createXYLineChart("Covid Deaths Total", "days", "Deaths", datasetPrimary);
        JPanel panel = new ChartPanel(chart);
        add(panel, BorderLayout.CENTER);
        setSize(1000, 600);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    private void graphD(ArrayList<String> countiesInfo)
    {
        {
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        for (String x : countiesInfo)
        {
            int counter = 0;
            int last_Deaths = 0;
            String[] information = x.split("\\s+");

            XYSeries series = new XYSeries(information[0]);
            for (String z : information)
            {
                try{
                    int deaths = Integer.parseInt(z);
                    int plot_point = deaths-last_Deaths;
                    last_Deaths = deaths;
                    series.add(counter,plot_point);
                    counter ++;
                    }   
                catch(Exception NumberFormatException) 
                    {
                        
                    }
            }
            dataset.addSeries(series);
        }
        XYDataset datasetPrimary = dataset;
        JFreeChart chart = ChartFactory.createXYLineChart("Covid Deaths Each Day", "days", "Deaths", datasetPrimary);
        JPanel panel = new ChartPanel(chart);
        add(panel, BorderLayout.CENTER);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    }
    public static void main (String[] args) throws FileNotFoundException
    {
        new Covid_plotter();
    }
}
