package it.polito.tdp.meteo.bean;

import java.util.*;

public class Model {
	private int mese;
	private int giorniMese=30;
	private int costoViaggio=0;
	MyCity a=new MyCity("Genova");
		MyCity b=new MyCity("Torino");
		MyCity c=new MyCity("Milano");
		ArrayList<MyCity> elencoCitta= new ArrayList<MyCity>();
		
		
	public Best risolvi(int mese){
	//return quello di sotto best;
		ArrayList<MyCity> temp=this.inizializza(mese);
		Best b= new Best(temp, costoViaggio);
		return b;
		
	}
	private ArrayList<MyCity> inizializza(int mese) {
		this.mese=mese;
		elencoCitta.add(a);
		elencoCitta.add(b);
		elencoCitta.add(c);
		int livello=-1;
		int cash=0;
		ArrayList<MyCity> parziale= new ArrayList<MyCity>();
		ArrayList<MyCity> best= new ArrayList<MyCity>();
		this.aggiungi(parziale,best,livello, cash);
		
		return best;
		
	}
	
  //livello= giorni del mese; indica posizione nell' array
	private void aggiungi( ArrayList<MyCity> parziale, ArrayList<MyCity> best, int livello, int cash) {
		
		for(int i=0; i<elencoCitta.size();i++){
			MyCity c=elencoCitta.get(i);
			parziale.add(c);
			livello++;
			
			if(this.filtro(parziale, best, c,livello)==true){
				int costo=calcolaCosto(parziale,livello);
				cash+=costo;
				 if(verifica(parziale, best, cash)==false)
				     this.aggiungi(parziale, best,livello, cash);
				 
			}
			
			cash-=calcolaCosto(parziale,livello);
			parziale.remove(livello);
			livello--;
			
		}
		
	}
	private boolean verifica(ArrayList<MyCity> parziale, ArrayList<MyCity> best, int cash) {
		if(parziale.size()==giorniMese){
			if((cash<costoViaggio)||(costoViaggio==0)){
				best.addAll(parziale);
				costoViaggio=cash;
			}
			return true;
		}
		else{
			if((cash>costoViaggio)&&(costoViaggio!=0)){
				return true;
			}
			return false;
			
		}		
    }
	int f=0;
	
	private int calcolaCosto(ArrayList<MyCity> parziale, int livello) {
		int costo=0;
		if(livello>0)
		 if(!parziale.get(livello).equals(parziale.get(livello-1)))
			 costo+=100;
		
		System.out.println(f++);
		System.out.println("----------" +livello+1);
		 costo+= parziale.get(livello).getUmiditaGiorno(mese, livello+1);
			 
	return costo;
    }
	
	
	private boolean filtro(ArrayList<MyCity> parziale, ArrayList<MyCity> best, MyCity c, int livello) {
		
		if(controlloTreGiorni(parziale, livello)==true){
			if(livello>=14){
				return controlloTreCitta(parziale);
					
			}
			else{
				return true;
			}
		}
		return false;
	}
	
	private boolean controlloTreCitta(ArrayList<MyCity> parziale) {
		LinkedList<MyCity> temp= new LinkedList<MyCity>();
		temp.addAll(parziale);
		for(MyCity c: elencoCitta){
			if(!parziale.contains(c))
				return false;
		}
		
		return true;
	}
	
	private boolean controlloTreGiorni(ArrayList<MyCity> parziale, int livello) {
		if(livello>2){
			if(!parziale.get(livello).equals(parziale.get(livello-1))){
				//verifico che i  tre precedenti siano uguali
				for(int i=livello-1; i>livello-3;i--){
					if(!parziale.get(i).equals(parziale.get(i-1)))
						return false;
				}
				return true;
			}
			else return true;//ritorno true perche se la citta e uguale alla precedente non ho mai problemi
			
		}
		else {
			if(livello!=0){
				if(parziale.get(livello).equals(parziale.get(livello-1)))
					return true;
				else
					return false;
					
			}
			else return true;
			
		}
	}
	

}
