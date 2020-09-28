
package homework.pkg3;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Joshua Wills
 */
public class Homework3 {


    public static void main(String[] args) {
        System.out.println("******************************************");
        System.out.println("*        Welcome to the Game Zone        *");
        System.out.println("******************************************");
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(choice != 3)
        {
            System.out.println("What would you like to play?\n1. Twenty-one\n2. Rock Paper Scissors\n3. Exit");
            System.out.print("Please Enter Your Choice: ");
            choice = sc.nextInt();
            if (choice == 2)
            {
                playRPS();
            }
            else if (choice == 1)
            {
                play21();
            }
            
        }
    }
    private static void playRPS()
    {
         Scanner sc = new Scanner(System.in);
         int choice;
         String mess = "You played ";
         System.out.println("Please enter 1 for paper, 2 for rock, or 3 for Scissors");
         int op = (int) (Math.random()*3)+1;
         choice = sc.nextInt();
         switch (choice){
             case 1:
                 mess +="Paper";
                 switch (op){
                     case 1:
                         mess += " and your oppent played Paper so you TIE";
                         break;
                     case 2:
                         mess += " and your oppent played Rock so you WIN";
                         break;
                     case 3:
                         mess += " and your oppent played Scissors so you LOSE";
                         break;
                 }
                         
                 break;
             case 2:
                 mess +="Rock";
                 switch (op){
                     case 1:
                         mess += " and your oppent played Paper so you LOSE";
                         break;
                     case 2:
                         mess += " and your oppent played Rock so you TIE";
                         break;
                     case 3:
                         mess += " and your oppent played Scissors so you WIN";
                         break;
                 }
                 break;
             case 3:
                 mess +="Scissors";
                 switch (op){
                     case 1:
                         mess += " and your oppent played Paper so you WIN";
                         break;
                     case 2:
                         mess += " and your oppent played Rock so you LOSE";
                         break;
                     case 3:
                         mess += " and your oppent played Scissors so you Tie";
                         break;
                 }
                 break;
             default:
                 mess += "AN INVLAID OPTION";
                 break;    
         }
         System.out.println(mess);
         
         
         
                 
         
    }
    private static void play21()
    {
        int Pvalue = 0;
        int Dvalue = 0;
        boolean bust = false;
        System.out.println("Note this doesn't impliment ace's being wild or spliting have fun!");
        Deck pile = new Deck();
        Card revealed = pile.draw();
        Dvalue += revealed.getValue();
        System.out.println("The dealer shows a " + revealed.toString());
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        revealed = pile.draw();
        System.out.println("You drew a " + revealed.toString());
        Pvalue += revealed.getValue();
        revealed = pile.draw();
        System.out.println("and you drew a " + revealed.toString());
        Pvalue += revealed.getValue();
        while (choice.equals("y"))
        {
            
            System.out.println("Your total hand value is currently " +Pvalue +" Do you wish to hit?");
            choice = sc.next();
            if (choice.equals("y"))
                    {
                        System.out.println("and you drew a " + revealed.toString());
                        Pvalue += revealed.getValue();
                        if (Pvalue >21)
                        {
                            System.out.println("You Busted and lost");
                            bust = true;
                            choice = "n";
                        }
                    }
        }
        if (!bust)
        {
            revealed = pile.draw();
            Dvalue += revealed.getValue();
            System.out.println("The dealer shows a " + revealed.toString());
            while (Dvalue<16)
                {
                revealed = pile.draw();
                Dvalue += revealed.getValue();
                System.out.println("The dealer hits and shows a " + revealed.toString());
                }
        
            if (Dvalue >21)
            {
                System.out.println("The dealer busted and you won!");
            }
            else
            {
                if (Pvalue > Dvalue)
                {
                    System.out.println("You won!");
                }
                else
                {
                    System.out.println("The dealer won!");
                }
            }
        }
    }
    
    
}
