package poczatek;
import java.util.ArrayList;

public class lista10alistasych<T> extends ArrayList<T> 
{
	@Override
	public void add(int i,T e) 
	{
		synchronized(this)
		{
			super.add(i,e);
		}
	}
	@Override
	public boolean add(T e) 
	{
		synchronized(this)
		{
			return super.add(e);
		}
	}
	
	
}
