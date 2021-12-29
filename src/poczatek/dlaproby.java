package poczatek;
import java.util.Scanner;

public class dlaproby {

	public static void main(String[] args) 
	{
		while(true) {
		String test="%";
		Scanner scan=new Scanner(System.in);	
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
    	 max=max+2; //dla lepszego widoku 
    	 test=test+max+"d";
    	 for(int i=0;i<n;i++) 
    	 {
    		 for(int j=0;j<n;j++) 
    		 {
    			System.out.printf(test,tab[i][j]);
    		 }
    		 System.out.println();
    	 }
		}
	}
	

}
