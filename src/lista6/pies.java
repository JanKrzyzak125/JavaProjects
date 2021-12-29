package lista6;

public class pies extends zwierze implements dlapsa 
{
	private int wiek;
	public int lata;
	private String text;
	public boolean rasowosc;
	public int getWiek() 
	{
		return wiek;
	}
	public void setWiek(int Wiek) 
	{
		this.wiek=Wiek;
	}
	public void setText(String temp) 
	{
		this.text=temp;
	}
	public String dajGlos() 
	{
		return "jestem psem";
	}
	public String toString() 
	{
		return ("nice udalo ci sie");
	}
	public String nazwarasy() 
	{
		return (this.text);
	}
	public boolean rasa() 
	{
		return rasowosc;
	}
	pies()
	{
		super();
	}
	
	pies(String nazwa ,int liczba,boolean prawda)
	{
		super(nazwa);
		setWiek(liczba);
		lata=liczba;
		this.rasowosc=prawda;
	}
}
