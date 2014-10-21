import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Duration
{

	private long startTime;
	private long stopTime;
	private String startMessage;
	private String stopMessage;
	
	
	//duration constructor
	public Duration()
	{
		
	}


	//getters and setters
	public long getStartTime()
	{
		return startTime;
	}



	public void setStartTime(long start)
	{
		startTime = start;
	}



	public long getStopTime()
	{
		return stopTime;
	}



	public void setStopTime(long stop)
	{
		stopTime = stop;
	}



	public String getStartMessage()
	{
		return startMessage;
	}



	public void setStartMessage(String startMsg)
	{
		startMessage = startMsg;
	}



	public String getStopMessage()
	{
		return stopMessage;
	}



	public void setStopMessage(String stopMsg)
	{
		stopMessage = stopMsg;
	}
	
	public int getDifference()
	{	int difference=0;
		difference=(int) (getStopTime()-getStartTime());
		return difference;
	}
	

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("| Start Time: ");
		builder.append(getStartTime());
		builder.append(" | Stop Time: ");
		builder.append(getStopTime());
		builder.append(" | Difference of: " + getDifference()+" NS");
		
		//builder.append(" | "+ getDifference() /  1000000000.0 +" Seconds ");
		//...
		
		return builder.toString();
	}
	
	
	
}
