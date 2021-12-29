package poczatek;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class lista10a {

	public static Scanner scan=new Scanner(System.in);
	
	private static int program;
	private static final List<String> list=new ArrayList<>();
	private static final List<String> list2=new lista10alistasych<>();
	private static class Adder1 implements Runnable
	{
		private static int counter=0;
		private final int number=++counter;
		
		
		
		@Override
		public void run() 
		{
			for(int i=0;i<10;i++) 
			{
				list.add("New string "+Math.random());
			}
			System.out.println("[Adder"+number+"]" + list.size());
		}
	}
	private static class Adder2 implements Runnable
	{
		private static int counter=0;
		private final int number=++counter;
		
		@Override
		public void run() 
		{
			for(int i=0;i<10;i++) 
			{
				list2.add("New string "+Math.random());
			}
			System.out.println("[Adder"+number+"]" + list2.size());
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Lista10 zadanie2");
		System.out.println("0.Zakonczenie programu");
		System.out.println("1.Brak sychronizacji watkow");
		System.out.println("2.Sychronizacja watkow");
		program=scan.nextInt();
		while(true) 
		{
		    switch(program) 
	    	{
	    	case 0:
	    		scan.close();
	    		return;
	    	case 1:
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	            new Thread(new Adder1()).start();
	    		break;
	    	case 2:
	    		new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	            new Thread(new Adder2()).start();
	    		break;
		    default:
		    	System.out.println("Zla liczba");
		    	break;
	    	}

		}
	}

}
