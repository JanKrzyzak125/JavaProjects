package Projekt;

public class Klient 
{
   private int idKlient;
   private int stanKonta;
   
   private String imieNazwisko;
   private String email;
   private String pesel;
   private String adres;
   private String miasto;

   public int getIdKlient() 
   {
	   return this.idKlient;
   }
   
   public String getPesel() 
   {
	   return this.pesel;
   }
   
   public int getStanKonta() 
   {
	   return this.stanKonta;
   }
   public String getImieNazwisko() 
   {
	   return this.imieNazwisko;
   }
   public String getAdres() 
   {
	   return this.adres;
   }
   public String getMiasto() 
   {
	   return this.miasto;
   }
   public String getEmail() 
   {
	   return this.email;
   }
   
   public void setStanKonta(int StanKonta) 
   {
	   this.stanKonta=StanKonta;
   }
   public void setAdres(String Adres) 
   {
	   this.adres=Adres;
   }
   public void setMiasto(String Miasto) 
   {
	   this.miasto=Miasto;
   }
   
   Klient(int IDKlient,String ImieNazwisko)
   {
	   
   }
   
   
   public String getMessage() 
   {
	   return "Numer Klienta="+idKlient+" Imie i Nazwisko="+imieNazwisko+" Adres="+adres+" Miasto="+miasto+" Email="+email+" Pesel="+pesel+" Stan srodkow na koncie="+stanKonta+"zl";
   }
   
   Klient(int IDKlient,String ImieNazwisko,String Adres,String Miasto,String Email,String Pesel) 
   {
	  this.idKlient=IDKlient;
	  this.imieNazwisko=ImieNazwisko;
	  this.adres=Adres;
	  this.miasto=Miasto;
	  this.email=Email;
	  this.pesel=Pesel;
	  this.stanKonta=0;
   }
 

}
