package poczatek;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Collections;
public class lista5 
{
	
	public static List<Date> wstawianie(List<Date> daty,Date nowy)
	{
		int dlugosc=daty.size(),miejsce,j=0;
		for(int i=0;i<dlugosc;i++) 
		{
			if(daty.get(i)==nowy) {
				System.out.println("blad taka sama data");
				return daty;
			}
			if(nowy.before(daty.get(i))) 
			{
				Date[] pomoc=new Date[dlugosc+1];
				miejsce=i;
				for(i=0;i<(dlugosc-miejsce);i++,j++) 
				{
					pomoc[i]=daty.get(miejsce+i);
				}
				daty.add(miejsce, nowy);
				miejsce++;
				for(i=0;i<j;i++,miejsce++) 
				{
					daty.set(miejsce, pomoc[i]);
				}
				return daty;
			}
		}
		daty.add(nowy);
		return daty;
	}
	
	public static void main(String[] args) throws ParseException
	{
		int program;
		Scanner scan=new Scanner(System.in);
		while(1>0) 
		{
		     System.out.println("Prosze wybrac funkcje listy 5:");
             System.out.println("0.Zakonczenie programu");
             System.out.println("1.Tablica n zapelniona mnozeniem");
             System.out.println("2.lista dat 4 elementowa");
             program=scan.nextInt();
             switch(program) 
             {
             case 0: 
            	 scan.close(); 
            	 return;
             case 1:
            	 int n,max=0,pomoc,ilosc;
            	 System.out.println("Prosze podac jaki ma byc rozmiar tablicy");
            	 n=scan.nextInt();
            	 int[][] tab = new int[n][n];
            	 for(int i=0;i<n;i++) 
            	 {
            		 for(int j=0;j<n;j++) 
            		 {
            			tab[i][j]=(i+1)*(j+1); 
            		 }
            	 }
            	 pomoc=tab[n-1][n-1];
            	 while(pomoc>10) 
            	 {
            		 pomoc=pomoc/10;
            		 max=max+1;
            	 }
            	 System.out.println(max);
            	 for(int i=0;i<n;i++) 
            	 {
            		 for(int j=0;j<n;j++) 
            		 {
            			System.out.print(tab[i][j]);
            			pomoc=tab[i][j];
            			ilosc=max;
            			while(pomoc>=10) 
            			{
            				pomoc=pomoc/10;
                   		    ilosc=ilosc-1;
            			}
            			for(int k=0;k<=ilosc;k++) 
               		    {
               		      System.out.print(" ");
               		    }
            		 }
            		 System.out.println();
            	 }
            	 break;
             case 2:
            	 int zad,usuniecie;
            	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            	 String input;
            	 List<Date> daty  = new ArrayList<Date>();
            	 scan.nextLine();
            	 Date data;
            	 while(true) 
            	 {
            		 System.out.println("0.Zakonczenie");
                     System.out.println("1.Wprowadzenie daty");
                     System.out.println("2.Usuniecie daty");
                     System.out.println("3.pokaz cala liste dat");
                     zad=scan.nextInt();
            		 switch(zad) 
            		 {
            		 case 0:
            			 scan.close(); 
            			 return;
            		 case 1:
            			 scan.nextLine();
            		     System.out.println("Prosze podac date");
                	     input=scan.nextLine();
                	     data=simpleDateFormat.parse(input);
                         if(daty.size()==0)daty.add(data);
                         else if(daty.size()==4) 
                         {
                        	 System.out.println("Przekroczyles limit czterech dat");
                        	 break;
                         }
                         else wstawianie(daty,data);
                         break;
                         //Collections.sort(daty);
            		 case 2:
            			 if(daty.size()!=0) 
            			 {
            				 System.out.println("prosze podac ktora date usunac(podac numer z listy)");
            				 usuniecie=scan.nextInt();
            				 if(usuniecie>daty.size() || usuniecie<0) 
            				 {
            					 System.out.println("nie wlasciwa liczba");
            					 break;
            				 }
            				 daty.remove(usuniecie);
            			 }
            			 else System.out.println("brak dat na liscie");
            			 break;
            		 case 3:
            			 if(daty.size()!=0)System.out.println("lista dat:"+daty);
            			 else System.out.println("pusta lista");
            			 break;
            		 default: 
                         System.out.println("Prosze wpisac ponownie liczbe");  
                         break;
            		 }
            	 }
             default: 
                 System.out.println("Prosze wpisac ponownie liczbe");  
                 break;
             }
		}
	}
}
