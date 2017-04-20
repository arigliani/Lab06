package it.polito.tdp.meteo.bean;

import java.util.*;

public class Parziale {
	private Set<Citta> parziale= new HashSet<Citta>();
	public int costoTotale=0;
	int giorniTotali=0;
	
	/**
	 * riempo la lista contente le tre citta su cui lavoro
	 * @param lista richiede arraylist
	 */
	public void addAll(List<Citta> lista){
		parziale.addAll(lista);
		
	}
	
	public Set<Citta> returnArray(){
		return parziale;
	}
	
	
	/**
	 * aggiungesingolo elemento
	 * @param citta
	 */	
	public void add(Citta citta){
		if(!parziale.contains(citta))
		          parziale.add(citta);
		else
			incrementaContatoreGiorni(citta);
	}
	/**
	 * rimuovi un' elemento dalla lista
	 * @param citta verra rimosso;
	 */
	public void remove (Citta citta){
		if(parziale.contains(citta))
		           parziale.remove(citta);
		else{
			throw new NullPointerException();
		}
	}
	
	/**
	 * 
	 * @param citta aumenta il numero di giorni in una citta;
	 */
	private void incrementaContatoreGiorni(Citta citta) {
		citta.increaseCounter();
		
	}

	/**
	 * @param lista
	 * @return numero di citta presenti nella lista
	 */
	public int size (List<Citta> lista){
		return lista.size();
		
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
	
	public void calcolaGiorniTotali(){
		Iterator<Citta> c= parziale.iterator();
	     while(c.hasNext()){
	    	giorniTotali+=c.next().getCounter();
	     }
	     
	}
	
	public int getGiorniTotali(){
		return giorniTotali;
	}

}
