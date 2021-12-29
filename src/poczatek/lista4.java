package poczatek;
import java.util.Scanner;
import java.util.*;

public class lista4 
{
	public static void main(String[] args) 
	{		
		int program;
		Scanner scan=new Scanner(System.in);
		while(1>0) 
		{
		     System.out.println("Prosze wybrac funkcje listy 4:");
             System.out.println("0.Zakonczenie programu");
             System.out.println("1.liczenie roznicy czasu miedzy strefami czasu(zad4)");
             System.out.println("Roboczegodziny.liczenie ile dni uplynelo miedzy dwiema datami(zad3 jest w klasie roboczegodziny)");
             program=scan.nextInt();
             switch(program) 
             {
             case 0: scan.close(); return;
             case 1:
            	 int dst,rawOffset;
            	 TimeZone timeZone1 = TimeZone.getTimeZone("America/Los_Angeles");
            	 TimeZone timeZone2 = TimeZone.getTimeZone("Europe /Warsaw");
            	 TimeZone timeZone3 = TimeZone.getTimeZone("Asia/Tokyo");
            	 TimeZone timeZone4 = TimeZone.getTimeZone("Australia/Sydney");
            	 dst=timeZone1.getDSTSavings();
            	 dst=dst/3600000;
            	 System.out.println("DST saving is :" + dst);
            	 rawOffset=timeZone4.getRawOffset();
            	 rawOffset=rawOffset/3600000;
            	 System.out.println("Raw Offset value:" + rawOffset);
            	 System.out.println("Roznica miedzy strefami wynosi:"+(dst+rawOffset));
            	 break;
             default: System.out.println("Prosze wpisac ponownie liczbe");  break;
             }
		}
	}
}
