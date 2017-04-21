package it.polito.tdp.meteo.bean;

import java.util.*;

public class Parziale {
	private ArrayList<Citta> parziale= new ArrayList<Citta>();
	private int costoTotale=0;
	private int giorniTotali=0;
	private int numeroCitta=0;;
	
	/**
	 * riempo la lista contente le tre citta su cui lavoro
	 * @param lista richiede arraylist
	 */
	public void addAll(List<Citta> lista){
		parziale.addAll(lista);
		
	}
	
	public List<Citta> returnArray(){
		return parziale;
	}
	
	
	/**
	 * aggiungesingolo elemento
	 * incrementa giorni totale, e nella citta
	 * @param citta
	 */	
	public void add(Citta citta){
		          if(!parziale.contains(citta)){
		        	  numeroCitta++;
		          }
		          parziale.add(citta);		          
		          incrementaContatoreGiorni(citta);
		          incrementaGiorniTotali();
	}
	
	public void remove (int i){// questa struttura dati va bene perche tanto è sempre l' ultimo a essere rimmosso
		parziale.remove(i);
	}
	
	/**
	 * 
	 * @param citta aumenta il numero di giorni in una citta;
	 */
	public void incrementaContatoreGiorni(Citta citta) {
		citta.increaseCounter();
		
	}

	/**
	 * @param lista
	 * @return numero di citta presenti nella lista
	 */
	public int size (){
		return parziale.size();
		
	}
	
	public int incrementaCostoSpostamento(){
		costoTotale+=100;
		return costoTotale;
		
	}
	
	/**	  
	 * @param i e la %moltiplicata per 100
	 * @return costo totale fino quel momento
	 */
	public int incrementoCostoUmidita(int i){
		costoTotale+=i;
		return costoTotale;
	}
	
	public void incrementaGiorniTotali(){
		giorniTotali++;
	     
	}
	
	public int getGiorniTotali(){
		return giorniTotali;
	}
	
	public int getNumeroCitta(){
	     return numeroCitta;
	}
	
	public int getCostoTotale(){
	     return costoTotale;
	}

	public Citta getIndex(int i) {
		
		return parziale.get(i);
	}

	public boolean treCitta() {
		Set<Citta> temp= new HashSet<Citta>();
		for(int i=0; i<15; i++){
			Citta c=parziale.get(i);
			if(!temp.contains(c))
				temp.add(c);
		}
		
		if(temp.size()==3)
		      return true;
		else
			return false;
	}

	public boolean giorniMaxCitta(Citta c) {
		if(c.getCounter()>6)
		     return false;
		else return true;
	}
	

}
