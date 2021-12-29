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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class lista7_8 extends JFrame implements ActionListener, FocusListener
{
 
	public String wynik="";
	private int maksymalna=10;
	private int maksymalnyWynik=100;
	private boolean pierwszy=true;
    
	private char[] tabwynik=new char[maksymalnyWynik];//maksymalny wynik 
    private char[] znak=new char[maksymalna];
    private JFrame frame;
	private JTextField txtLiczenie;
    
	private int wielkosc=0;
	private int miejsce=0;
	private int temp;
	private int temp2;	
	private int[] kolejnosc=new int[maksymalna];
	private int aktualnynumer=0;
    private int[] liczby=new int [maksymalna];

	
	public void actionPerformed(ActionEvent e) 
	{
		txtLiczenie.setText(wynik);
	}

	public void usuwanie() 
	{
		for(int i=aktualnynumer;i>=0;i--) 
		{
			 liczby[i]=0;
			 znak[i]=' ';
			 kolejnosc[i]=-1;
		}
		aktualnynumer=0;
		pierwszy=true;
	}
	
	public void wprowadzenieCyfry(int cyfra) 
	{
		if(pierwszy==true) 
		{
			liczby[aktualnynumer]=cyfra;
			pierwszy=false;
		}
		else liczby[aktualnynumer]=(liczby[aktualnynumer]*10)+cyfra;
	}
	
	public void wprowadzenieDzialania(char dzialanie) 
	{
		znak[aktualnynumer]=dzialanie;
		if(pierwszy==true) {
			System.out.println("za duzo znakow dzialania");
			return;
		}
		switch(znak[aktualnynumer]) 
		{
		case '/':
			kolejnosc[aktualnynumer]=0; //najwyzszy piorytet
			break;
		case '*':
			kolejnosc[aktualnynumer]=1;
			break;
		case '-':
			kolejnosc[aktualnynumer]=2;
			break;
		case '+':
			kolejnosc[aktualnynumer]=3; //najmniejszy piorytet
			break;
		}
		aktualnynumer++;
		pierwszy=true;
	}
	
	public void naprawienie(int ktora) 
	{
		for(int i=ktora;i<aktualnynumer;i++) 
		{
			liczby[i+1]=liczby[i+2];
			znak[i]=znak[i+1];
			kolejnosc[i]=kolejnosc[i+1];
		}
	}
	
	public void liczenie(int dzialanie,int ktora) 
	{
		
	    switch(dzialanie) 
	    {
	    case 0: // /
	    	System.out.println("ta dam");
	    	liczby[ktora]=liczby[ktora]/liczby[ktora+1];
	    	System.out.println("ta dam");
	    	break;
	    case 1: // *
	    	System.out.println("ta dam2");
	    	liczby[ktora]=liczby[ktora]*liczby[ktora+1];
	    	System.out.println("ta dam2");
	    	break;
	    case 2: // -
	    	System.out.println("ta dam3");
	    	liczby[ktora]=liczby[ktora]-liczby[ktora+1];
	    	System.out.println("ta dam3");
	    	break;
	    case 3: //+
	    	System.out.println("ta dam4");
	    	liczby[ktora]=liczby[ktora]+liczby[ktora+1];
	    	System.out.println("ta dam4");
	    	break;
	    }		
	    naprawienie(ktora);	
	}
	public void zmianaNaChar(int miejsce,int cyfra) 
	{
		switch(cyfra) 
		{
		case 0:
			tabwynik[miejsce]='0';
			break;
		case 1:
			tabwynik[miejsce]='1';
			break;
		case 2:
			tabwynik[miejsce]='2';
			break;
		case 3:
			tabwynik[miejsce]='3';
			break;
		case 4:
			tabwynik[miejsce]='4';
			break;
		case 5:
			tabwynik[miejsce]='5';
			break;
		case 6:
			tabwynik[miejsce]='6';
			break;
		case 7:
			tabwynik[miejsce]='7';
			break;
		case 8:
			tabwynik[miejsce]='8';
			break;
		case 9:
			tabwynik[miejsce]='9';
			break;
		}
	}
	
	public void liczenieWyniku() 
	{
		for(int i=0;i<4;i++) //liczba cztery wziela sie z piorytetu idziemy robic wpierw / pozniej * - i na koniec +
		{
			for(int k=0;k<aktualnynumer;k++) 
			{
				if(kolejnosc[k]==i)liczenie(i,k);
			}
		}
		System.out.println(liczby[0]);
		temp=liczby[0];
		while(temp>9) 
		{
			temp=temp/10;
			wielkosc++; //jaka wielkosc jest liczby maksymalnie
		}
		miejsce=wielkosc;
		temp=liczby[0];
		temp2=liczby[0];
		for(int i=0;i<=wielkosc;i++) 
		{
			while(temp>9) 
			{
				temp=temp/10;
			}
			zmianaNaChar(i,temp);
			for(int k=0;k<miejsce;k++) 
			{
				temp=temp*10;
			}
			miejsce--;
			temp2=temp2-temp;
			temp=temp2;
		}
		for(int i=0;i<=wielkosc;i++) 
		{
			wynik=wynik+tabwynik[i];
		}
		txtLiczenie.setText(wynik);
		usuwanie();
	}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lista7_8 window = new lista7_8();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public lista7_8() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 242, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_4 = new JButton("7");
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(7);
		        wynik=wynik+"7";		
				txtLiczenie.setText(wynik);
			}
		});
		btnNewButton_4.setBounds(10, 85, 41, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("4");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(4);
				wynik=wynik+"4";
				txtLiczenie.setText(wynik);
			}
		});
		btnNewButton_5.setBounds(10, 119, 41, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("9");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(9);
				wynik=wynik+"9";
				txtLiczenie.setText(wynik);
			}
		});
		btnNewButton_7.setBounds(112, 85, 41, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(1);
				wynik=wynik+"1";
				txtLiczenie.setText(wynik);
			}
		});
		button.setBounds(10, 153, 41, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(8);
				wynik=wynik+"8";
				txtLiczenie.setText(wynik);
			}
		});
		button_1.setBounds(61, 85, 41, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(5);
				wynik=wynik+"5";
				txtLiczenie.setText(wynik);
			}
		});
		button_2.setBounds(61, 119, 41, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(2);
				wynik=wynik+"2";
				txtLiczenie.setText(wynik);
			}
		});
		button_3.setBounds(61, 153, 41, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(6);
				wynik=wynik+"6";
				txtLiczenie.setText(wynik);
			}
		});
		button_4.setBounds(112, 119, 41, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("3");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(3);
				wynik=wynik+"3";
				txtLiczenie.setText(wynik);
			}
		});
		button_5.setBounds(112, 153, 41, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("0");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieCyfry(0);
				wynik=wynik+"0";
				txtLiczenie.setText(wynik);
			}
		});
		button_6.setBounds(61, 190, 41, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("+");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieDzialania('+');
				wynik=wynik+" +";
				txtLiczenie.setText(wynik);
			}
		});
		button_7.setBounds(163, 85, 41, 23);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("-");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieDzialania('-');
				wynik=wynik+" -";
				txtLiczenie.setText(wynik);
			}
		});
		button_8.setBounds(163, 122, 41, 23);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("*");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieDzialania('*');
				wynik=wynik+" *";
				txtLiczenie.setText(wynik);
			}
		});
		button_9.setBounds(163, 153, 41, 23);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("=");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wynik="";
				liczenieWyniku();//do zrobienia aktualizacja wyniku
				txtLiczenie.setText(wynik);

			}
		});
		button_10.setBounds(163, 190, 41, 23);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("/");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wprowadzenieDzialania('/');
				wynik=wynik+" /";
				txtLiczenie.setText(wynik);
			}
		});
		button_11.setBounds(112, 190, 41, 23);
		frame.getContentPane().add(button_11);
		
		txtLiczenie = new JTextField();
		txtLiczenie.setText("Liczenie");
		txtLiczenie.setToolTipText("liczenie");
		txtLiczenie.setBounds(10, 27, 195, 35);
		frame.getContentPane().add(txtLiczenie);
		txtLiczenie.setColumns(10);
		
		JButton czyszczenie = new JButton("c");
		czyszczenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				usuwanie();
				wynik="";
				txtLiczenie.setText(wynik);
			}
		});
		czyszczenie.setBounds(10, 190, 41, 23);
		frame.getContentPane().add(czyszczenie);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
