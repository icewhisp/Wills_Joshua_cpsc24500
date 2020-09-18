import java.util.*;
/**
 * Generate a random circle and calculate its area and circumference
 *
 * @author Joshua Wills
 * @version Wills
 */
public class CircleCalc
{
    // instance variables - replace the example below with your own
    private int radius;

    /**
     * Constructor for objects of class CircleCalc, randomly assigning radius
     */
    public CircleCalc()
    {
        // initialise instance variables
        radius = (int) (Math.random()*100);
    }

    /**
     * Runs the whole program
     */
    public static void main(String[] args)
    {
        CircleCalc circle = new CircleCalc();
        System.out.printf("The Circle has a radius of %d, an area of %.2f, and a circumference of, %.2f", circle.getRadius(),circle.getArea(),circle.getCircum());
    }
    /**
     * Returns the radius
     */
    public int getRadius()
    {
        return radius;
    }
    /**
     * Returns the area
     */
    public double getArea()
    {
        return radius*radius*3.14;
    }
    /**
     * Returns the circumference
     */
    public double getCircum()
    {
        return radius*2*3.14;
    }
}
