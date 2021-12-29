package poczatek;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Collections;

public class lista8 {

	public static void main(String[] args) 
	{
		System.out.println("zadanie1 z listy 8");
		String[] num= {"1","12","12f"};
		try 
		{
			int n;
			n=Integer.parseInt(num[1]);
			n=(n/0);
			n=Integer.parseInt(num[2]);
			n=Integer.parseInt(num[10]);
			System.out.println(n);
		}
		catch(NumberFormatException e) 
		{
			System.err.println("To nie jest liczba");
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.err.println("Zly indeks");
		}
		
		catch(ArithmeticException e) 
		{
			System.err.println("nie mozna dzielic przez zero");
		}
		finally 
		{
			System.out.println("Zawsze zostanie wykonane");
		}
	}
}
