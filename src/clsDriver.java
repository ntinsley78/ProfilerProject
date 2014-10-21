import java.io.FileNotFoundException;
import java.io.IOException;


public class clsDriver
{
	public static void main(String[] args) throws IOException
	{
		Profiler.getInstance().setEnabled(true);
		Profiler.getInstance().start ("Driver");
		
		for(int i=0 ; i < 4; i++)
		{
			Profiler.getInstance().start("Foo Test");
			foo();
			Profiler.getInstance().stop("Foo test");
			Profiler.getInstance().count("loop count");
		}

		Profiler.getInstance().stop("Driver");
		Profiler.getInstance().print();
		
	}
	
	public static void foo()
	{
		for(int i = 0; i < 10; i++)
		{
			try
			{
				Profiler.getInstance().start("Foo 2");
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("this is in foo");
			try
			{
				Profiler.getInstance().stop("Foo 2");
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
}
