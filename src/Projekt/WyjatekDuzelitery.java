package Projekt;

public class WyjatekDuzelitery extends Exception{
	
	private char []temp;
	private int tempory;
	private int dlugosc;
	WyjatekDuzelitery(String nazwa,int co)
	{
		dlugosc=nazwa.length();
		temp=nazwa.toCharArray();
		tempory=temp[0];
		tempory=tempory-32;
		temp[0]=(char)tempory;
		nazwa="";
		for(int i=0;i<dlugosc;i++) 
		{
			nazwa=nazwa+temp[i];
		}
	}
}
