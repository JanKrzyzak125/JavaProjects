package lista6;

public class delfin extends zwierze 
{
	public int kolor;
	public String dajGlos() 
	{
		return "jestem delfinem";
	}
	
	private int wiek;
	
	public int getWiek() 
	{
		return wiek;
	}
	public void setWiek(int Wiek) 
	{
		this.wiek=Wiek;
	}
	delfin()
	{
		super();
	}
	
	delfin(String nazwa,int liczba,int pomoc)
	{
		
		super(nazwa);
		setWiek(liczba);
		this.kolor=pomoc;
	}
}
