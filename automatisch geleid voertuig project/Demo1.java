
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
    private int detectionLevel;

    private int timoutTimer = 0;

    private boolean isTurning = false;
    private int turnTimeLeft = 0;

    public Demo1(BoeBotInterface boeBot)
    {
        this.boeBot = boeBot;
    }

    public void update(int deltaTime)
    {
        setup();

        System.out.println(infraredSignal);

        if (!isTurning)
        {
            switch(infraredSignal)
            {
                case "FORWARD":
                targetSpeed += 10;
                timoutTimer = 1000;
                break;
                case "BACKWARD":
                targetSpeed -= 10;
                timoutTimer = 1000;
                break;

                case "STOP":
                targetSpeed = 0;
                break;

                case "TURN45DEG_LEFT":
                isTurning = true;
                turnTimeLeft = -490;
                break;

                case "TURN90DEG_LEFT":
                isTurning = true;
                turnTimeLeft = -810;
                break;

                case "TURN180_LEFT":
                isTurning = true;
                turnTimeLeft = -1500;
                break;

                case "TURN45DEG_RIGHT":
                isTurning = true;
                turnTimeLeft = 490;
                break;

                case "TURN90DEG_RIGHT":
                isTurning = true;
                turnTimeLeft = 810;
                break;

                case "TURN180DEG_RIGHT":
                isTurning = true;
                turnTimeLeft = 1500;
                break;
                default:
                if (!isTurning)
                {
                    timoutTimer -= deltaTime;
                    if (timoutTimer <= 0)
                        targetSpeed = 0;
                }
                break;
            }
        }
        turnTimeLeft -= deltaTime;

        if (turnTimeLeft <= 0 && isTurning)
            isTurning = false;

        if(targetSpeed > getSpeedBasedOnDetectionLevel(detectionLevel) && !isTurning)
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
        if (!isTurning)
        {
            System.out.println("resolve targetSpeed " + targetSpeed);

            if (targetSpeed > 100)
                targetSpeed = 100;
            if (targetSpeed < -100)
                targetSpeed = -100;
            boeBot.goToSpeedIncrement((int)targetSpeed, 4);
        }
        else
        {
            boeBot.rotatedegrees(targetSpeed >= 0);
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
