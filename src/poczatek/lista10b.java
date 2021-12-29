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
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;


public class lista10b  {

	public JTextPane textz;
	public JTextPane textczasz;
	
	private JFrame frame;

	private long start;
	private long stop;
	private long czas=0;
	private int max=10000;
	private int aktualny=max;
	
	private String wynikCzasow="Czas wynosi=";
	private String wynik="";
	
	public void funkcja(JTextPane gdzie,JTextPane time)
	{
		while(aktualny>0) 
		{
			start=System.currentTimeMillis();
			aktualny--;
			wynik=wynik+" "+aktualny;
			stop=System.currentTimeMillis();
			czas=czas+(stop-start);
			gdzie.setText(wynik);
		}
		wynikCzasow=wynikCzasow+" "+czas;
		time.setText(wynikCzasow);
		czas=0;
		aktualny=max;
		wynik="";
	}
	
	
	public class Adder1  implements Runnable 
	{	
		Adder1()throws InterruptedException 
		{
			Thread.sleep(20);	
		}
		
		@Override
		public void run() 
		{
			
			funkcja(textz,textczasz);
		}
	}

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					lista10b window = new lista10b();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public lista10b() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1066, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textbez = new JTextPane();
		textbez.setBounds(10, 11, 500, 400);
		frame.getContentPane().add(textbez);
		
		textz = new JTextPane();
		textz.setBounds(521, 11, 500, 400);
		frame.getContentPane().add(textz);
		
		JTextPane textczasbez = new JTextPane();
		textczasbez.setBounds(304, 410, 206, 99);
		frame.getContentPane().add(textczasbez);
		
		JButton bezWatkow = new JButton("Bez Watkow");
		bezWatkow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				wynikCzasow="Czas wynosi=";
				funkcja(textbez,textczasbez);			
			}
		});
		bezWatkow.setBounds(132, 429, 98, 23);
		frame.getContentPane().add(bezWatkow);
		
		textczasz = new JTextPane();
		textczasz.setBounds(826, 410, 195, 99);
		frame.getContentPane().add(textczasz);
		
		JButton zWatkami = new JButton("Z Watkami");
		zWatkami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				wynikCzasow="Czas wynosi=";
				for(int i=0;i<5;i++)
				{
					try {
						new Thread(new Adder1()).start();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		zWatkami.setBounds(643, 429, 98, 23);
		frame.getContentPane().add(zWatkami);
		
		JLabel lblNewLabel = new JLabel("Czas=");
		lblNewLabel.setBounds(240, 433, 54, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Czas=");
		label.setBounds(762, 433, 54, 14);
		frame.getContentPane().add(label);
		
	}

}
