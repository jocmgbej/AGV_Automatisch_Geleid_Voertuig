
/**
 * Write a description of class Week4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Week4 implements AiInterface
{
    private BoeBotInterface boeBot;
    private AiStates state;
    
    // lineFinding
    private boolean lineFindingDirection;
    private LineReading lastRead;
    private LedHandler ledHandler;

    // custom control
    private int targetSpeed;
    private boolean mode;
    private boolean direction;
    
    public Week4(BoeBotInterface boeBot)
    {
        this.boeBot = boeBot;
        state = AiStates.Remote;
        ledHandler = new LedHandler();
    }
    
    public void update(int deltaTime) // @fix error messages need to be implemented, comments need to be added
    // @test this method should be tested after steering has been tested
    {
        Button button = boeBot.getInfraredSignal();
        int detectionLevel = boeBot.getDetectionLevel();
        LineReading lineReading = boeBot.getLineReading();
        
        ledHandler.update();
        
        switch (state)
        {
            case FollowLine:
                lastRead = lineReading;
            
                if (button == Button.play) // we want to stop following the line 
                {
                    state = AiStates.Remote;
                    boeBot.goToSpeedIncrement(0, 6);
                    targetSpeed = 0;
                }
                else // we want to follow the line
                {
                    if (lineReading.getMiddle())
                    {
                        if (lineReading.getLeft() && lineReading.getRight())
                        {
                            // @fix throw an error / warning
                            boeBot.goToSpeedIncrement(100, 6);
                        }
                        else if (lineReading.getLeft())
                        {
                            boeBot.goToSpeedIncrementIndividual(100, 80, 8);
                        }
                        else if (lineReading.getRight())
                        {
                            boeBot.goToSpeedIncrementIndividual(80, 100, 8);
                        }
                        else
                        {
                            boeBot.goToSpeedIncrement(100, 8);
                        }
                    }
                    else if (lineReading.getLeft() && lineReading.getRight())
                    {
                        // @fix throw an error / warning
                        boeBot.goToSpeedIncrement(100, 6);
                    }
                    else if (lineReading.getLeft())
                    {
                        boeBot.goToSpeedIncrementIndividual(100, 60, 10);
                    }
                    else if (lineReading.getRight())
                    {
                        boeBot.goToSpeedIncrementIndividual(60, 100, 10);
                    }
                    else
                    {
                        // @fix possebly a message / warning
                        state = AiStates.FindingLine;
                        if (lastRead.getLeft())
                            lineFindingDirection = false;
                        else
                            lineFindingDirection = true;
                    }
                }
            break;
            
            case Remote:
                mode = false;
            
                switch (button)
                {
                    case play:
                    state = AiStates.FollowLine;
                    break;
                    case up:
                    targetSpeed += 10;
                    break;
                    case down:
                    targetSpeed -= 10;
                    break;
                    case left:
                    mode = true;
                    direction = false;
                    break;
                    case right:
                    mode = true;
                    direction = true;
                    break;
                }
                
                if (!mode)
                {
                    if (targetSpeed > 100)
                        targetSpeed = 100;
                    if (targetSpeed < -100)
                        targetSpeed = -100;
                        
                    boeBot.goToSpeedIncrement(targetSpeed, 5);
                }
                else
                {
                    boeBot.rotatedegrees(direction);
                }
            break;
            
            case FindingLine:
                if (button == Button.play)
                {
                    state = AiStates.Remote;
                    boeBot.goToSpeedIncrement(0, 6);
                    targetSpeed = 0;
                }
            
                if (lineReading.getLeft() || lineReading.getMiddle() || lineReading.getRight())
                    state = AiStates.FollowLine;
                else
                    boeBot.rotatedegrees(lineFindingDirection);
            break;
            
            default:
            // @ fix throw an error
            break;
        }
    }
}
