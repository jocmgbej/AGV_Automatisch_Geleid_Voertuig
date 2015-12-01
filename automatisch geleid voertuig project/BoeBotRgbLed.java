import java.awt.Color;
import TI.*;
/**
 * Write a description of class BoeBotRgbLed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotRgbLed extends BoeBotLedBase
{
    PWM[] pwms; // 0 = red, 1 = green, 2 = blue
    public BoeBotRgbLed(int port)
    {
        super(port);
        color = new Color(0,0,0);
        pwms = new PWM[3];
        pwms[0] = new PWM(port, 255);
        pwms[1] = new PWM(port + 1, 255);
        pwms[2] = new PWM(port + 2, 255);
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
        setPWMs(); 
    }
    
    public Color getColor()
    {
        return color;
    }
    
    private void setPWMs ()
    {
        pwms[0].update(255-color.getRed());
        pwms[1].update(255-color.getGreen());
        pwms[2].update(255-color.getBlue());
    }
}
