import java.awt.Color;
/**
 * Write a description of interface BoeBot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface BoeBotInterface
{
    // incomming signals
    public Button getInfraredSignal();
    public int getDetectionLevel();
    public LineReading getLineReading();
    
    // outgoing signals
    public void playSound(int frequency, int time);
    public void forcePlaySound(int frequency, int time);
    public void setLed(int id, boolean state);
    public void setLed(int led, Color color);
    
    // controls
    public void goToSpeedIncrement(int speed, int increment);
    public void goToSpeedTime(int speed, int time);
    public void rotatedegrees(boolean direction);
    public void emergencyStop();
    public void goToSpeedIncrementIndividual(int leftSpeed, int rightSpeed, int increment);
    public void goToSpeedTimeIndividual(int leftSpeed, int rightSpeed, int time);
    
    // update
    public void update(long deltaTime);
    public void wait(int time);
}
