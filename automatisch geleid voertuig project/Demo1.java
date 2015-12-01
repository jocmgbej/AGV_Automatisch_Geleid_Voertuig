
/**
 * Write a description of class Demo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo1 implements AiInterface
{
    private BoeBotInterface boeBot;
    private float targetSpeed;

    private String infraredSignal;
    private String previousInfraredSignal;
    private int detectionLevel;

    private int waitingTime = 0;
    private boolean direction = false;
    private boolean isTurning = false;
    public Demo1(BoeBotInterface boeBot)
    {
        this.boeBot = boeBot;
    }

    public void update(int deltaTime)
    {
        setup();
        previousInfraredSignal = infraredSignal;
        switch(infraredSignal)
        {
            case "FORWARD":
            targetSpeed += 10;
            break;
            case "BACKWARD":
            targetSpeed -= 10;
            break;
            case "TURN_LEFT":

            break;
            case "TURN_RIGHT":

            break;
            case "STOP":
            targetSpeed = 0;
            break;

            case "TURN45DEG_LEFT":
            waitingTime = 490;
            direction = false;
            isTurning = true;
            break;

            case "TURN90DEG_LEFT":
            waitingTime = 810;
            direction = false;
            isTurning = true;
            break;

            case "TURN180_LEFT":
            waitingTime = 1;
            direction = false;
            isTurning = true;
            break;

            case "TURN45DEG_RIGHT":
            waitingTime = 490;
            direction = true;
            isTurning = true;
            break;

            case "TURN90DEG_RIGHT":
            waitingTime = 810;
            direction = true;
            isTurning = true;
            break;

            case "TURN180DEG_RIGHT":
            waitingTime = 1500;
            direction = true;
            isTurning = true;
            break;
            default:
            targetSpeed = 0;
            break;
        }

        if(targetSpeed > getSpeedBasedOnDetectionLevel(detectionLevel))
            targetSpeed = getSpeedBasedOnDetectionLevel(detectionLevel);

        resolve();
    }

    private void setup()
    {
        infraredSignal = boeBot.getInfraredSignal();
        detectionLevel = boeBot.getDetectionLevel();
    }

    private void resolve ()
    {
        if (isTurning)
        {
          if (waitingTime >= 0)
          {
             boeBot.rotatedegrees(direction);
             waitingTime--;
             System.out.println("isTurning");
          }
          isTurning = false;
        }
        else
        {
        
        if (targetSpeed > 100)
            targetSpeed = 100;
        if (targetSpeed < -100)
            targetSpeed = -100;
        boeBot.goToSpeedIncrement((int)targetSpeed, 4);
        }
    }

    private int getSpeedBasedOnDetectionLevel(int detectionLevel)
    {
        switch(detectionLevel)
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
