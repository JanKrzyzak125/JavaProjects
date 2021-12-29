package lista6;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Collections;


public class test {

	public static void main(String[] args)  throws ParseException
	{
		Scanner scan=new Scanner(System.in);
		delfin animal1=new delfin("tomcio",10,1);
		pies animaldog=new pies("szyneczka",15,true);
		Chihuahuan animalrasa1=new Chihuahuan();
		Husky animalrasa2=new Husky();
		kolordelfina animalkolorek=new kolordelfina();
		System.out.println("metoda w zwierze"+" zyje="+animal1.zyje());
		System.out.println("klasa delfin="+animal1.dajGlos()+" "+"klasa pies="+animaldog.dajGlos());
		System.out.println("wiek psa="+(animaldog.getWiek()+" wiek delfina="+(animal1.getWiek())));
		System.out.println("napisanie metody klasy object "+animaldog.toString());
		if(animaldog.rasa()==false) 
		{
			animalrasa1.nazwa();
			System.out.println("nazwa rasy="+animalrasa1.nazwarasy());
		}
		else 
		{
			animalrasa2.nazwa();
			System.out.println("nazwa rasy="+animalrasa2.nazwarasy());
		}
		System.out.println("Kolor delfina="+animalkolorek.jakiKolor());
        scan.close();
        return;
	}

}
