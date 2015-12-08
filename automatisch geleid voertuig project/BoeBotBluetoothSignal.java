import TI.*;
import java.util.ArrayList;
/**
 * Write a description of class BoeBotBluetooth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoeBotBluetoothSignal
{
    private SerialConnection connection;
    
    public BoeBotBluetoothSignal()
    {
        connection = new SerialConnection(115200);
    }
    
    public ArrayList<Integer> getData(int maxIterations)
    {
        int i = 0;
        
        ArrayList<Integer> data = new ArrayList<Integer>();
        
        while (i < maxIterations && connection.available() > 0)
        {
            data.add(connection.readByte());
        }
        
        return data;
    }
}
