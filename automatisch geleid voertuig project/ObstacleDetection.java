
/**
 * Write a description of class ObstacleDetection here.
 * 
 * @author Stefan, Jesse
 * @version V0.0.1
 */
public class ObstacleDetection
{
    private BoeBotWhisker leftWhisker;
    private BoeBotWhisker rightWhisker;
    private BoeBotUltrasonicSensor ultraSonic;
    
    public ObstacleDetection()
    {
        leftWhisker = new BoeBotWhisker(7);
        rightWhisker = new BoeBotWhisker(8);
        ultraSonic = new BoeBotUltrasonicSensor(5, 6);
    }
    
    public int getDistance()
    {
        return ultraSonic.getDistance(); 
    }
    
    public int getDangerlevel()
    {
        int distance = ultraSonic.getDistance();
        if(distance >= 750 && distance <= 1000)
            return 1;
        else if (distance > 1000 && distance <= 2000)
            return 2;
        else if (distance > 2000 && distance <= 4000)
            return 3;
        else if (distance > 4000 && distance <= 6000)
            return 4;
        else if (distance > 6000 && distance <= 8000)
            return 5;
        else if (distance > 8000)
            return 6;
        
        return 0;
    }

}
