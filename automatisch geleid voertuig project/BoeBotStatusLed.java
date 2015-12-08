import java.awt.Color;
import TI.*;

/**
 * Write a description of class BoeBotStatusLed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotStatusLed extends BoeBotLedBase
{
    public BoeBotStatusLed()
    {
        super(-1);
    }
    
    public void on()
    {
        BoeBot.setStatusLed(true);
        System.out.println("led on");
    }
    
    public void off()
    {
        BoeBot.setStatusLed(false);
        System.out.println("Led off");
    }
    
    public void setColor(Color color)
    {
        this.color = color;
        
        if (getBrightness(this.color) > 128)
        {
            on();
        }
        else
        {
            off();
        }
    }
    
    public Color getColor()
    {
        return color;
    }
}
