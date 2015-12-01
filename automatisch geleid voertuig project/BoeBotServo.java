
/**
 * Write a description of class BoeBotServo here.
 * 
 * @author Stefan, Jesse 
 * @version V0.0.1
 */

import TI.*;

public class BoeBotServo
{  
    private Servo servo;
    private boolean inverted;
    
    private float speed;
  
    public BoeBotServo(int port, boolean inverted)
    {
        this.inverted = inverted;
        servo = new Servo(port);
    }    
    
    public void setSpeed(float speed)
    {
        this.speed = speed;
        
        if (speed > 100 || speed < -100)
        {
            speed = 0;
            //@fix add @error @BBS001
        }
        
        if(inverted)
            speed = speed * -1;
            
        servo.update(speedToWaveLenght(speed));
    }
    
    public float getSpeed()
    {        
        System.out.println(speed);
        return speed;
    }
    
    private int speedToWaveLenght(float speed)
    {
        return (int)(1500 + (speed * 2));
    }
    
    private float waveLenghtToSpeed(int waveLenght)
    {
        return (float)((waveLenght - 1500 )/ 2);
    }
    
}
