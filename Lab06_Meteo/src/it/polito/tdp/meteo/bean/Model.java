package it.polito.tdp.meteo.bean;

import java.util.*;

public class Model {
	private int numeroGiorni=30;// da impostare uguale alla dimensione del mese
	int giorno;
	
	
	
	
	public void risolvi(List<Citta> listaCitta){
		Parziale parziale= new Parziale();
		Parziale best= new Parziale();
		
		ListaCitta l= new ListaCitta();
		l.addAll(listaCitta);
		
		this.aggiungi(parziale, best, l);
	}
	
	
	
	
	
	public void verificaBest(Parziale parziale,Parziale best, ListaCitta l){
		if(controlliEnd(parziale, l)==true){
			best.addAll(parziale.returnArray());
		     
		}else{
			this.aggiungi( parziale, best,  l);
		}
		
	
	}
	
	
	

	private void aggiungi(Parziale parziale, Parziale best, ListaCitta l) {// prima di darlo a verica controllo che il costo sia minore del best
		while(giorno<numeroGiorni){//controllo che stiamo sotto i 30, che nei primi 15 abbia visitato tutti i giorni, e le condizioni sugli ultimi giorni del mese etc
			if(snellisci(parziale, best, l, giorno)==true){
				for(int i=0; i<l.size();i++){			
					//int incremento=incrementaGiorno(parziale, l.getCitta(i));//(devo decidere di quantoincrementare), quando incremento di piu giorni ricorda di riempire comunque l' array
			     	giorno+=1;
					parziale.add(l.getCitta(i));
					if(calcolaCosti(parziale,best,l.getCitta(i), giorno)==true)
						verificaBest(parziale, best, l);
					parziale.remove(i);
					giorno-=1;
					
				}
			}
		}
		
	}









	private boolean snellisci(Parziale parziale, Parziale best, ListaCitta l, int giorno) {
	   if(giorno>15){
		  if( !parziale.treCitta())
			  return false;
	   }
	   for(int i=0; i<3; i++)
	         if(!parziale.giorniMaxCitta(l.getCitta(i)))
		           return false;
	   
	   if(parziale.getCostoTotale()>best.getCostoTotale())
		   return false;
	   
	  
		
		return true;
	}





	/**
     * verifico che i costi del parziale siano minori di quelli del best.
     * 
     * @return
     */
	private boolean calcolaCosti(Parziale parziale, Parziale best, Citta cit, int g) {
		Rilevamento r=cit.getRilevamento(g-1);
		int umidita= r.getUmidita();		
		parziale.incrementoCostoUmidita(umidita);
		if(!parziale.getIndex(g-1).equals(parziale.getIndex(g-2))){
			parziale.incrementaCostoSpostamento();
		}
		if(parziale.getCostoTotale()<best.getCostoTotale())
		     return true;
		return false;
	}




     /**
      * tutto cio che arriva qui ha costo minore del best,
      * devo percio solo controllare che sia stato in tutte le citta
      * e che sono riempiti tutti e 15 i giorni
      */
	private boolean controlliEnd(Parziale parziale, ListaCitta l) {
		if(parziale.getNumeroCitta()== l.size()){
			if(parziale.size()==numeroGiorni)
				return true;
		}
		return false;
	}




	
	
	

}
