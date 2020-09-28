
package homework.pkg3;
import java.util.ArrayList;
/**
 *
 * @author Joshua Wills
 */
public class Deck {
    ArrayList<Card> pile = new ArrayList<Card>();
    public Deck()
    {
        fillDeck();
    }
    private void fillDeck()
    {
        String TempS;
        for(int i =0; i<4;i++) //Adding cards to deck on creation 4 suits
        {
            switch (i) {
                case 0:
                    TempS = "Hearts";
                    break;
                case 1:
                    TempS = "Diamonds";
                    break;
                case 2:
                    TempS = "Spades";
                    break;
                default:
                    TempS = "Clubs";
                    break;
            }
            for(int j =1; j<12;j++) //ten easy cards + giving up trying to impliment ace's being wild
            {
                pile.add(new Card(j,TempS,Integer.toString(j)));
            }
            pile.add(new Card(10,TempS,"King"));//Face cards
            pile.add(new Card(10,TempS,"Queen"));//Face cards
            pile.add(new Card(10,TempS,"Jack"));//Face cards
        
        }
        
    }
    public Card draw()
    {
        int choice = (int) (Math.random()*pile.size());
        Card tempC = pile.get(choice);
        pile.remove(choice);
        return tempC;
    }
    
}
