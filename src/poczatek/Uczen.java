package poczatek;

public class Uczen 
{
	private String imie;
	private int ocena;
	private String kolor; 
	private int rok;
	public static int numerKursu = 13;

	public void setImie(String imie) {this.imie = imie;}
	public void setOcena(int ocena) {if(ocena>0 && ocena<100)this.ocena=ocena;}
	public void setKolor(String kolor) {this.kolor = kolor;}
	public void setRok(int rok) {this.rok=rok;}
	public int getOcena(){return ocena;}
	public String getImie() {return imie;}
	public String getKolor() {return kolor;}
	public int getRok(){return rok;}
	public Uczen(String Imie,int Ocena,String Kolor,int Rok)
	{	
		imie = Imie;
		ocena = Ocena;
		kolor = Kolor;
		rok=Rok;
	}
}
