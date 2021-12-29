package lista6;

public abstract class  zwierze  {

	boolean zyje;
	String imie;
	public abstract String dajGlos();
	public  boolean zyje() 
	{
		return zyje;
	}
	zwierze()
	{
		zyje=true;
	}
	zwierze(int liczba)
	{
		
	}
	zwierze(String nazwa)
	{
		this(587);
		zyje=true;
		imie=nazwa;
	}
}
