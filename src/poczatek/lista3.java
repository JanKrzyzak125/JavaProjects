package poczatek;
import java.util.Scanner;

public class lista3 
{
	public static boolean czyslowomapodslowo(int liczbaslowo,int liczbapodslowo,int miejsce,String slowo,String podslowo) 
	{
		char[] tab1=slowo.toCharArray(),tab2=podslowo.toCharArray();
		boolean tak=false;
		String test1,test2;
		for(int l=0;l<liczbaslowo;l++) 
		{
			   if(tab2[0]==tab1[l]) 
			   {
				   test1=slowo.substring(l,(l+liczbapodslowo-1));
				   test2=podslowo.substring(0,(liczbapodslowo-1));
				   tak=test1.equalsIgnoreCase(test2);
				   if(tak==true)return tak;
			   }
		 }
		return tak;
	}
	public static int szukaniePrzerwy(int wielkosc,String imienazwisko) 
	{
		char pomoc=' ';
		for(int i=0;i<wielkosc-1;i++) 
   	    {
   		     if(pomoc==imienazwisko.charAt(i)) 
   		     {
   		    	 return i;
   		     }
   	    }
		return 0;
	}
	public static int liczenie(int wielkosc,String imienazwisko) 
	{
		int licznik=1;
		char pomoc=' ';
		for(int i=0;i<wielkosc-1;i++) 
   	    {
   		     if(pomoc==imienazwisko.charAt(i))licznik++;
   	    }
		return licznik;
	}
	public static String rozdzielenie(int poczatek,int koniec,String imienazwisko)
	{
		String help="";
		for(int i=poczatek;i<koniec;i++) 
		{
		    help=help+(imienazwisko.charAt(i));	
		}
		return help;
	}
	public static int miesiace(char jeden,char dwa) 
	{
		int pomoc=0;
		if(jeden >=50)return 0; //przypadek gdy jest wprowadzony bledny miesiac patrz wiekszy od 20
		if(jeden==49) 
		{
			pomoc=10;
			if(dwa >51)return 0;//przypadek gdy jest od 13 do 19
			pomoc=pomoc+(dwa-48);
			return pomoc;
		}
		pomoc=dwa-48;
		return pomoc;
	}
	public static int jakaPlec(int temp) 
	{
		return ((temp%2));
	}
	public static void dane(int wiek,int rok) 
	{
		System.out.println("urodziles sie w roku "+(rok-wiek));
	}
	public static void dane(String dataurodzenia) 
	{
		char[] tab=dataurodzenia.toCharArray();
		String miesiace[]= {"blednymiesiac","styczeniu","lutym","marcu","kwietniu","maju","czerwiecu","lipu","sierpieniu","wrzesieniu","pazdzierniku","listopadzie","grudniu"};
		System.out.println("urodziles sie "+tab[0]+tab[1]+" "+miesiace[miesiace(tab[3],tab[4])]+" "+tab[6]+tab[7]+tab[8]+tab[9]);
	}
	public static void dane(String pesel,int rozmiar) 
	{
		String[] plec= {"kobieta","mezczyzna"};
		char[] tab=pesel.toCharArray();
		int temp;
		String miesiace[]= {"blednymiesiac","styczeniu","lutym","marcu","kwietniu","maju","czerwiecu","lipu","sierpieniu","wrzesieniu","pazdzierniku","listopadzie","grudniu"};
		System.out.println("urodziles sie "+tab[4]+tab[5]+" "+miesiace[miesiace(tab[2],tab[3])]+" "+"1"+"9"+tab[0]+tab[1]);
		temp=tab[9];
		temp=temp-48;
		System.out.println("Plec:"+plec[jakaPlec(temp)]);
	}
	public static void dane(int miejsce1,String imienazwisko) 
	{
		int temprozmiar=imienazwisko.length();
		String tempimie="",tempnazwisko="";
		char[]tab1=imienazwisko.toCharArray();
		for(int i=0;i<miejsce1;i++) 
		{
			tempimie=tempimie+tab1[i];
		}
		for(int i=miejsce1+1;i<temprozmiar;i++) 
		{
			tempnazwisko=tempnazwisko+tab1[i];
		}
	    System.out.println("imie:"+tempimie+" "+"nazwisko:"+tempnazwisko);
	}
	public static void dane(boolean cos,String koniec) 
	{
		String[] tabimion= koniec.split(" "); 
		System.out.println("Imie1:"+tabimion[0]+" "+"Imie2:"+tabimion[1]+" "+"Nazwisko:"+tabimion[2]);
	}
	public static void main(String[] args) 
    {
		int program;
		Scanner scan=new Scanner(System.in);
		while(1>0) 
		{
		    System.out.println("Prosze wybrac funkcje listy 3:");
	        System.out.println("0.Zakonczenie programu");
	        System.out.println("1.Rozdzielenie imienia i nazwiska");
	        System.out.println("2.sprawdzenie czy slowo zawiera podslowo");
	        System.out.println("3.sprawdzenie ilosci slow w zdaniu");
	        System.out.println("4.zadanie 4 +lekko zmodyfikowane by bylo 5");
	        program=scan.nextInt();
		    switch(program) 
	      	{
		     case 0: return;
		     case 1:
		    	 int wielkosc,przerwa;
		    	 String imienazwisko,imie,nazwisko;
		    	 System.out.println("Prosze wprowadzic imie i nazwisko razem");
		    	 scan.nextLine();
		    	 imienazwisko=scan.nextLine();
		    	 imienazwisko=imienazwisko.trim();//pozbywa sie przypadkowo pustych miejsc na koncu i poczatku 
		    	 wielkosc=imienazwisko.length();
		    	 if(wielkosc<2) 
		    	 {
		    		 System.out.println("za malo znakow");
		    		 break;
		    	 }
		    	 przerwa=szukaniePrzerwy(wielkosc,imienazwisko);
		    	 if(przerwa==0) 
		    	 {
		    		 System.out.println("brakuje przerwy");
		    		 break;
		    	 }
		    	 imie=rozdzielenie(0,przerwa,imienazwisko);
		    	 nazwisko=rozdzielenie(przerwa,wielkosc,imienazwisko);
		    	 imie=imie.trim();
		    	 nazwisko=nazwisko.trim();
		    	 System.out.println("imie="+imie+" "+"nazwisko="+nazwisko);
		    	 break;
		     case 2:
		    	 boolean prawda;
		    	 int liczbaslowo,liczbapodslowo;
		    	 String slowo,podslowo; 
		    	 System.out.println("Prosze wprowadzic slowo");
		    	 scan.nextLine();
		    	 slowo=scan.nextLine();
		    	 System.out.println("Prosze wprowadzic podslowo");
		    	 podslowo=scan.nextLine();
		    	 slowo=slowo.trim();
		    	 podslowo=podslowo.trim();
		    	 liczbaslowo=slowo.length();
		    	 liczbapodslowo=podslowo.length();
		    	 if(liczbaslowo<liczbapodslowo || liczbapodslowo==0) 
		    	 { 
		    		 System.out.println("slowo za male by miec podslowo takie");
		    		 break;
		    	 }
		    	 prawda=czyslowomapodslowo(liczbaslowo,liczbapodslowo,0,slowo,podslowo);
		    	 if(prawda==true)System.out.println("Jest");
		    	 else System.out.println("Nie jest");
		    	 break;
		     case 3:
		    	 String zdanie;
		    	 System.out.println("Prosze wpisac zdanie:");
		    	 scan.nextLine();
		    	 zdanie=scan.nextLine();
		    	 System.out.println("ilosc zdan w zdaniu="+liczenie(zdanie.length(),zdanie));
		    	 break;
		     case 4:
		    	 int wiek,rok,dlugosc,miejsce1,miejsce2,miejsce3;//dlugosc imienazwisko1 miejsce-wskaznik do psutego miejsca
		    	 String dataurodzenia,pesel,imie12,imienazwisko1,imienazwisko2;
		    	 System.out.println("Prosze podac wiek:");
		    	 wiek=scan.nextInt();
		    	 System.out.println("Prosze podac rok jaki teraz jest aktualnie:");
		    	 rok=scan.nextInt();
		    	 scan.nextLine();
		    	 System.out.println("Prosze podac date urodzenia w formacie dd.mm.rrrr:");
		    	 dataurodzenia=scan.nextLine();
		    	 System.out.println("Prosze podac Pesel(11 cyfr):");
		    	 pesel=scan.nextLine();
		    	 System.out.println("Prosze podac imie nazwisko:");
		    	 imienazwisko1=scan.nextLine();
		    	 System.out.println("Prosze podac pierwsze imie drugie imie nazwisko:");
		    	 imienazwisko2=scan.nextLine();
		    	 dane(wiek,rok);
		    	 dlugosc=dataurodzenia.length();
		    	 if(dlugosc<9) 
		    	 {
		    		 System.out.println("za malo znakow");
		    		 break;
		    	 }
		    	 dane(dataurodzenia);
		    	 dlugosc=pesel.length();
		    	 if(dlugosc<11 || dlugosc >11) 
		    	 {
		    		 System.out.println("bledny pesel");
		    		 break;
		    	 }
		    	 dane(pesel,dlugosc);
		    	 dlugosc=imienazwisko1.length();
		    	 if(dlugosc<2) 
		    	 {
		    		 System.out.println("za malo znakow");
		    		 break;
		    	 }
		    	 miejsce1=szukaniePrzerwy(dlugosc,imienazwisko1);
		    	 if(miejsce1==0) 
		    	 {
		    		 System.out.println("brakuje przerwy");
		    		 break;
		    	 }
		    	 dane(miejsce1,imienazwisko1);
		    	 dane(true,imienazwisko2);
		    	 break;
		     default:
	    	     System.out.println("Prosze wpisac ponownie liczbe");
	    	     break;
		    }
	    }

    }
}
