package poczatek;

public class WyjatekPlec extends Exception {

	private String tab[]= {"-ta","-na","-ek","-usz"};
	private String wiadomosc;
	private int koncowka;
	WyjatekPlec(String nazwa)
	{
		wiadomosc="zla plec";
	}
	
	public String getMessage() {
		return wiadomosc;
	}
}
