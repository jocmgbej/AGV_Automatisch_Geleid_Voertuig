/**
 * @Author: Jesse mgbejume
 * @Date: 8-12-2015
 * @Version: 0.1V
 * @Description:
 * Class that is responsable for handeling the Boebot NeoPixel-led States.
 */

import java.awt.Color;

public class LedHandler
{
    //counter variable
    private int counter = 3;

    //counterboolean
    private boolean flow = false;

    //timer variable
    private int timer = 75;

    //Signal class
    private Signal signal;

    //current and previous ledStates;
    private LedStates currentLedState = LedStates.SEARCHING_LINE;
    private LedStates previousLedState = LedStates.NONE;

    //Constructor
    public LedHandler()
    {
        signal = Signal.getInstance();
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
            backwardLightMotion();
            break;
            case TURNING_LEFT:
            turningLeftLightMotion();
            break;
            case TURNING_RIGHT:
            turningRightLightMotion();
            break;
            case SEARCHING_LINE:
            lineSearchingLight();
            break;
            case MANUAL_CONTROL:
            manualControl();
            break;
            case NONE:
            break;
            case BLOCKED:
            movmentBlocked();
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

            signal.turnOffAllNeoLeds();
            if(flow)
            {
                signal.setLed(3, Color.blue);
                signal.setLed(5, Color.blue);
            }
            else
            {
                signal.setLed(4, Color.blue);
            }
            flow = !flow;
            timer = 75;
        }
    }

    private void backwardLightMotion()
    {
        if(timer == 0)
        {

            signal.turnOffAllNeoLeds();
            if(flow)
            {
                signal.setLed(0, Color.blue);
                signal.setLed(2, Color.blue);
            }
            else
            {
                signal.setLed(1, Color.blue);
            }
            flow = !flow;
            timer = 75;
        }
    }

    public void movmentBlocked()
    {
        if(timer == 0)
        {

            signal.turnOffAllNeoLeds();
            if(flow)
                signal.setLed(4, Color.red);

            else
                signal.setLed(1, Color.red);

            flow = !flow;
            timer = 75;
        }
    }

    public void turningLeftLightMotion()
    {
        if(timer == 0)
        {

            signal.turnOffAllNeoLeds();
            if(flow){
                signal.setLed(2, Color.yellow);
                signal.setLed(5, Color.yellow);
            }
            flow = !flow;
            timer = 75;
        }
    }

    public void turningRightLightMotion()
    {
        if(timer == 0)
        {

            signal.turnOffAllNeoLeds();
            if(flow){
                signal.setLed(0, Color.yellow);
                signal.setLed(3, Color.yellow);
            }
            flow = !flow;
            timer = 75;
        }
    }

    public void manualControl()
    {
        if(!flow)
        {

            signal.turnOffAllNeoLeds();

            for (int i = 0; i>6; i++)
                signal.setLed(i, Color.magenta);
        }
    }
    
    public void lineSearchingLight()
    {
        if(timer == 0)
        {
            
            signal.turnOffAllNeoLeds();
            if(flow)
                counter--;
            else
                counter++;

            if(counter < 3)
            {
                counter = 4;
                flow = false;
            }
            if(counter > 5)
            {
                counter = 4;
                flow = true;
            }
                signal.setLed(counter, Color.white);
            timer = 25;
        }
    }
    
    public void lineFollowingLight()
    {
        if(!flow)
        {
            for (int i = 0; i>6; i++)
                signal.setLed(i, Color.white);
            flow = true;
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
            timer = 75;
            flow = false;
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
