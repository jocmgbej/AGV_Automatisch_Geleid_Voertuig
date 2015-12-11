
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    // the time we want a update to take
    private static final long desiredUpdateTime = (long)1000000000/ 100;
    
    public static void main(String[] args)
    {
        BoeBotInterface boeBot = new BoeBotEmpty();
        AiInterface ai = new Week4(boeBot);
        
        long lastTime = System.nanoTime();
        
        while (true)
        {
            long currentTime = System.nanoTime();
            long deltaTime = currentTime - lastTime; // the ammount of time it took the last cycle
            lastTime = currentTime;
            
            ai.update((int)(deltaTime/1000000));
            boeBot.update(deltaTime);
            
            // the ammount of time it took to update
            long procesedTime = System.nanoTime() - currentTime; 
            
            // checks if the frame took "to long"
            if (procesedTime < desiredUpdateTime)
            {
                // calculates the ammount of time we need to wait in order to make the cycle
                // take as long as the disired update time
                int waitMs = (int)((desiredUpdateTime - procesedTime)/1000000);
                boeBot.wait(waitMs);
            }
        }
    }
}
