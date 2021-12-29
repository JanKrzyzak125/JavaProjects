package Projekt;
import java.awt.BorderLayout;
import java.util.Scanner;
import java.awt.EventQueue;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Apka implements ActionListener, FocusListener{

	protected static Apka window;
	protected Rejestracja window2;
	protected static ArrayList <Klient> tabKlient=new ArrayList<Klient>();  
	protected int numerKolejnosci=0;
	protected int index;
	protected int kolejne=0;
	protected Klient tempKlient;


	private boolean bledny=true;
	private Calendar czas;
	
    private ArrayList<Klient> values = new ArrayList<Klient>();
    protected static Object[][] tabPKlient=new Object[100][100];
	private final String[] tabKwot={"10","20","30","40","50","60","70","80","90","100"};
	private final int[] kwota= {10,20,30,40,50,60,70,80,90,100};
	private int numerID=0;
	
	protected static TableModel tableModel;
	private JFrame frame;
	private JTextField dataDnia;
	private JTextField wyszukanieNumeru;
	private JTextField wyszukanieOsoby;
	private JTextPane daneKlienta;
	protected static JTable table;
	
	private class Adder1 implements Runnable 
	{
		Adder1()throws InterruptedException 
		{
			Thread.sleep(2000);	
		}
		@Override
		public void run() 
		{
			while(true)
			{
			    czas=Calendar.getInstance();
			    dataDnia.setText(""+czas.getTime());
			}
		}
	}

	protected void aktualizacja(int cyfra)
	{
		tabPKlient[cyfra][0]=tabKlient.get(numerKolejnosci).getIdKlient();
		tabPKlient[cyfra][1]=tabKlient.get(numerKolejnosci).getImieNazwisko();
		tableModel = new DefaultTableModel(tabPKlient, new String[] {"IDKlienta","Imie i nazwisko"});
		frame.getContentPane().remove(table);
		table = new JTable(tableModel);
		table.setBounds(39, 55, 196, 238);
		frame.getContentPane().add(table);
	}
	
	private void deponowac(int suma) 
	{
		tempKlient=tabKlient.get(index);
		tempKlient.setStanKonta(tempKlient.getStanKonta()+suma);
		tabKlient.set(index, tempKlient);
	}
	
	private void wyplacac(int suma) 
	{
		tempKlient=tabKlient.get(index);
		tempKlient.setStanKonta(tempKlient.getStanKonta()-suma);
		tabKlient.set(index, tempKlient);
	}
	
	private void wyszukiwanie() 
	{
		String wiadomosc="",imieNazwisko;
		imieNazwisko=wyszukanieOsoby.getText();
		if(tabKlient.isEmpty()==false)
		{
			for(int i=0;i<tabKlient.size();i++) 	
			{
				int temping;
				temping=tabKlient.get(i).getIdKlient();
				if(temping==numerID) 
				{
					index=tabKlient.get(i).getIdKlient();
					if(tabKlient.get(index).getImieNazwisko().equals(imieNazwisko))
					{
						wiadomosc= tabKlient.get(index).getMessage();
						bledny=false;
					}
				    else
				    {
				    	wiadomosc="zle dane";
				    	bledny=true;
				    }   
				}
			}
		}
		else  
		{
			wiadomosc="Brak klientow";
			bledny=true;
		}
		if(wiadomosc=="") 
		{
			wiadomosc="zle dane";
			bledny=true;
		}
		daneKlienta.setText(wiadomosc); 
	}
	
	private void wyszukiwaniev2() 
	{
		String wiadomosc="";
		wiadomosc= tabKlient.get(index).getMessage();
		daneKlienta.setText(wiadomosc); 
	}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					window=new Apka();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Apka() throws InterruptedException
	{
		initialize();
	}

	private void initialize() throws InterruptedException 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 742, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("JBank");
		frame.setResizable(false);
		
		JButton rejestracjaPrzycisk = new JButton("Rejestracja ");
		rejestracjaPrzycisk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					if(window2==null) 
					{
					   window2 = new Rejestracja();
					   window2.setWindow(window);
					}
					window2.frame.setVisible(true);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		});
		rejestracjaPrzycisk.setBounds(270, 371, 118, 36);
		frame.getContentPane().add(rejestracjaPrzycisk);
		
		dataDnia = new JTextField();
		dataDnia.setEditable(false);
		dataDnia.setToolTipText("Dzisiejsza data");
		dataDnia.setBounds(10, 7, 187, 37);
		frame.getContentPane().add(dataDnia);
		dataDnia.setColumns(10);
		new Thread(new Adder1()).start();
		
		daneKlienta = new JTextPane();
		daneKlienta.setEditable(false);
		daneKlienta.setToolTipText("Podstawowe dane");
		daneKlienta.setBounds(270, 58, 449, 302);
		frame.getContentPane().add(daneKlienta);
		
		wyszukanieNumeru = new JTextField();
		wyszukanieNumeru.setToolTipText("PodajID");
		wyszukanieNumeru.setBounds(294, 11, 86, 28);
		frame.getContentPane().add(wyszukanieNumeru);
		wyszukanieNumeru.setColumns(10);
		
		wyszukanieOsoby = new JTextField();
		wyszukanieOsoby.setToolTipText("Podaj imie i nazwisko");
		wyszukanieOsoby.setBounds(390, 11, 212, 28);
		frame.getContentPane().add(wyszukanieOsoby);
		wyszukanieOsoby.setColumns(10);
		
		JButton wyszukaj = new JButton("Wyszukaj");
		wyszukaj.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				numerID=Integer.parseInt(wyszukanieNumeru.getText());
				wyszukiwanie();
			}
		});
		wyszukaj.setBounds(612, 11, 107, 28);
		frame.getContentPane().add(wyszukaj);
		
		JLabel lblNewLabel = new JLabel("NumerKlienta:");
		lblNewLabel.setBounds(198, 13, 86, 25);
		frame.getContentPane().add(lblNewLabel);
		
		final JComboBox kwotaWyplacana = new JComboBox(tabKwot);
		kwotaWyplacana.setToolTipText("Kwota do wyp\u0142aty");
		kwotaWyplacana.setBounds(142, 340, 120, 20);
		frame.getContentPane().add(kwotaWyplacana);
		
		final JComboBox kwotaDeponowana = new JComboBox(tabKwot);
		kwotaDeponowana.setToolTipText("Kwota do deponowania");
		kwotaDeponowana.setBounds(14, 340, 118, 20);
		frame.getContentPane().add(kwotaDeponowana);
		JButton deponowacPrzycisk = new JButton("Deponowa\u0107");
		deponowacPrzycisk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(bledny==false) 
				    deponowac(kwota[kwotaDeponowana.getSelectedIndex()]);
				else 
					System.err.println("NIE ZALOGOWALES SIE WLASCIWIE");
			}
		});
		deponowacPrzycisk.setBounds(10, 371, 122, 37);
		frame.getContentPane().add(deponowacPrzycisk);
		
		final JButton wyplacPrzycisk = new JButton("Wyp\u0142aci\u0107");
		wyplacPrzycisk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(bledny==false) 
					wyplacac(kwota[kwotaDeponowana.getSelectedIndex()]);
				else 
					System.err.println("NIE ZALOGOWALES SIE WLASCIWIE");
			}
		});
		wyplacPrzycisk.setBounds(142, 371, 118, 36);
		frame.getContentPane().add(wyplacPrzycisk);
		
		JButton usuwanie = new JButton("Usuwanie");
		usuwanie.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				tabKlient.remove(tabKlient.get(index));	
				tabPKlient[index][0]=null;
				tabPKlient[index][1]=null;
				numerKolejnosci--;
				numerKolejnosci--;
			}
		});
		usuwanie.setToolTipText("Usuwa wybrane konto");
		usuwanie.setBounds(533, 371, 118, 36);
		frame.getContentPane().add(usuwanie);
		
		JButton zmiana = new JButton("Zmiana");
		zmiana.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(window2!=null) window2.Rejestracja2(tabKlient.get(index));
			}
		});
		zmiana.setToolTipText("Zmienia dane konta ale tylko wybrane");
		zmiana.setBounds(405, 371, 118, 36);
		frame.getContentPane().add(zmiana);
		tableModel = new DefaultTableModel(tabPKlient, new String[] {"IDKlienta","Imie i nazwisko"});
		table = new JTable(tableModel);
		
		JButton wyszukajV2 = new JButton("WyszukajV2");
		wyszukajV2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				index=(int)tabPKlient[table.getSelectedRow()][0];
				wyszukiwaniev2();
			}
		});
		wyszukajV2.setToolTipText("zaznaczy\u0107 i kliknac wyszuka\u0107");
		wyszukajV2.setBounds(86, 293, 111, 36);
		frame.getContentPane().add(wyszukajV2);
	}

	@Override
	public void focusGained(FocusEvent arg0) {}
	
	@Override
	public void focusLost(FocusEvent arg0) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
}
