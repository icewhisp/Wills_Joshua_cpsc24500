/*

 */
package homework.pkg3;

/**
 *
 * @author Joshua Wills
 */
public class Card {
    int value;
    String suit;
    String name;
        /**
     *
     * @input A value, a Suit, and the name of the card
     */
    public Card(int v, String s, String n){
        value = v;
        suit = s;
        name = n;
        if (value == 1)
        {
            name = "Ace";
        }
    }
        /**
     *
     * @return A string of either the number or face of the card
     */
    public String getName()
    {
        return name;
    }
        /**
     *
     * @return the suit of the card
     */
    public String getSuit()
    {
        return suit;
    }
        /**
     *
     * @return card value 1-10
     */
    public int getValue()
    {
        return value;
    }

    /**
     *
     * @return what you would normally call the card
     */
    @Override
    public String toString()
    {
        return (name + " of " + suit);
    }
    
}
