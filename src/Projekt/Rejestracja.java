package Projekt;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Rejestracja implements ActionListener, FocusListener{

	private boolean zmiana=false;
	private int idClient;
	private int zrobione=0;
	private char[] sprawdzenieNazwy;
	
	private int iloscbledow=0;
	private int rozmiar;
	private int temp;
	private int miejsce;
	
	protected Apka window;
	public JFrame frame;
	private JTextField imie;
	private JTextField nazwisko;
	private JTextField email;
	private JTextField PESEL;
	private JTextField adres;
	private JTextField miasto;
	
	private String tempAdres;
	private String tempImie;
	private String tempNazwisko;
	private String tempEmail;
	private String tempPesel;
	private String tempMiasto;
	
	public void setWindow(Apka apka) 
	{
		window=apka.window;
	}
	
    public void Rejestracja2(Klient user) 
    {
    	this.idClient=user.getIdKlient();
    	String[] tab=user.getImieNazwisko().split(" ");
    	this.imie.setText(tab[0]);
    	this.nazwisko.setText(tab[1]);
    	this.email.setText(user.getEmail());
    	this.PESEL.setText(user.getPesel());
    	this.miasto.setText(user.getMiasto());
    	this.adres.setText(user.getAdres());
    	this.zmiana=true;
    }
	
	
	public void sprawdzEmail(String nazwa) throws WyjatekEmail
	{
		int k=0;
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
		String miesiace[]= {"blednymiesiac","styczeñ","luty","marzec","kwiecien","maj","czerwiec","lipiec","sierpien","wrzesien","pazdziernik","listopad","grudnien"};
		temp=tab[9];
		temp=temp-48;
		pomoc=""+tab[4]+tab[5]+" "+miesiace[miesiace(tab[2],tab[3])]+" "+"1"+"9"+tab[0]+tab[1];
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
					Rejestracja window = new Rejestracja();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Rejestracja() throws InterruptedException{
		initialize();
		
		frame.setResizable(false);
		imie.createToolTip();
		imie.setToolTipText("Prosze podac imie");
		nazwisko.createToolTip();
		nazwisko.setToolTipText("Prosze podac nazwisko");
		email.createToolTip();
		email.setToolTipText("Prosze podac email");
		PESEL.createToolTip();
		PESEL.setToolTipText("Prosze podac pesel (w nim jest data urodzenia i plec)");
		
		adres = new JTextField();
		adres.setToolTipText("Prosze podac Adres");
		adres.setColumns(10);
		adres.setBounds(10, 73, 197, 20);
		frame.getContentPane().add(adres);
		
		miasto = new JTextField();
		miasto.setToolTipText("Prosze podac Miasto");
		miasto.setColumns(10);
		miasto.setBounds(10, 104, 197, 20);
		frame.getContentPane().add(miasto);
	}

	private void initialize() throws InterruptedException{
		frame = new JFrame();
		frame.setTitle("Rejestracja");
		frame.setBounds(100, 100, 235, 270);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		imie = new JTextField();
		imie.setToolTipText("Prosze podac Imie");
		imie.setColumns(10);
		imie.setBounds(10, 11, 197, 20);
		frame.getContentPane().add(imie);
		
		nazwisko = new JTextField();
		nazwisko.setToolTipText("Prosze podac Nazwisko");
		nazwisko.setColumns(10);
		nazwisko.setBounds(10, 42, 197, 20);
		frame.getContentPane().add(nazwisko);
		
		email = new JTextField();
		email.setToolTipText("Prosze podac Email");
		email.setColumns(10);
		email.setBounds(10, 135, 197, 20);
		frame.getContentPane().add(email);
		
		PESEL = new JTextField();
		PESEL.setToolTipText("Prosze podac Pesel");
		PESEL.setColumns(10);
		PESEL.setBounds(10, 166, 197, 20);
		frame.getContentPane().add(PESEL);
		
		JButton button = new JButton("Rejestracja");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tempImie=imie.getText();
				tempImie=tempImie.trim();
				tempNazwisko=nazwisko.getText();
				tempNazwisko=tempNazwisko.trim();
				try 
				{
					sprawdzDuzalitera(tempImie,0);
					imie.setBackground(Color.green);
				}
				catch(WyjatekDuzelitery e){}
				try 
				{	
					sprawdzDuzalitera(tempNazwisko,1);
					nazwisko.setBackground(Color.green);
				}
				catch(WyjatekDuzelitery e){}
				
				try 
				{
					sprawdzlitery(tempImie);
					imie.setBackground(Color.green);
				}
				catch(WyjatekLitery e) 
				{
					iloscbledow++;
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
					iloscbledow++;
					System.err.println(e.getMessage());
					nazwisko.setBackground(Color.red);
				}
				tempPesel=PESEL.getText();
				tempPesel=tempPesel.trim();
				if((tempPesel.length())==11) 
				{
					PESEL.setBackground(Color.green);
				}
				else 
				{
					PESEL.setBackground(Color.red);
					iloscbledow++;
				}
				tempEmail=email.getText();
				tempEmail=tempEmail.trim();
				try 
				{
					sprawdzEmail(tempEmail);
					email.setBackground(Color.green);
				}
				catch(WyjatekEmail e) 
				{
					iloscbledow++;
					System.err.println(e.getMessage());
					email.setBackground(Color.red);
				}
				tempAdres=adres.getText();
				tempMiasto=miasto.getText();
				try 
				{
					sprawdzDuzalitera(tempAdres,0);
					adres.setBackground(Color.green);
				}
				catch(WyjatekDuzelitery e)
				{
					adres.setBackground(Color.green);
				}
				try 
				{
					sprawdzDuzalitera(tempMiasto,0);
					miasto.setBackground(Color.green);
				}
				catch(WyjatekDuzelitery e)
				{
					miasto.setBackground(Color.green);
				}
				if(iloscbledow!=0) 
				{
					System.err.println("Nie mozna utworzyc konta zbyt duzo bledow");
					iloscbledow=0;
				}
		        else 
		        {
		        	iloscbledow=0;
		        	if(zmiana==true) 
		        	{
		        		window.tempKlient=new Klient(idClient,tempImie+" "+tempNazwisko,tempAdres,tempMiasto,tempEmail,tempPesel);
		        		window.tabKlient.set(window.index,window.tempKlient);
		        		window.aktualizacja(idClient);
		        		zmiana=false;
		        	}
		        	else 
		        	{
		        		int k=0,numer=-1;
		        		int []tab;
		        		rozmiar=window.tabKlient.size();
		        		tab=new int[window.kolejne];
		        		for(int i=0;i<window.kolejne;i++) 
		        		{
		        			if(window.tabPKlient[i][0]==null) 
		        			{
		        			     tab[k]=i;
		        			     k++;
		        			};
		        			
		        		}
		        		window.tabKlient.add(new Klient(window.kolejne,tempImie+" "+tempNazwisko,tempAdres,tempMiasto,tempEmail,tempPesel));
		        		if(numer==-1)window.aktualizacja(window.numerKolejnosci);
		        		else window.aktualizacja(tab[0]);
			        	window.numerKolejnosci++;
			        	window.kolejne++;
		        	}
		        }
					
			}
		});
		button.setBounds(10, 207, 197, 23);
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
