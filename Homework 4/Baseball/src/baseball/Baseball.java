
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;
import java.util.*;
import java.io.File;   
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Baseball {

    static String[]  AlEast = new String[5];
    static String[] AlCentral = new String[5];
    static String[] AlWest = new String[5];
    static String[] NlEast = new String[5];
    static String[] NlCentral = new String[5];
    static String[] NlWest = new String[5];
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("*************************");
        System.out.println("SEBALL STANDINGS ANALYZER");
        System.out.println("*************************");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the standings file");
        String fileN = input.nextLine();
        System.out.println(fileN);
        File file = new File(fileN);
        Scanner sc = new Scanner(file);
        int league = 0;
        while (sc.hasNextLine())
        {
            String temp = sc.nextLine();
            System.out.println(temp);
            String[] information = temp.split("\\s+");
           
            
            if (information[0].equals("League"))
            {
                league ++;
            }
            else
            {
                String form = format(temp);
                switch (league){
                    case 1:
                        
                        addStat(form,1);
                        break;
                    case 2:
                        addStat(form,2);
                        break;
                    case 3:
                        addStat(form,3);
                        break;
                    case 4:
                        addStat(form,4);
                        break;
                    case 5:
                        addStat(form,5);
                        break;
                    case 6:
                        addStat(form,6);
                        break;
                        
                }
                        
            }
        }
        runLoop();
    }
    private static String format(String line)
    {
        String[] information = line.split("\\s+");
        String name = "";
        for (String x : information)
        {
            try{
                int bob = Integer.parseInt(x);
            }
            catch(Exception NumberFormatException) 
                    {
                        name += x+" ";
                    }
                
            
        }
        float wins = Float.parseFloat(information[information.length-2]);
        float losses = Float.parseFloat(information[information.length-1]);
        float wR = wins/(wins+losses);
        DecimalFormat df = new DecimalFormat("#.###");
        if(name.length()<8)
        {
            String returnS = name + "\t\t" +information[information.length-2]+"\t"+information[information.length-1]+"\t \t"+df.format(wR);
            return returnS;
        }
        else
        {
            String returnS = name + "\t" +information[information.length-2]+"\t"+information[information.length-1]+"\t \t"+df.format(wR);
            return returnS;
        }
        
        
    }
    private static void addStat(String line, int location)
    {
        switch (location){
            case 1:
                for(int i = 0; i<AlEast.length; i++) { //filling first open slot
                    if(AlEast[i] == null)
                        {
                           AlEast[i] = line;
                           break;
                        }
                    }
                break;
            case 2:
                for(int i = 0; i<AlCentral.length; i++) { //filling first open slot
                    if(AlCentral[i] == null)
                        {
                           AlCentral[i] = line;
                           break;
                        }
                    }
                break;
            case 3:
                for(int i = 0; i<AlWest.length; i++) { //filling first open slot
                    if(AlWest[i] == null)
                        {
                           AlWest[i] = line;
                           break;
                        }
                    }
                break;
            case 4:
                for(int i = 0; i<NlEast.length; i++) { //filling first open slot
                    if(NlEast[i] == null)
                        {
                           NlEast[i] = line;
                           break;
                        }
                    }
                break;
            case 5:
                for(int i = 0; i<NlCentral.length; i++) { //filling first open slot
                    if(NlCentral[i] == null)
                        {
                           NlCentral[i] = line;
                           break;
                        }
                    }
                break;
            case 6:
                for(int i = 0; i<NlWest.length; i++) { //filling first open slot
                    if(NlWest[i] == null)
                        {
                           NlWest[i] = line;
                           break;
                        }
                    }
                break;
                
        }
    }
    private static void runLoop()
    {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != 8)
        {
            System.out.println("Which standings would you like to see?");
            System.out.println("1. Al East");
            System.out.println("2. Al Central");
            System.out.println("3. Al West");
            System.out.println("4. Nl East");
            System.out.println("5. Nl Central");
            System.out.println("6. Nl West");
            System.out.println("7. Overall");
            System.out.println("8. Exit");
            choice = input.nextInt();
            switch (choice){
                    case 1:
                        
                        printStat(1);
                        break;
                    case 2:
                        printStat(2);
                        break;
                    case 3:
                        printStat(3);
                        break;
                    case 4:
                        printStat(4);
                        break;
                    case 5:
                        printStat(5);
                        break;
                    case 6:
                        printStat(6);
                        break;
                    case 7:
                        printStat(7);
                        break;
        }
    }
    }
    private static void printStat(int team)
    {
        System.out.println("Team \t\t Wins \t Losses \t Win Rate");
        switch (team){
                    case 1:
                        
                        for(String i: AlEast){
                            System.out.println(i);
                        }
                        break;
                    case 2:
                        for(String i: AlCentral){
                            System.out.println(i);
                        }
                        break;
                    case 3:
                        for(String i: AlWest){
                            System.out.println(i);
                        }
                        break;
                    case 4:
                        for(String i: NlEast){
                            System.out.println(i);
                        }
                        break;
                    case 5:
                        for(String i: NlCentral){
                            System.out.println(i);
                        }
                        break;
                    case 6:
                        for(String i: NlWest){
                            System.out.println(i);
                        }
                        break;
                    case 7:
                        for(String i: AlEast){
                            System.out.println(i);
                        }
                        for(String i: AlCentral){
                            System.out.println(i);
                        }
                        for(String i: AlWest){
                            System.out.println(i);
                        }
                        for(String i: NlEast){
                            System.out.println(i);
                        }
                        for(String i: NlCentral){
                            System.out.println(i);
                        }
                        for(String i: NlWest){
                            System.out.println(i);
                        }
                        break;
        }
        
    }
    
}
