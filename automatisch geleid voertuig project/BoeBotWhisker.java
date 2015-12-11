
/**
 * Write a description of class BoeBotWhisker here.
 * 
 * @author Stefan, Jesse
 * @version V0.0.1
 */
import TI.*;

public class BoeBotWhisker
{
    private final int PORT;
    
    public BoeBotWhisker(int port)
    {
        PORT = port;
    }
    
    public boolean getSignal()
    {
        return BoeBot.digitalRead(PORT);
    }
}
