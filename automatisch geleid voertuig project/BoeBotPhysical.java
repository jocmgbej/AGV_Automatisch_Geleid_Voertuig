import java.awt.Color;
import TI.*;
/**
 * Write a description of class BoeBotPysical here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotPhysical implements BoeBotInterface
{
    private Signal signal;
    private SignalCommunication signalCommunication;
    private ObstacleDetection obstacleDetection;
    private Steering steering;
    
    public BoeBotPhysical()
    {
        signal = new Signal();
        signalCommunication = new SignalCommunication();
        obstacleDetection = new ObstacleDetection();
        steering = new Steering();
    }
    
    // incomming signals
    public Button getInfraredSignal()
    {
        return signalCommunication.getInfraredSignal();
    }
    public int getDetectionLevel()
    {
        return obstacleDetection.getDangerlevel();
    }
    public LineReading getLineReading()
    {
        // @fix needs to be properly implemented
        return new LineReading(false, false, false);
    }
    
    // outgoing signals
    public void playSound(int frequency, int time)
    {
        signal.playSound(frequency, time);
    }
    public void forcePlaySound(int frequency, int time)
    {
        signal.forcePlaySound(frequency, time);
    }
    public void setLed(int id, boolean state)
    {
        signal.setLed(id, state);
    }
    public void setLed(int led, Color color)
    {
        signal.setLed(led, color);
    }
    public void fadeLed(int led, Color target, int time)
    {
        switch (led)
        {
            case 1:
            signal.fadeLed1(target, time);
            case 2:
            signal.fadeLed2(target, time);
        }
    }
    public void fadeLed(int led, Color start, Color target, int time)
    {
        
    }
    
    // controls
    public void goToSpeedIncrement(int speed, int increment)
    {
        steering.goToSpeedIncrement(speed, increment);
    }
    public void goToSpeedTime(int speed, int time)
    {
        System.out.println("goToSpeedTime is currently not supported");
    }
    public void rotatedegrees(boolean direction)
    {
        steering.TurnDegrees(direction);
    }
    public void emergencyStop()
    {
        System.out.println("emergencyStop is currently not supported");
    }
    public void goToSpeedIncrementIndividual(int leftSpeed, int rightSpeed, int increment)
    {
        steering.goToSpeedIncrementIndividual(leftSpeed, rightSpeed, increment);
    }
    public void goToSpeedTimeIndividual(int leftSpeed, int rightSpeed, int time)
    {
        
    }
    // update
    public void update(long deltaTime)
    {
        steering.update((int)(deltaTime/1000000));
        signal.update((int)(deltaTime/1000000));
    }
    
    public void wait(int time)
    {
        BoeBot.wait(time);
    }
}
