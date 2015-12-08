import TI.*;
/**
 * Converts the Infrared signal from a int to a logical String
 * 
 * @author Joshua Latusia
 * @version 1.2
 * Tested
 */
public class SignalCommunication
{
    private static BoeBotInfraredSignal infraredSignal;
    
    /**
     *  Initializes a new BoeBotInfraredSignal with port 0 
     */
    public SignalCommunication()
    {
        infraredSignal = new BoeBotInfraredSignal(0);
    }
    
    public SignalCommunication(int port)
    {
        infraredSignal = new BoeBotInfraredSignal(port);
    }
    
    /**
     *  Convert the infraredsignal from int to a logical String.
     */
    
    public Button getInfraredSignal()
    {
        int signal = infraredSignal.getInfraredSignal();
        
        // @test_line
        //System.out.println(signal);
        // here are all numbers converted to their button name on the remote
        switch(signal)
        {
            // if there is no signal 
            case -1:
                return Button.noSignal;
            // button 1
            case 0:
                return Button.one;
            // button 2
            case 1:
                return Button.two;
            // button 3
            case 2:
                return Button.three;
            // button 4
            case 3:
                return Button.four;
            // button 5
            case 4:
                return Button.five;
            // button 6
            case 5:
                return Button.six;
            // button 7
            case 6:
                return Button.seven;    
            // button 8
            case 7:
                return Button.eight;
            // button 9
            case 8:
                return Button.nine;
            // button 0
            case 9:
                return Button.zero;
                
            //////////////////////////////////////////////////////////////////////////////////////////////
            
            //power button
            case 21:
                return Button.power;
            //channel + button
            case 88:
                return Button.channelPlus;
            // channel - button
            case 89:
                return Button.channelMinus;
            // volume + button
            case 18:
                return Button.volumePlus;
            // volume - button
            case 19:
                return Button.volumeMinus;
            
            //////////////////////////////////////////////////////////////////////////////////////////////
            
            // back button left of 0 button
            case 29:
                return Button.back;
            // A*B button right og 0 button
            case 23:
                return Button.ab;
            // green square "stop" Button    
            case 95:
                return Button.stop;    
            // red square "record" button
            case 96:
                return Button.record;
            // square button next to record button   
            case 56:
                return Button.square;    
            // red rewind button 
            case 94:
                return Button.rewind;
            // yellow play button    
            case 90:
                return Button.play;    
            //blue forward button
            case 92:
                return Button.forward;
            // "subtitle" Button , under square    
            case 54:
                return Button.subtitle;    
            // green up arrow
            case 116:
                return Button.up;    
            // green left arrow    
            case 52:
                return Button.left;    
            // green OK button
            case 101:
                return Button.ok;
            // green right arrow   
            case 51:
                return Button.right;    
            // green down arrow
            case 117:
                return Button.down;
            
            default:
                return Button.invalidSignal;
                
        }
    }
    
}
