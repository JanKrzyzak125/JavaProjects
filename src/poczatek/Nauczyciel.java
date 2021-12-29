package poczatek;
import java.util.Scanner;
public class Nauczyciel 
{
	public static String Ocenianie(int ocena) 
	{
		if(ocena>90) return "bdb";
		else if(ocena>80) return "+db";
		else if(ocena>70) return "db";
		else if(ocena>60) return "+dst";
		else if(ocena>50) return "dst";
		else return "ndst";
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int program=0;
        String Uimie;
        int Uocena;
		String Ukolor;
	   	int Urok;
		System.out.println("Prosze wpisac imie pierwszego ucznia");
		Uimie=scan.nextLine();
	    System.out.println("Prosze wpisac ocene pierwszego ucznia");
		Uocena=scan.nextInt();
	    scan.nextLine();System.out.println("Prosze wpisac kolor pierwszego ucznia");
		Ukolor=scan.nextLine();
	    System.out.println("Prosze wpisac rok pierwszego ucznia");
		Urok=scan.nextInt();
		Uczen uczen1 = new Uczen(Uimie,Uocena,Ukolor,Urok);
		scan.nextLine();
		System.out.println("Prosze wpisac imie drugiego ucznia");
		Uimie=scan.nextLine();
	    System.out.println("Prosze wpisac ocene drugiego ucznia");
		Uocena=scan.nextInt();
	    scan.nextLine();System.out.println("Prosze wpisac kolor drugiego ucznia");
		Ukolor=scan.nextLine();
	    System.out.println("Prosze wpisac rok drugiego ucznia");
		Urok=scan.nextInt();
	    Uczen uczen2 = new Uczen(Uimie,Uocena,Ukolor,Urok);
	    scan.nextLine();
		while(1>0) 
		{
			System.out.println("Prosze wybrac funkcje:");
			System.out.println("0.Zakonczenie programu");//+
			System.out.println("1.Wyswietlanie imion");//+
			System.out.println("2.Wyswietlanie ocen");//+
			System.out.println("3.Wyswietlanie ulubionego koloru");//+
			System.out.println("4.wyswietlanie roku rozpoczecia kursu");//+
			System.out.println("5.Wyswietlanie numeru kursu");//+
			System.out.println("6.Zmiana oceny 1 ucznia");//+
			System.out.println("7.Zmiana oceny 2 ucznia");//+
			System.out.println("8.Zmiana ulubionego koloru 1 ucznia");//+
			System.out.println("9.Zmiana ulubionego koloru 2 ucznia");//+
			System.out.println("10.Zmiana roku kursu");//+
			System.out.println("11.Zmiana Wpisz numer kursu");//++
			program=scan.nextInt();
		   switch(program) 
		   {
		   case 0:
			   scan.close();
			   return;
		   case 1:
		      System.out.println("Pierwszy uczen "+uczen1.getImie());
		      System.out.println("Drugi uczen "+uczen2.getImie());
		      break;
		   case 2:
			   System.out.println("Pierwszy uczen "+(Ocenianie(uczen1.getOcena())));
			   System.out.println("Drugi uczen "+(Ocenianie(uczen2.getOcena())));
			   break;
		   case 3:
			   System.out.println("Pierwszy uczen "+uczen1.getKolor());
		       scan.nextLine();
		       System.out.println("Drugi uczen "+uczen2.getKolor());
		       break;
		   case 4:   
		      System.out.println("Pierwszy uczen "+uczen1.getRok());
		      System.out.println("Drugi uczen "+uczen2.getRok());
		      break;
		   case 5:
	          System.out.println("Pierwszy uczen "+uczen1.numerKursu);
		      System.out.println("Drugi uczen "+uczen2.numerKursu);
		      break;
		   case 6:
			   System.out.println("Prosze wpisac ocene pierwszego ucznia");
		       uczen1.setOcena(scan.nextInt());
			   break;
		   case 7:
			   System.out.println("Prosze wpisac ocene drugiego ucznia");
		       uczen1.setOcena(scan.nextInt());
			   break;
		   case 8:
			   System.out.println("Prosze wpisac kolor pierwszego ucznia");
		       uczen1.setKolor(scan.nextLine());
			   break;
		   case 9:
		       System.out.println("Prosze wpisac kolor drugiego ucznia");
		       uczen2.setKolor(scan.nextLine());
			   break;
		   case 10:
			   System.out.println("Prosze wpisac rok pierwszego ucznia");
			   uczen1.setRok(scan.nextInt());
			   break;
		   case 11:
			   System.out.println("Prosze wpisac rok drugiego ucznia");
			   uczen2.setRok(scan.nextInt());
			   break;
		   case 12:
			   System.out.println("Prosze wpisac numer kursu(jesli numer sie zmienil)");
			   uczen1.numerKursu=scan.nextInt();
			   break;
		    default:
		    	System.out.println("Prosze wpisac ponownie liczbe");
		      break;
		   }
		}
	}
}
