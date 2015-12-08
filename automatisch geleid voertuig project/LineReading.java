
/**
 * Write a description of class LineReading here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineReading
{
    private int reading;
    
    public LineReading(boolean left, boolean middle, boolean right)
    {
        reading = 0 | boolToInt(left) << 2 | boolToInt(middle) << 1 | boolToInt(right);
    }
    
    public boolean getLeft()
    {
        return intToBool(reading >> 2);
    }
    
    public boolean getMiddle()
    {
        return intToBool(reading >> 1);
    }
    
    public boolean getRight()
    {
        return intToBool(reading);
    }
    
    private int boolToInt(boolean bool)
    {
        if (bool)
            return 1;
        return 0;
    }
    
    private boolean intToBool(int num)
    {
        return num%2 == 1;
    }
}
