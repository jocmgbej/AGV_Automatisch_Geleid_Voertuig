
/**
 * Write a description of class AI_V1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo1AI implements AiInterface
{ 
    private BoeBotInterface boeBot;
    
    public Demo1AI(BoeBotInterface boeBot)
    {
        this.boeBot = boeBot;
    }
    
    public void update(int deltaTime)
    {
        String result = boeBot.getInfraredSignal();
        int detectionLevel = boeBot.getDetectionLevel();
        int speed = getSpeedBasedOnDangerLevel(detectionLevel);
        System.out.println(result + "\n" + detectionLevel + "\n" +  speed);
        
        switch(result)
        {
            case "FORWARD":
            boeBot.goToSpeedIncrement(getSpeedBasedOnDangerLevel(detectionLevel), 20);
            break;
            case "BACKWARD":
            boeBot.goToSpeedIncrement(-50, 4);
            break;
            case "TURN_LEFT":
            //boeBot.rotateSpeed(-100);
            break;
            case "TURN_RIGHT":
            //boeBot.rotateSpeed(100);
            break;
            default:
            boeBot.goToSpeedIncrement(0, 4);
            break;
        }
        
       // if (boeBot.
    }
    
    private int getSpeedBasedOnDangerLevel(int dangerLevel)
    {
        switch(dangerLevel)
        {
        case 0:
        return 0;
        case 1:
        return 0;
        case 2:
        return 20;
        case 3:
        return 40;
        case 4:
        return 60;
        case 5:
        return 80;
        case 6:
        return 100;
        default:
        return 0;
        }
    }
}
