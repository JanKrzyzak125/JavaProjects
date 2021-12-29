package Projekt;

public class WyjatekLitery extends Exception 
{
	private String wiadomosc;
	WyjatekLitery(String nazwa)
	{
		wiadomosc="nie sa same litery";
	}
	public String getMessage() {
		return wiadomosc;
	}

}
