package it.polito.tdp.meteo.bean;

import java.util.List;

public class TestModel {
	
	public static void main(String[] args) {
		   
		   Parziale p=new Parziale();
		   Citta c1= new Citta("a");
		   Citta c2= new Citta("b");
		   Citta c3= new Citta("c");
		   
		   
		   p.add(c1);
		   p.add(c2);
		   p.add(c3);
		   
		  System.out.println(p.getNumeroCitta());
		  
		  System.out.println("-----------------");
		  
	}
		   
		  
		   
		


}
