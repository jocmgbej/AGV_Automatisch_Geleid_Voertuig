
/**
 * Configure remote to 077 
 * @author Joshua Latusia
 * @version 2015-11-30
 */
public class SignalCommunication
{   
   
    
    private static  BoeBotInfraredSignal infraredSignal; 
    /**
     *  Initializes a new BoeBotInfraredSignal with port 0
     */
    public SignalCommunication()
    {
        infraredSignal = new BoeBotInfraredSignal(4);
    }
    
    
    
    /**
     * Converts the ints of the signal to a more logical String.
     */
    public static String getInfraredSignal()
    {
        int signal = infraredSignal.getInfraredSignal();
        System.out.println(signal);
        switch (signal)
        {
            
            case -1:
                return "NO_SIGNAL";
            case 144:
                return "FORWARD";                
            case 2192:
                return "BACKWARD";
            case 3216:
                return "TURN_LEFT";
            case 1168:
                return "TURN_RIGHT";
            case 16:
                return "STOP";
                
            // the next cases are for demo 1
            case 2064:
                return "DRIVE_STRAIGHT";
            case 1040:
                return "ACCELERATION";
            case 3088:
                return "TURN45DEG_LEFT";
            case 528:
                return "TURN45DEG_RIGHT";
            case 2576:
                return "TURN90DEG_LEFT";
            case 1552:
                return "TURN90DEG_RIGHT";
            case 3600: 
                return "TURN180DEG_LEFT";
            case 272:
                return "TURN180DEG_RIGHT";
            
                
                
           
            
            default:
                return "INVALID_SIGNAL";  
        }
    }
}
