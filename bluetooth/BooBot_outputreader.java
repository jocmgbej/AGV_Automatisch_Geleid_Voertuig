import java.util.ArrayList;

public class BooBot_outputreader 
{

	private String inputString;
	
	public static void main(String[] args) 
	{
		//Get new string
		BooBot_outputreader R =  new BooBot_outputreader();
		R.translate("why u no go forwards!?");
	}

	public BooBot_outputreader()
	{

	}
	
	public ArrayList<Integer> translate(String getinputString)
	{
		ArrayList<Integer> theAwnsers = new ArrayList<Integer>();
		System.out.println(getinputString);
		for (int i =  0; i < getinputString.length(); i++)
			theAwnsers.add((int) (getinputString.charAt(i)));

		theAwnsers.add(10);
		System.out.println(theAwnsers);
		return theAwnsers;
	}
}
