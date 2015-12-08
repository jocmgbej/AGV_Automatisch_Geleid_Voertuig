/**
 * @Author: Jesse mgbejume
 * @Date: 8-12-2015
 * @Version: 0.1V
 * @Description:
 * Class that is responsable for handeling the Boebot led States.
 */
public class LedHandler
{
    //all neo rgb leds
    private BoeBotLedBase frontRightLed,
                          frontMiddleLed,
                          frontLeftLed,
                          rearRightLed,
                          rearMiddleLed,
                          rearLeftLed;
                          
    //current and previous ledStates;
    private LedStates currentLedState = LedStates.NONE;
    private LedStates previousLedState = LedStates.NONE;
    
    //Constructor
    public LedHandler()
    {
        
    }
    
    //Update function responsable for updating the logic in this loop
    public void update()
    {
        
    }
    
    public void setState(LedStates newLedState)
    {
        if(currentLedState != newLedState)
            currentLedState = newLedState;
    }
    
    public LedStates getCurrentState()
    {
        return currentLedState;
    }
    
    public LedStates getPreviousState()
    {
        return previousState;
    }
   
}
