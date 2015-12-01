import TI.*;

public class Steering2
{
    BoeBotServo servoLeft;
    BoeBotServo servoRight;

    private float increment = 0;
    private float targetSpeedLeft = 0;
    private float targetSpeedRight = 0;
    private float speedLeft;
    private float speedRight;
    
    private int timeLeft;
    private boolean hasStopped = true;

    public Steering2()
    {
        servoLeft = new BoeBotServo(15, false);
        servoRight = new BoeBotServo(14, true);

    }

    public void update(int deltaTime)
    {
        if (servoLeft.getSpeed() != targetSpeedLeft)
        {
            if (servoLeft.getSpeed() < targetSpeedLeft)
            {
                servoLeft.setSpeed(servoLeft.getSpeed()+increment);
                if (servoLeft.getSpeed() > targetSpeedLeft)
                    servoLeft.setSpeed(targetSpeedLeft);
            }
            else
            {
                servoLeft.setSpeed(servoLeft.getSpeed()-increment);
                if (servoLeft.getSpeed() < targetSpeedLeft)
                    servoLeft.setSpeed(targetSpeedLeft);
            }
        }

        if (servoRight.getSpeed() != targetSpeedRight)
        {
            if (servoRight.getSpeed() < targetSpeedRight)
            {
                servoRight.setSpeed(servoRight.getSpeed()+increment);
                if (servoRight.getSpeed() > targetSpeedRight)
                    servoRight.setSpeed(targetSpeedRight);
            }
            else
            {
                servoRight.setSpeed(servoRight.getSpeed()-increment);
                if (servoRight.getSpeed() < targetSpeedRight)
                    servoRight.setSpeed(targetSpeedRight);
            }
        }
        
        if (timeLeft <= 0 && !hasStopped)
        {
            hasStopped = true;
            
            targetSpeedLeft = 0;
            targetSpeedRight = 0;
            
            increment = 8;
        }
        
        timeLeft -= deltaTime;

        //System.out.println("Left " + targetSpeedLeft + ", " + servoLeft.getSpeed() + "\n" +
        //        "Right " + targetSpeedRight + ", " + servoRight.getSpeed() + "\n"); 
    }

    public void goToSpeedIncrement(float targetSpeed, float increment)
    {
        hasStopped = true;
        
        targetSpeedLeft = targetSpeed;
        targetSpeedRight = targetSpeed;
        this.increment = increment; 

        System.out.println("targetSpeed "+ targetSpeed+", targetSpeedLeft " + targetSpeedLeft + ", targetSpeedRight " + targetSpeedRight); 
    }

    public void getSpeed()
    {
        servoLeft.getSpeed();
        servoRight.getSpeed();
    }

    public void TurnDegrees(boolean direction)
    {
        hasStopped = true;
        
        if(direction)
        {
            servoLeft.setSpeed(-100);
            servoRight.setSpeed(100);
        }

        if(!direction)
        {
            servoLeft.setSpeed(100);
            servoRight.setSpeed(-100);
        }
    }
    
    public void turnDegrees(int degrees)
    {
        if (!hasStopped)
        return;
        
        boolean direction = degrees < 0;
        int time = 0;
        
        degrees = (!direction) ? -degrees : degrees;
        
        switch (degrees)
        {
            case 45:
            time = 490;
            break;
            case 90:
            time = 1000;
            break;
        }
        
        timeLeft = time;
        
        if (direction)
        {
            targetSpeedLeft = 100;
            targetSpeedRight = 0;
        }
        else
        {
            targetSpeedLeft = 0;
            targetSpeedRight = 100;
        }
        
        increment = 10;
        hasStopped = false;
    }
}