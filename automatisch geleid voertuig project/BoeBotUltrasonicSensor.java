
/**
 * Write a description of class BoeBotUltrasonicDetection here.
 * 
 * @author Stefan, Jesse
 * @version V0.0.1
 */
import TI.*;

public class BoeBotUltrasonicSensor
{
    private final int inputPort;
    private final int outputPort;
    
    public BoeBotUltrasonicSensor(int inputPort, int outputPort)
    {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
    }
    
    public int getDistance()
    {
        BoeBot.digitalWrite(inputPort, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(inputPort, false);
        
        return BoeBot.pulseIn(outputPort, true, 70000);
    }
}
