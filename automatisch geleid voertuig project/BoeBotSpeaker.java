import TI.*;
import java.util.Date;
/**
 * Write a description of class BoeBotSpeaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotSpeaker
{
    private final int port;
    private long finishedAt;
    
  
   public BoeBotSpeaker(int port)
   {
     this.port = port;
   }
   
   public void setSound(int frequency, int time)
   {
       finishedAt = new Date().getTime() + time;
       
       BoeBot.freqOut(port, frequency, time);
   }
   
   public boolean isReady()
   {
      if (new Date().getTime() > finishedAt)
            return true;
      return false;
   }
   
}
