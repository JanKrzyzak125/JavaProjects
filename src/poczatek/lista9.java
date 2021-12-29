package poczatek;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.List;
import java.util.*;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class lista9 {

	public static Scanner scan=new Scanner(System.in);
	
	private static long start;
	private static long stop;
	private static long czas1=0;
	private static long czas2=0;
	
	private static int program,n,ilosc;
	private static int tempRocznik;
	private static int tempSrednia;
	private static int dzien,miesiac,rok;
	
	private static Random rand = new Random();
	
	private static String tempNazwisko;
	
	private static Student tab[];

	public static void main(String[] args) throws ParseException
	{
		while(1>0) 
		{
		    System.out.println("Lista 9");
	    	System.out.println("0.Zakonczenie programu");
		    System.out.println("1.Zadanie1");
		    System.out.println("2.Zadanie2");
	    	program=scan.nextInt();
		    switch(program) 
		    {
		    case 0:
		     	scan.close();
		    	return;
		    case 1:
		    	System.out.println("Prosze podac maksymalna ilosc studentow");
		    	n=scan.nextInt();
		    	if(n<0) 
		    	{
		    		n=n*(-1);
		    		System.out.println("Poprawiono bo podano ujemne teraz wynosi="+n);
		    	}
		    	if(n==0) 
		    	{
		    		System.out.println("zla liczba");
		    		break;
		    	}
		    	tab=new Student[n];
		    	System.out.println("Prosze podac ile chcesz wspisac studentow");
		    	ilosc=scan.nextInt();
		    	if(n<ilosc) 
		    	{
		    		System.out.println("za duzo studentow na limit");
		    		break;
		    	}
		    	for(int i=0;i<ilosc;i++) 
		    	{
		    		System.out.println("Prosze podac rocznik studenta");
		    		tempRocznik=scan.nextInt();
		    		scan.nextLine();
		    		System.out.println("Prosze podac nazwisko studenta");
		    		tempNazwisko=scan.nextLine();
		    		System.out.println("Prosze podac srednia studenta");
		    		tempSrednia=scan.nextInt();
		    		if(tempSrednia<0) 
		    		{
		    			tempSrednia=tempSrednia*(-1);
		    		}
		    		tab[i]=new Student(tempRocznik,tempNazwisko,tempSrednia);
		    	}
		    	List<Student> listaStudentow=Arrays.asList(tab);
		    	Collections.sort(listaStudentow,Comparator.comparing(Student::getRocznik).thenComparing(Student::getSrednia).thenComparing(Student::getNazwisko));
		    	for (Student st: tab)
		    	{
		    		System.out.println(st);
		    	}
		    	System.out.println(listaStudentow);
		    	break;
		    case 2:
            	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            	 SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
            	 String input;
            	 List<Date> daty  = new ArrayList<Date>();
            	 Map<Date,Integer> daty2 = new TreeMap<>();
            	 Set<Entry<Date,Integer>> entrySet;
            	 Date data;
            	 System.out.println("Prosze podac ile ma wylosowac dat");
            	 n=scan.nextInt();
            	 for(int i=0;i<n;i++) 
            	 {
            		 dzien=rand.nextInt(31);
            		 miesiac=rand.nextInt(12);
            		 rok=rand.nextInt(3000);
                	 input=dzien+"."+miesiac+"."+rok;
                	 data=simpleDateFormat.parse(input);
                	 start=System.currentTimeMillis();
                     daty.add(data);
                     Collections.sort(daty);
                     stop=System.currentTimeMillis();
                     czas1=czas1+(stop-start);
                     stop=0;  start=0;
                     start=System.currentTimeMillis();
                     input=rok+"."+miesiac+"."+dzien;
                     data=simpleDateFormat2.parse(input);
                     daty2.put(data,i);                  		
                     entrySet = daty2.entrySet();
                     stop=System.currentTimeMillis();
                     for(Entry<Date,Integer> entry: entrySet) 
                     {
                    	 if(i==n-1)System.out.println(entry.getKey() + " : " + entry.getValue());
                     }
                     czas2=czas2+(stop-start);
                     stop=0;  start=0;       
            		 }
            	 if(daty.size()!=0)System.out.println("lista dat:"+daty);
            	 System.out.println("Czas uzycia kolecji java.util.List wynosi="+czas1+" Czas uzycia kolecji java.util.Map wynosi="+czas2);
		    default:
		    	System.out.println("Prosze wpisac ponownie liczbe");  
		    	break;
		    }
		}

	}

}
