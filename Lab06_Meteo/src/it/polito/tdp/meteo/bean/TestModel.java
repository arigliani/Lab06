package it.polito.tdp.meteo.bean;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.meteo.db.MeteoDAO;

public class TestModel {
	
	public static void main(String[] args) {
		   Model m= new Model();
		   Parziale p=new Parziale();
		   Citta c1= new Citta("Genova");
		   Citta c2= new Citta("Torino");
		   Citta c3= new Citta("Milano");
		   List<Citta> citta= new ArrayList<Citta>();
		   citta.add(c1);
		   citta.add(c2);
		   citta.add(c3);
		   
		  // ListaCitta listaCitta= new ListaCitta();
		 //  listaCitta.addAll(citta);
		 
        MeteoDAO dao= new MeteoDAO();
		  m.risolvi(citta);
		//  List<Rilevamento> rilevamenti= dao.getAllRilevamentiLocalitaMese(1, "Genova");
		  
		  
		  
	}
		   
		  
		   
		


}
