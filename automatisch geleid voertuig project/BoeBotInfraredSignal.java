import TI.*;
/** 
 * @author Joshua Latusia
 * @version  1.2  date 2015/12/01
 * Tested
 */
public class BoeBotInfraredSignal
{
      // this is the GPIO pin where the sensor is connected to.
    private final int SENSOR_PORT;
    
    /**
     *  port = in what in the infrared sensor is connected.
     */
    public BoeBotInfraredSignal(int port)
    {
        SENSOR_PORT = port;
    }
    
    
    /**
     * reads incoming infrared signals from a remote and converts and returns this
     * as an int.
     */
    public int getInfraredSignal()
    {
        while(true)
        {
            // LEAVE IT AT 20000 !!!
            int pulseLength = BoeBot.pulseIn(SENSOR_PORT, false, 20000);
            if(pulseLength > 2000)
            {
                // creates a new Array which will contain the data of the a pulse
                int pulseData[] = new int[12];
                
                // here the 12 different dates from reading the infrared signal be stored
                for(int i = 0; i < 12; i++)
                    pulseData[i] = BoeBot.pulseIn(SENSOR_PORT, false, 20000)   ;
                
                    
                /*   @test_line
                for(int i = 0; i < 12; i++)
                System.out.print (pulseData[i]+" - ");
                */
                   
                   
                // initializes the decimal number of the infrared signal
                int decimalSignal = 0;
                // used to convert the elemens of pulseData to binary
                int r = 1;
                
                    
                // converts the pulse date of the button adres to a normal number
                for(int i = 0; i < 7; i++)
                {

                     if(pulseData[i] > 1000)
                    {
                     decimalSignal = decimalSignal + (1 * r);
                    }
                    r = r * 2;                   
                }
                
                 
                // @test_line to see what signal ID gets retrieved.
                //System.out.println(decimalSignal);
                
                return decimalSignal;
            }
            // if there is nog signal detected it returns -1
            return -1;
           }   
    }
}

