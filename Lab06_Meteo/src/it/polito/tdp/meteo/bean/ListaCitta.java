package it.polito.tdp.meteo.bean;

import java.util.*;

public class ListaCitta {
	private ArrayList<Citta> citta= new ArrayList<Citta>();
	
	/**
	 * riempo la lista contente le tre citta su cui lavoro
	 * @param lista richiede arraylist
	 */
	public void addAll(List<Citta> lista){
		citta.addAll(lista);
		
	}
	/**
	 * 
	 * @param lista
	 * @return numero di citta resenti nella lista
	 */
	public int size (){
		return citta.size();
		
	}
	/**
	 * 
	 * @param i posizione nell' array di citta
	 * @return citta in posisizione i
	 */
	public Citta getCitta(int i){
		if((i>=0)&&(i<citta.size())){
			return citta.get(i);
		}else{
			throw   new IndexOutOfBoundsException ();		}
		
		
		
	}

}
