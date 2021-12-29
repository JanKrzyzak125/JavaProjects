package poczatek;

public class Student implements Comparable<Student>
{
	private Integer rocznik;
	private Integer srednia;
	private String nazwisko;
	
	public int getRocznik() 
	{
		return rocznik;
	}
	
	public int getSrednia() 
	{
		return srednia;	
	}
	
	public String getNazwisko() 
	{
		return nazwisko;
	}
	
	
	public void setRocznik(int Rocznik) 
	{
		this.rocznik=Rocznik;
	}
	
	public void setSrednia(int Srednia) 
	{
		this.srednia=Srednia;	
	}
	
	public void setNazwisko(String Nazwisko) 
	{
		this.nazwisko=Nazwisko;
	}
	
	public Student(int Rocznik,String Nazwisko,int Srednia)
	{ 
		 setRocznik(Rocznik); 
		 setSrednia(Srednia); 
		 setNazwisko(Nazwisko); 
	}

	@Override
	public int compareTo(Student t) 
	{
		if (this.rocznik.compareTo(t.rocznik)==0 ) 
		{
			if (this.srednia.compareTo(t.srednia) == 0) return (this.nazwisko.compareTo(t.nazwisko));
			else  return (srednia.compareTo(t.srednia));
		}
		else  
			return (rocznik.compareTo(t.rocznik));	
	}
	
	@Override
	public String toString() 
	{
		return (rocznik+" "+srednia+" "+nazwisko);
	}

}
