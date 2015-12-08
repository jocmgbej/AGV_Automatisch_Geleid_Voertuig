import TI.*;
import java.util.Date;
/**
 * the speaker
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotSpeaker
{
    private final int PORT;
    private long finishedAt;
    
  
   public BoeBotSpeaker(int port)
   {
     PORT = port;
   }
   
   public void setSound(int frequency, int time)
   {
       finishedAt = new Date().getTime() + time;
       
       BoeBot.freqOut(PORT, frequency, time);
   }
   
   public boolean isReady()
   {
      if (new Date().getTime() > finishedAt)
            return true;
      return false;
   }
   
}
