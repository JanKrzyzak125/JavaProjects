package lista6;

public class kolordelfina extends delfin {
	
  public String tabkolor[]= {"bia³y","niebieski","turkusowy"};
  
  kolordelfina()
  {
	  super();
  }
  
  public String jakiKolor() 
  {
	  return tabkolor[this.kolor];
  }
}
