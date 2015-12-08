import java.awt.Color;

/**
 * Write a description of class BoeBotLedBase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class BoeBotLedBase
{
    protected final int PORT;
    protected Color color;
    
    public BoeBotLedBase(int port) 
    {
        this.PORT = port;
    }
    
    public abstract void on();
    public abstract void off();
    public abstract void setColor(Color color);
    public abstract Color getColor();

    
    protected static Color addColors(Color a, Color b, int strength)
    {
        double multiplier = 0.01*strength;
        int red = (int)(a.getRed() * multiplier + b.getRed() * (1.0 - multiplier)),
        green = (int)(a.getGreen() * multiplier + b.getGreen() * (1.0 - multiplier)),
        blue = (int)(a.getBlue() * multiplier + b.getBlue() * (1.0 - multiplier));
        
        return new Color(red, green, blue);
    }
    
    protected static int getBrightness(Color color)
    {
        return (color.getRed() + color.getGreen() + color.getBlue())/3;
    }
}
