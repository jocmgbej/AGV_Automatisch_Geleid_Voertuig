import TI.*;
import java.awt.Color;

/**
 * Write a description of class BoeBotNeoLeds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotNeoLed extends BoeBotLedBase
{
    public BoeBotNeoLed(int index)
    {
        super(index);
    }
    
    public void on()
    {
        setColor(Color.white);
    }
    
    public void off()
    {
        setColor(Color.black);
    }
    
    public void setColor(Color color)
    {
        this.color = color;
        
        BoeBot.rgbSet(PORT, this.color);
        setNeo();
    } 
    
    public Color getColor()
    {
        return color;
    }
    
    static void setNeo()
    {
        BoeBot.rgbShow();
    }
}
