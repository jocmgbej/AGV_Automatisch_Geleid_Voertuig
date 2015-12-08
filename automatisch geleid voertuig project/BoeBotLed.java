import TI.*;
import java.awt.Color;

/**
 * Write a description of class BoeBotLed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotLed extends BoeBotLedBase
{
    PWM pwm;
    
    public BoeBotLed(int port)
    {
        super(port);
        color = new Color(0,0,0);
        pwm = new PWM(port, 255);
        setPwm();
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
        setPwm();
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setTarget(Color target, int time)
    {  
       setTarget(color, target, time);
    }
    
    public void setTarget(Color beginTarget, Color endTarget, int time)
    {
        int step = (int) (100/time);
        
        for(int i = 0; i < 100; i += step)
        {
            setColor(addColors(beginTarget, endTarget, step));
        }
        
        
        /*  int step = getBrightness(endTarget) - getBrightness(beginTarget);
        if (step > 0)
        {
        while (step > getBrightness(endTarget))
        {
            pwm.update(255-step);
            step--;
        }
        }
        
        if(step < 0)
        {
        while(step < getBrightness(endTarget))
        {
         pwm.update(255-step);
         step++;
        }
        }*/
        
    }
    private void setPwm()
    {
        pwm.update(255 - getBrightness(this.color));
    }
}
