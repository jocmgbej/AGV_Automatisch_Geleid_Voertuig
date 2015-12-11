import TI.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Signal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Signal
{
    private static Signal instance;
    public static Signal getInstance()
    {
        if(instance != null)
            return instance;
            else
            {
                instance = new Signal();
                return instance;
            }
    }
    
    private BoeBotSpeaker speaker;
    private BoeBotLedBase[] leds;
    
    private boolean playSound;

    // playSound
    private class Sound
    {
        private int frequency;
        private int time;

        public Sound(int frequency, int time)
        {
            this.time = time;
            this.frequency = frequency;
        }

        public int getFrequency()
        {
            return frequency;
        }

        public int getTime()
        {
            return time;
        }

    }
    private ArrayList<Sound> soundQueue;
    private int timeLeft;

    private Signal()
    {
        speaker = new BoeBotSpeaker(5);
        leds = new BoeBotLedBase[6];
        soundQueue = new ArrayList<Sound>();
        initializeNeoLeds();//does what it sais 
        instance = this;
    }

    private void initializeNeoLeds()
    {
        for(int i = 0; i < 6; i++)
            leds[i] = new BoeBotNeoLed(i);
    }
    
    public void turnOffAllNeoLeds()
    {
        for(int i = 0; i < 6; i++)
            leds[i].off();
    }
    
    public void turnOnAllNeoLeds()
    {
        for(int i = 0; i < 6; i++)
            leds[i].on();
    }
    
    public void update(int deltaTime)
    {

        if(playSound)
        {

            if (timeLeft <= 0)
            {
                if(soundQueue.size() > 0)
                {
                    Sound soundToPlay = soundQueue.get(0);
                    speaker.setSound(soundToPlay.getFrequency(), soundToPlay.getTime());
                    timeLeft = soundToPlay.getTime();
                    soundQueue.remove(0);
                }
                else
                {
                    playSound = false;
                }

            }
            timeLeft -= deltaTime;
        }
        
        
        BoeBotNeoLed.setNeo();
    }

    public void playSound(int frequency, int time)
    {
        playSound = true;
        soundQueue.add(new Sound(frequency, time));
    }

    public void forcePlaySound(int frequency, int time)
    {
        timeLeft = time;
        playSound = true;
        speaker.setSound(frequency, time);
    }

    public void setLed(int id, boolean state)
    {
        if (state)
            leds[id].on();
        else 
            leds[id].off();
    }

    public void setLed(int id, Color color)
    {
        leds[id].setColor(color);
    }

    public Color getColor(int id)
    {
        return leds[id].getColor();
    }

}
