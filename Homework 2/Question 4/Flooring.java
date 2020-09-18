
/**
 * Calculate how much wood you need to buy
 *
 * @author Joshua Wills
 * @version 1
 */
public class Flooring
{
    private int leftH;
    private int rightH;
    private int topW;
    private int bottomW;
    private double area;
    private double bundles;
    public Flooring (int left, int right, int top, int bot)
    {
        leftH = left;
        rightH = right;
        topW = top;
        bottomW = bot;
    }
    public static void main (String[] args)
    {
        Flooring floor = new Flooring(25,13,10,20);
        floor.area = floor.getArea()*1.2;
        floor.bundles = Math.ceil(floor.area/1.25);
        if (floor.bundles % 6 >0){
            floor.bundles += floor.bundles % 6;
        }
        System.out.println("You need to buy " +floor.bundles/6 + " packages for a total of "+ 24.99*floor.bundles/6+"$");
    }
    public double getArea()
    {
        int base;
        if (leftH<rightH) //Setting the cut out section to the top right
        {
            int temp = rightH;
            rightH = leftH;
            leftH = temp;   
        }
        if (bottomW<topW) //Setting the cut out section to the top right
        {
            int temp = topW;
            topW = bottomW;
            bottomW = temp;   
        }
        base = (leftH*bottomW); //assuming no cute out section
        base -=(.5*(leftH-rightH)*(bottomW-topW));
        System.out.println("Before extra you need to cover "+base + " Square feet");
        return base;
    }
}
