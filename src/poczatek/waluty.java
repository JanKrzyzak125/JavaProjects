package poczatek; 

import java.io.IOException;
import java.lang.Object;
import models.rates.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import enumtypes.CurrencyCodeTableA;
import models.rates.ExchangeRatesSeries;
import models.tablec.ArrayOfExchangeRatesTableC;
import models.tables.ArrayOfExchangeRatesTable;
import models.tables.ExchangeRatesTable;
import http.TableA;
import http.TableB;
import http.TableC;

public class waluty {

	public static void main(String[] args) throws IOException {
		LocalDate dzisiaj=LocalDate.now();

		
		
		
		TableA tablica=new TableA();

		ArrayOfExchangeRatesTable tab1;

		tab1=tablica.publishedOnDateTable(dzisiaj);
		CurrencyCodeTableA s=null;
		System.out.println(tablica.currentExchangeRate(s.EUR).getMax());
		


	}

}
