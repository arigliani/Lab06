package it.polito.tdp.meteo.bean;

import java.util.*;

public class Model {
	private Parziale parziale=new Parziale();
	private LinkedList<Citta> best=new LinkedList<Citta>();
	
	
	
	public void ultimo(){
		 
			//String ultimo= best.addAll(parziale.getString);
		//	return ultimo;
		
		
	}
	
	public void verificaBest (Parziale parziale){
		if(this.condizioni(parziale)==true){
			best.addAll(parziale.getValues());
		}
		else{
			int i=0;
			while (i< 15){
				if(condizionePartenza==true){
					calcolaCosti();
					
				}else{
					i++;
				}
			}
		}
		
	}
	
	/**
	 * verifico:
	 * - numero giorni tatali==15
	 * -numero citta ==3
	 * @param parziale
	 * @return
	 */
	public boolean condizioni(Parziale parziale){
		return false;
	}
	
	
	

}
