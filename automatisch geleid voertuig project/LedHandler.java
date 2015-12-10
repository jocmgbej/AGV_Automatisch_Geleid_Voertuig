/**
 * @Author: Jesse mgbejume
 * @Date: 8-12-2015
 * @Version: 0.1V
 * @Description:
 * Class that is responsable for handeling the Boebot led States.
 */

import java.awt.Color;

public class LedHandler
{
    //alle led indexes
    private final int ledFrontRight = 0;
    private final int ledFrontMiddle = 1;
    private final int ledFrontLeft = 2;
    private final int ledRearRight = 3;
    private final int ledRearMiddle = 4;
    private final int ledRearLeft = 5;
    
    //counter variable
    private int counter = 0;
    
    //timer variable
    private int timer = 300;
    
    //all neo rgb leds
    private BoeBotLedBase[] neoLeds;
                          
    //current and previous ledStates;
    private LedStates currentLedState = LedStates.FORWARD;
    private LedStates previousLedState = LedStates.NONE;
    
    //Constructor
    public LedHandler()
    {        
        initializeLeds();   
        neoLeds = new BoeBotLedBase[6];
    }
    
    //initialize all neo leds
    private void initializeLeds()
    {
        for(int i = 0; i < 6; i++)
        {
            neoLeds[i] = new BoeBotNeoLed(i);
            System.out.println("loaded neo led " + i);
        }
    }
    
    //Update function responsable for updating the logic in this loop
    public void update()
    {
        switch(currentLedState)
        {
            case FORWARD:
            forwardLightMotion();
            break;
            case BACKWARD:
            break;
            case TURNING_LEFT:
            break;
            case TURNING_RIGHT:
            break;
            case SEARCHING_LINE:
            break;
            case MANUAL_CONTROL:
            break;
            case NONE:
            break;
        }
        //decrease if not 0
        if(timer != 0)
            timer--;
    }
    
    //when going forward 
    private void forwardLightMotion()
    {
        if(timer == 0)
        {
            counter++;
            if(counter > 2)
                counter = 0;
            turnOffAllLeds();            
            neoLeds[counter].setColor(Color.red);
            timer = 300;
        }
    }
    
    
    //shut down all leds
    private void turnOffAllLeds()
    {
        for(int i = 0; i < 6; i++)
        {
            neoLeds[i].off();
        }
    }
    
    //turn on all leds white
    private void turnOnAllLeds()
    {
        turnOnAllLeds(Color.white);
    }
    
    //turn on all leds with Color
    private void turnOnAllLeds(Color color)
    {
        for(int i = 0; i < 6; i++)
        {
            neoLeds[i].setColor(color);
        }
    }
    
    //set the new ledState
    public void setState(LedStates newLedState)
    {
        if(currentLedState != newLedState)
        {
            previousLedState = currentLedState;
            currentLedState = newLedState;        
            counter = 0;
            timer = 300;
        }
    }
    
    //get current ledstate
    public LedStates getCurrentState()
    {
        return currentLedState;
    }
    
    //get previous ledstate
    public LedStates getPreviousState()
    {
        return previousLedState;
    }
   
}
