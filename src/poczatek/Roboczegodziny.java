package poczatek;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Roboczegodziny 
{
	public static void wypisanie(int koniec)
	{
		System.out.println("sumadni="+koniec);
	}
	
	public static boolean Czyrokprzestepny(int rokA) 
	{
		float help=rokA,help1=rokA,help2=rokA;
		help=help/400; //czy rok jest podzielny przez 400
		help=help*400;
		help1=help1/4; //czy rok jest podzielny przez cztery ale nie podzielny przez 100
		help1=help1*4;
		help2=help2/100;
		help2=help2*100;
		if(rokA==help ||(help1==rokA && help2!=rokA))return true;
		else return false;
	}
	public static int naprawaRoku(String dane) 
	{
		int pierwsza,druga,trzecia,czwarta;
		char[]pomocnicze;
		pomocnicze=dane.toCharArray();
		pierwsza=(pomocnicze[6]-48)*1000;
		druga=(pomocnicze[7]-48)*100;
		trzecia=(pomocnicze[8]-48)*10;
		czwarta=(pomocnicze[9]-48)*1;
		return pierwsza+druga+trzecia+czwarta;
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException
	{
		Scanner scan = new Scanner(System.in);//sa tutaj dwa zadania 1 i 2 z listy 2 
		int program,pracowniczeminuty,trybpracy; 
		int dni=0,godziny=0,minuty=0;
		while(1>0) 
		{
		   	System.out.println("Prosze wybrac funkcje listy 2:");
		    System.out.println("0.Zakonczenie programu");
		    System.out.println("1.wyliczenie z minut ile przepracowal dany pracownik w wybranym przez uzytkownika trybie pracy");
		    System.out.println("2.ProstyKalkulator");
		    System.out.println("3*.Program liczacy dni od dwoch dat+lista 4 zadanie3");
		    System.out.println("4.Program ktory pokaze roznice miedzy & a &&");
		    System.out.println("5.praktyczne zastosowanie operatorów bitowych &, >> ,<<.");
		    System.out.println("6*.operatorów bitowych do zamiany trzeciego bitu");
		    System.out.println("klasa nauczyciel.system oceniania nazwowy(trza wlaczyc z klasy nauczyciel)");
		    program=scan.nextInt();
		    switch(program) 
	     	{
	    	case 0:
		    	return;
	    	case 1: 
	        	System.out.println("Prosze podac tryb pracy pracownika=");
	    	    trybpracy=scan.nextInt();
		        System.out.println("Prosze podac ile minut pracownik pracowal=");
	        	pracowniczeminuty=scan.nextInt();
	        	trybpracy=trybpracy*60;
	        	while(pracowniczeminuty>=trybpracy) 
		        {
		        	dni++;
	        		pracowniczeminuty=pracowniczeminuty-trybpracy;
	    	    }
	        	while(pracowniczeminuty>=60) 
	        	{
	    	    	godziny++;
		        	pracowniczeminuty=pracowniczeminuty-60;
	    	    }
	        	minuty=pracowniczeminuty;
	         	System.out.println("Przepracowanie :"+"Dni="+dni+" "+"Godziny="+" "+godziny+"Minuty="+" "+minuty);
		        break;
	    	case 2:
	    		float a,b,wynik=0;
	    		int znak,poprawnosc=0;
	    		System.out.println("Prosze podac liczbe a=");
	    		a=scan.nextFloat();
	    		System.out.println("Prosze podac liczbe b=");
	    		b=scan.nextFloat();
	    		System.out.println("Prosze podac dzialanie(1.+,2.-,3.*,4./)=");
	    		znak=scan.nextInt();
	    		switch(znak) 
	    		{
	    		case 1:
	    			wynik=a+b;
	    			poprawnosc=1;
	    			break;
	    		case 2:
	    			wynik=a-b;
	    			poprawnosc=1;
	    			break;
	    		case 3:
	    			wynik=a*b;
	    			poprawnosc=1;
	    			break;
	    		case 4:
	    			if(a==0)poprawnosc=0;
	    			else poprawnosc=1;
	    			wynik=a/b;
	    			break;
	    		default:
	    			System.out.println("niepoprawne dzialanie");
	    			break;
	    		}
	    		if(poprawnosc==1) System.out.println("Wynik"+wynik);
	    		else System.out.println("niepoprawny wynik");
	    		break;	
	    	case 3:
	    		int dzienA,miesiacA,rokA,dzienB,miesiacB,rokB,miesiacHelp,rokHelp,sumadni=0,temp,pomoc=13;
	    		int[] tabM={0,31,28,31,30,31,30,31,31,30,31,30,31};
	    	    String pattern ="dd.MM.yyyy";
         	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
          	    String input1,input2; 
	    	    System.out.println("Prosze podac pierwsza date dzien.miesiac.rok"); 
	    	    scan.nextLine();
	    	    input1=scan.nextLine();
	    	    rokA=naprawaRoku(input1);
	    	    Date data1 = simpleDateFormat.parse(input1);
          	    System.out.println(data1);
	    	    System.out.println("Prosze podac druga date dzien.miesiac.rok");
	    	    input2=scan.nextLine();
	    	    rokB=naprawaRoku(input2);
	    	    Date data2 = simpleDateFormat.parse(input2);
	    	    System.out.println(data2);
	    		boolean rokprzestepny;
	    		dzienA=data1.getDate();
	    		miesiacA=data1.getMonth()+1;
	    		System.out.println(rokA);
	    		dzienB=data2.getDate();
	    		miesiacB=data2.getMonth()+1;
	    		System.out.println(rokB);
	    		if(rokA>rokB) //jesli data A jest wieksza od B to zmienia kolejnosc w celu usystemowania ¿e rok A jest wczeœniej a rok B pó¿niej
	    		{
	    			 temp=rokA;
	    		     rokA = rokB; 
	    		     rokB = temp;
	    		     temp=miesiacA;
	    		     miesiacA = miesiacB; 
	    		     miesiacB = temp;
	    		     temp=dzienA;
	    		     dzienA = dzienB; 
	    		     dzienB = temp;
	    		}
	    		if(rokA!=rokB) 
	    		{ 
	    		     rokHelp=rokA+1;
	    		     while(rokHelp!=rokB) 
	    		     {
	    		    	 rokprzestepny=Czyrokprzestepny(rokHelp);
	    		    	 if(rokprzestepny)sumadni=sumadni+1;
	    		    	 sumadni=sumadni+365;
	    			     rokHelp=rokHelp+1;
	    			     
	    		     }
	    		     miesiacHelp=miesiacA;
	    		     if(miesiacHelp!=12)miesiacHelp=1+miesiacHelp;
	    		     while(miesiacHelp!=13) 
	    		     {
	    		    	 sumadni=sumadni+tabM[miesiacHelp];
	    		    	 miesiacHelp=miesiacHelp+1;
	    		     }
	    		     rokprzestepny=Czyrokprzestepny(rokA);
	    		     if(rokprzestepny && miesiacA!=1)sumadni=sumadni+1;
	    		     sumadni=sumadni+(tabM[miesiacA]-dzienA);
	    		     miesiacHelp=miesiacB;
	    		     miesiacHelp=miesiacHelp-1;
	    		     while(miesiacHelp!=0) 
	    		     {
	    		    	 sumadni=sumadni+tabM[miesiacHelp];
	    		    	 miesiacHelp=miesiacHelp-1;
	    		     }
	    		     rokprzestepny=Czyrokprzestepny(rokB);
	    		     if(rokprzestepny && miesiacB>2)sumadni=sumadni+1;
	    		     sumadni=sumadni+(dzienB);
	    		     wypisanie(sumadni-1);
	    		     break;
	    		}
	    		else //przypadek gdy sa te same lata zrobiony?
	    		{
	    			if(miesiacA==miesiacB) 
	    			{
	    				if(dzienA>dzienB)wypisanie(dzienA-dzienB);
	    				else wypisanie(dzienB-dzienA);
	    				break;
	    			}
	    			else 
	    			{
	    				if(miesiacA>miesiacB) 
	    				{
	    					 temp=rokA;
	   	    		         rokA = rokB; 
	   	    		         rokB = temp;
	    					 temp=miesiacA;
	    	    		     miesiacA = miesiacB; 
	    	    		     miesiacB = temp;
	    	    		     temp=dzienA;
	    	    		     dzienA = dzienB; 
	    	    		     dzienB = temp;
	    				}
	    				miesiacHelp=miesiacA+1;
	    				while(miesiacHelp!=miesiacB) 
	    				{
	    					sumadni=sumadni+tabM[miesiacHelp];
	    					miesiacHelp=miesiacHelp+1;
	    				}
	    			    sumadni=sumadni+(tabM[miesiacA]-dzienA)+dzienB;
	    			    rokprzestepny=Czyrokprzestepny(rokA);
	    			    if(rokprzestepny && miesiacA<2)sumadni=sumadni+1;
    					wypisanie(sumadni);
    					break;
	    			}
	    		}
	    	case 4:
	    		int liczbaA,liczbaB,wynikAB;
	    		System.out.println("Prosze podac liczbe A=");
	    		liczbaA=scan.nextInt();
	    		System.out.println("Prosze podac liczbê B=");
	    		liczbaB=scan.nextInt();
	    		wynikAB=liczbaA &liczbaB;
	    		System.out.println("operacja A&B="+ wynikAB);
	    		if(true && true)System.out.println("operacja && sluzy np do if laczy warunki w jeden itd");
	    		break;    		
	    	case 5:
	    		int liczba;
	    		System.out.println("prosze podac liczbe=");
	    		liczba=scan.nextInt();
	    		System.out.println("liczba & liczba="+ (liczba & liczba));
	    		System.out.println("liczba >> 1"+(liczba >>1));
	    		System.out.println("ta operacja spowodowala przesuniecie sie bitow w prawo wiec zamiast np 10 w systemie 10 (1010 stalo sie 101(czyli 5 w 10)");
	    		System.out.println("liczba << 1"+(liczba <<1));
	    		System.out.println("ta operacja spowodowala przesuniecie sie bitow w lewo wiec zamiast np 10 w systemie 10 (1010 stalo sie 10100(czyli 40 w 10)");
	    		break;
	    	case 6:
	    		int aa;
	    		System.out.println("prosze podac liczbe do zmiany trzeciego bitu");
	    		aa=scan.nextInt();
	    		aa=aa ^ 4;
	    		System.out.println("wynik="+aa);
	    		break;
		    default:
		    	System.out.println("Prosze wpisac ponownie liczbe");
		    	break;
		    }
		}
	}
}
