import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a description of class Error here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Error
{    
    static void makeError(String errorCode, String errorMessage)
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        
        System.out.println("ERROR " + errorCode + ": " + errorMessage + " | " + dateFormat.format(date));
    }
}
