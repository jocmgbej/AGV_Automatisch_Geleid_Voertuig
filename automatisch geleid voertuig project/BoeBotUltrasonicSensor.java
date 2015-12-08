
/**
 * Write a description of class BoeBotUltrasonicDetection here.
 * 
 * @author Stefan, Jesse
 * @version V0.0.1
 */
import TI.*;

public class BoeBotUltrasonicSensor
{
    private final int INPUT_PORT;
    private final int OUTPUT_PORT;
    
    public BoeBotUltrasonicSensor(int inputPort, int outputPort)
    {
        INPUT_PORT = inputPort;
        OUTPUT_PORT = outputPort;
    }
    
    public int getDistance()
    {
        BoeBot.digitalWrite(INPUT_PORT, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(INPUT_PORT, false);
        
        return BoeBot.pulseIn(OUTPUT_PORT, true, 70000);
    }
}
