package poczatek;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class zadania3i4 extends JFrame implements ActionListener, FocusListener{

	//informuje ze tutaj sa zawarte zadania z listy 7 zadanie 4 i z listy 8 zadanie 3
	private boolean plec;
	
	private char[] sprawdzenieNazwy; 
	
	private int dlugosc=6;
	private int rozmiar;
	private int temp;
	private int miejsce;
	
	private JFrame frame;
	
	private JTextField nick;
	private JTextField imie;
	private JTextField nazwisko;
	private JTextField email;
	private JTextField PESEL;
	
	private String tempNick;
	private String tempImie;
	private String tempNazwisko;
	private String tempEmail;
	private String tempPesel;
	private String prawidlowymail="@gra.pl";
	
	public void sprawdzEmail(String nazwa) throws WyjatekEmail
	{
		int k=0;//w tym przypadku liczy @
		rozmiar=nazwa.length();
		sprawdzenieNazwy=nazwa.toCharArray();
		for(int i=0;i<rozmiar;i++) 
		{
			if(sprawdzenieNazwy[i]=='@') 
			{
				k++;
				miejsce=i+1;
			}
		}
		if(k<1 || k>2)throw new WyjatekEmail(nazwa);
		else 
		{
			   if(sprawdzenieNazwy[miejsce]=='g') 
			   {
				   miejsce++;
				   if(sprawdzenieNazwy[miejsce]=='r')miejsce++;
				   else throw new WyjatekEmail(nazwa);
					   if(sprawdzenieNazwy[miejsce]=='a')miejsce++;
					   else throw new WyjatekEmail(nazwa);
						   if(sprawdzenieNazwy[miejsce]=='.')miejsce++;
						   else throw new WyjatekEmail(nazwa);
							   if(sprawdzenieNazwy[miejsce]=='p')miejsce++;
							   else throw new WyjatekEmail(nazwa);
								   if(sprawdzenieNazwy[miejsce]=='l')return;
								   else throw new WyjatekEmail(nazwa);
			   }
			   else throw new WyjatekEmail(nazwa);
		}
	}
	
	public void sprawdzNick(String nazwa) throws WyjatekNick
	{
		int pomoc=0;
	    rozmiar=nazwa.length();
		if(rozmiar<6)throw new WyjatekNick(nazwa,"ma za malo znakow");
		sprawdzenieNazwy=nazwa.toCharArray();
		for(int i=0;i<rozmiar;i++) 
		{
			for(int k=48;k<58;k++) 
			{
			    if(sprawdzenieNazwy[i]==k)pomoc=pomoc+1;
			}
		}
		if(pomoc==0)throw new WyjatekNick(nazwa,"brak liczby");
	}
	
	public void sprawdzlitery(String nazwa) throws WyjatekLitery 
	{
		int pomoc=1;
		rozmiar=nazwa.length();
		sprawdzenieNazwy=nazwa.toCharArray();
		if(sprawdzenieNazwy[0]>123 || sprawdzenieNazwy[0]<65)throw new WyjatekLitery(nazwa);
		else if(sprawdzenieNazwy[0]>90 && sprawdzenieNazwy[0]<96)throw new WyjatekLitery(nazwa); 
		else
		for(int i=1;i<rozmiar;i++) 
		{
			for(int k=97;k<123;k++) 
			{
				if((int)sprawdzenieNazwy[i]==k)pomoc++;
			}
		}
		if(rozmiar==pomoc)return;
		else throw new WyjatekLitery(nazwa);
	}
	
	public void sprawdzDuzalitera(String nazwa,int co) throws WyjatekDuzelitery 
	{
		if(Character.isUpperCase(nazwa.charAt(0)))return;
		else throw new WyjatekDuzelitery(nazwa,co);
	}
	
	public void sprawdzplec(String nazwa)throws WyjatekPlec //false to kobieta true to mezczyzna  
	{ 
		int warunek1,warunek2;
		rozmiar=nazwa.length();
		warunek1=nazwa.lastIndexOf("e");
		warunek2=nazwa.lastIndexOf("k");
		if((warunek1==rozmiar-2 && warunek2==rozmiar-1) && plec==true) 
		{
			return;
		}
		temp=nazwa.lastIndexOf("u");
		warunek1=nazwa.lastIndexOf("s");
		warunek2=nazwa.lastIndexOf("z");
		if((temp==rozmiar-3 && warunek1==rozmiar-2 && warunek2==rozmiar-1) && plec==true)return;
		warunek1=nazwa.lastIndexOf("n");
		warunek2=nazwa.lastIndexOf("a");
		if((warunek1==rozmiar-2 && warunek2==rozmiar-1) && plec==false) 
		{
			return;
		}
		warunek1=nazwa.lastIndexOf("t");
		warunek2=nazwa.lastIndexOf("a");
		if((warunek1==rozmiar-2 && warunek2==rozmiar-1) && plec==false) 
		{
			return;
		}
		else throw new WyjatekPlec(nazwa);
	}
	public int miesiace(char jeden,char dwa) 
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
	
	public String dane(String pesel) 
	{
		String pomoc;
		rozmiar=pesel.length();
		String[] plec= {"kobieta","mezczyzna"};
		char[] tab=pesel.toCharArray();
		int temp;
		String miesiace[]= {"blednymiesiac","styczniu","lutym","marcu","kwietniu","maju","czerwiecu","lipcu","sierpieniu","wrzesniu","pazdzierniku","listopadzie","grudniu"};
		temp=tab[9];
		temp=temp-48;
		pomoc="urodziles sie "+tab[4]+tab[5]+" "+miesiace[miesiace(tab[2],tab[3])]+" "+"1"+"9"+tab[0]+tab[1]+" Plec:"+plec[temp%2];
		PESEL.setText(pomoc);
		return(pomoc);
	}
	
	
	public String getMessage() 
	{	
		return ("Nazywasz sie:"+tempImie+" "+tempNazwisko);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zadania3i4 window = new zadania3i4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public zadania3i4() {
		initialize();
		frame.setResizable(false);
		nick.createToolTip();
		nick.setToolTipText("Prosze podac nick");
		imie.createToolTip();
		imie.setToolTipText("Prosze podac imie");
		nazwisko.createToolTip();
		nazwisko.setToolTipText("Prosze podac nazwisko");
		email.createToolTip();
		email.setToolTipText("Prosze podac email");
		PESEL.createToolTip();
		PESEL.setToolTipText("Prosze podac pesel (w nim jest data urodzenia i plec)");
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Rejestracja");
		frame.setBounds(100, 100, 235, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nick = new JTextField();
		nick.setToolTipText("Prosze podac nick");
		nick.setColumns(10);
		nick.setBounds(10, 32, 197, 20);
		frame.getContentPane().add(nick);
		
		imie = new JTextField();
		imie.setToolTipText("Prosze podac nick");
		imie.setColumns(10);
		imie.setBounds(10, 61, 197, 20);
		frame.getContentPane().add(imie);
		
		nazwisko = new JTextField();
		nazwisko.setToolTipText("Prosze podac nick");
		nazwisko.setColumns(10);
		nazwisko.setBounds(10, 92, 197, 20);
		frame.getContentPane().add(nazwisko);
		
		email = new JTextField();
		email.setToolTipText("Prosze podac nick");
		email.setColumns(10);
		email.setBounds(10, 123, 197, 20);
		frame.getContentPane().add(email);
		
		PESEL = new JTextField();
		PESEL.setToolTipText("Prosze podac nick");
		PESEL.setColumns(10);
		PESEL.setBounds(10, 154, 197, 20);
		frame.getContentPane().add(PESEL);
		
		JRadioButton radioButton = new JRadioButton("Mezczyzna");
		radioButton.setSelected(true);
		radioButton.setBounds(10, 181, 88, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Kobieta");
		radioButton_1.setBounds(130, 181, 77, 23);
		frame.getContentPane().add(radioButton_1);
		
		JButton button = new JButton("Rejestracja");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                tempNick=nick.getText();
                try 
                {
                sprawdzNick(tempNick);
                nick.setBackground(Color.green);
                }
				catch(WyjatekNick e) 
                {
					nick.setBackground(Color.red);
					System.err.println(e.getMessage());
				}
                System.out.println("Nick:"+tempNick);
				tempImie=imie.getText();
				tempImie=tempImie.trim();
				tempNazwisko=nazwisko.getText();
				tempNazwisko=tempNazwisko.trim();
				if(radioButton.isSelected()==true)plec=true;
				else if(radioButton_1.isSelected()==true) plec=false;
				try 
				{
					sprawdzDuzalitera(tempImie,0);
					imie.setBackground(Color.green);
				}
				catch(WyjatekDuzelitery e) 
				{ 
					System.out.println(e.getMessage());
					imie.setText(e.getMessage());
					imie.setBackground(Color.green);
				}
				try 
				{	
					sprawdzDuzalitera(tempNazwisko,1);
					nazwisko.setBackground(Color.red);
				}
				catch(WyjatekDuzelitery e) 
				{ 
					System.out.println(e.getMessage()); 
					nazwisko.setText(e.getMessage());
					nazwisko.setBackground(Color.green);
				}
				try 
				{ 
					sprawdzplec(tempImie);
				}
				catch(WyjatekPlec e) 
				{ 
					System.err.println(e.getMessage());
				}
				try 
				{
					sprawdzlitery(tempImie);
					imie.setBackground(Color.green);
				}
				catch(WyjatekLitery e) 
				{
					System.err.println(e.getMessage());
					imie.setBackground(Color.red);
				}
				try 
				{
					sprawdzlitery(tempNazwisko);
					nazwisko.setBackground(Color.green);
				}
				catch(WyjatekLitery e) 
				{
					System.err.println(e.getMessage());
					nazwisko.setBackground(Color.red);
				}
				tempPesel=PESEL.getText();
				tempPesel=tempPesel.trim();
				if((tempPesel.length())==11)
					System.out.println(getMessage()+dane(tempPesel));
				else 
					System.out.println(getMessage()+"bledny pesel");
				tempEmail=email.getText();
				tempEmail=tempEmail.trim();
				try 
				{
					sprawdzEmail(tempEmail);
					email.setBackground(Color.green);
				}
				catch(WyjatekEmail e) 
				{
					System.err.println(e.getMessage());
					email.setBackground(Color.red);
				}
			}
		});
		button.setBounds(45, 211, 128, 23);
		frame.getContentPane().add(button);
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
