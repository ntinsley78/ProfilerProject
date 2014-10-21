import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//how to check for contains key
//if (!mapProfiler.contains key (k))
//{
//	mapProfiler.put(k, new ArrayList<Duration>())
//}
//
//mapProfiler.get(k).add(StartDuration)





@SuppressWarnings("unused")
public class Profiler
{
	//declarations
	private static Profiler instance = null;
	private boolean enabled = false;
	private int counter = 0;
	private HashMap <String, ArrayList<Duration>> mapProfiler;
	private HashMap <String, Integer> count;
	private Duration newDuration;
	private PrintWriter outPut ;
	private DurationGui reportGui ;
		
	
	//Constructor
	public Profiler() throws FileNotFoundException
	{
		mapProfiler = new HashMap<String,ArrayList<Duration>>();
		count = new HashMap<String, Integer>();
		newDuration = new Duration( );
		outPut = new PrintWriter("outPut.txt");
		reportGui = new DurationGui();
	}
	
	
	
	//get instance to create singleton object
	public static Profiler getInstance() throws FileNotFoundException
	{
		if (instance == null)
		{
			instance = new Profiler();
		}
		return instance;
	}
	
	
	//Getters and Setters
	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean v)
	{
		enabled = v;
	}
	
	
	
	//Methods and functions
	
	//function to start the profiler
	public void start(String k)
	{
		if (isEnabled())
		{
			
			if(!mapProfiler.containsKey(k))
			{
				mapProfiler.put(k, new ArrayList<Duration>());
				
			}	
			
			System.out.println("Software is enabled Starting count for " + k);
			
			newDuration.setStartTime(System.nanoTime());
			newDuration.setStartMessage(k +": has started");
			mapProfiler.get(k).add(newDuration);
			
		}
		else
		{
			System.out.println("Software is not enabled.  Please enable it before starting.");
		}
		
	}
	

	//function to stop the profiler
	public void stop(String k)
	{
		if (isEnabled())
		{
			newDuration.setStopTime(System.nanoTime());
			newDuration.setStopMessage(k + ": has stopped");
			System.out.println("Stopping count for " + k);
			
		}
	}	
	
	
	//function to count the steps
	@SuppressWarnings("unchecked")
	public void count (String k)
	{
		
		count.put(k, counter);
		counter ++;
	}
	


	//function to print report
	public void print() throws IOException
	{
		Iterator iter = mapProfiler.entrySet().iterator();
		Iterator iter2 = count.entrySet().iterator();
		
		while (iter.hasNext())
		{
			Map.Entry entry1 = (Map.Entry) iter.next();
			System.out.println(entry1.getKey() + ": " + entry1.getValue());
			//PrintWriter out = new PrintWriter("filename.txt");
			outPut.println(entry1.getKey() + ": " + entry1.getValue());
			reportGui.updateTextBox(entry1.getKey().toString(), entry1.getValue().toString());
			
			//DurationGui test1 = new DurationGui(entry1.getValue().toString(), entry1.getKey().toString());
		}
		
		while (iter2.hasNext())
		{
			Map.Entry entry2 = (Map.Entry) iter2.next();
			System.out.println(entry2.getKey() +": " + entry2.getValue());
			outPut.println(entry2.getKey() +": " + entry2.getValue());
			reportGui.updateTextBox( entry2.getKey().toString(), entry2.getValue().toString() + "|");
			
		}
		
		
		outPut.close();
		
		
		
	}
	
	
	
}
