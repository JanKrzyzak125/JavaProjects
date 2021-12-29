package poczatek;

public class WyjatekNick extends Exception {
	
	String wiadomosc;
	WyjatekNick(String nazwa,String powod)
	{
		wiadomosc="zly nick,poniewaz"+powod;
	}

	public String getMessage() {
		return wiadomosc;
	}
}
