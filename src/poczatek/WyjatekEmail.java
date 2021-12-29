package poczatek;

public class WyjatekEmail extends Exception 
{
	private String wiadomosc;
	WyjatekEmail(String Nazwa)
	{
		wiadomosc="zly email";
	}

	public String getMessage() {
		return wiadomosc;
	}
}
