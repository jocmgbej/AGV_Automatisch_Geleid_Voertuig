
/**
 * Write a description of class BoeBotWhisker here.
 * 
 * @author Stefan, Jesse
 * @version V0.0.1
 */
import TI.*;

public class BoeBotWhisker
{
    private final int port;
    
    public BoeBotWhisker(int port)
    {
        this.port = port;
    }
    
    public boolean getSignal()
    {
        return BoeBot.digitalRead(port);
    }
}
