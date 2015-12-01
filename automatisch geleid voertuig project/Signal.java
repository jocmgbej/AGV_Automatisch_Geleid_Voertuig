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
    public static final int left = 0, right = 1;

    private BoeBotSpeaker speaker;
    private BoeBotLedBase[] leds;

    //booleans
    private boolean playSound, fadeLed1, fadeLed2;
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

    //led1
    private Color color1;
    private int time1;

    //led2
    private Color color2;
    private int time2;
    public Signal()
    {
        speaker = new BoeBotSpeaker(5);
        leds = new BoeBotLedBase[2];
        soundQueue = new ArrayList<Sound>();
        leds[0] = new BoeBotLed(0);
        leds[1] = new BoeBotLed(1);
        color1 = new Color(0,0,0);
        color2 = new Color(0,0,0);
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
        
        if(fadeLed1)
        {
            if(timeLeft <= 0 )
            {
                timeLeft = time1;
                int step = (int) (100/time1);
                for (int i=0; i < 100; i += step)
                {  
                    leds[0].setColor(BoeBotLedBase.addColors(leds[0].getColor(), color1, step));
                }
            }
            timeLeft -= deltaTime;
        }
        
        if(fadeLed2)
        {
            if(timeLeft <= 0)
            {
                timeLeft = time2;
                int step = (int) (100/time2);
                for (int i=0; i < 100; i += step)
                {   
                    leds[1].setColor(BoeBotLedBase.addColors(leds[1].getColor(), color2, step));
                }
            }
            timeLeft -= deltaTime;
        }
        
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

    public void fadeLed1 (Color color, int time)
    {
        boolean fadeLed1 = true;
        color1 = color;
        time1 = time;
    }
    
    public void fadeLed2 (Color color, int time)
    {
        boolean fadeLed2 = true;
        color2 = color;
        time2 = time;
    }

    /*
    private int LedToIndex(Led led)
    {
    switch(led)
    {
    case left:
    return 0;
    case right:
    return 1;
    default:
    Error.makeError("SIG 001", "invalid led");
    return 0;
    }
    }
     */
}
