import java.awt.Color;
/**
 * Write a description of class BoeBotEmpty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotEmpty implements BoeBotInterface
{
    // incomming signals
    public String getInfraredSignal()
    {
        return "";
    }
    public int getDetectionLevel()
    {
        return 0;
    }
    
    // outgoing signals
    public void playSound(int frequency, int time) {};
    public void forcePlaySound(int frequency, int time) {};
    public void setLed(int id, boolean state) {};
    public void setLed(int led, Color color) {};
    public void fadeLed(int led, Color target, int time) {};
    public void fadeLed(int led, Color start, Color target, int time) {};
    
    // controls
    public void goToSpeedIncrement(int speed, int increment) {};
    public void goToSpeedTime(int speed, int time) {};
    public void rotatedegrees(boolean direction){};
    public void emergencyStop() {};
    
    // update
    public void update(long deltaTime) {};
    public void wait(int time) {};
}
