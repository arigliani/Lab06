package it.polito.tdp.meteo.bean;

import java.util.*;

public class Model {
	private int mese;
	private int giorniMese=15;
	private int costoViaggio=0;
	MyCity a=new MyCity("Genova");
		MyCity b=new MyCity("Torino");
		MyCity c=new MyCity("Milano");
		ArrayList<MyCity> elencoCitta= new ArrayList<MyCity>();
		
	
		
		
     /**
      * la funzione da chiamare nel controller
      * @param mese
      * @return tipo best: questo oggetto è formato dalla lista di citta i ordine di percorrenza e dal costo totale di questa combinazione
      */
	public Best risolvi(int mese){
	//return quello di sotto best;
			ArrayList<MyCity> temp=this.inizializza(mese);
		
		Best b= new Best(temp, costoViaggio);
		return b;
		
	}

   /**
    * creo la lista con le tre citta da visitare
    * inizaliazzo parziale, best, livello, e cash.
    * Richiamo per la prima volta il metodo ricorsivo "aggiungi()"
    * @param mese
    * @return la lista con la combianzone migliore trovata
    */
	private ArrayList<MyCity> inizializza(int mese) {
		this.mese=mese;
		elencoCitta.add(a);
		elencoCitta.add(b);
		elencoCitta.add(c);
		int livello=0;
		int cash=0;
		ArrayList<MyCity> parziale= new ArrayList<MyCity>();
		ArrayList<MyCity> best= new ArrayList<MyCity>();
		this.aggiungi(parziale,best,livello, cash);
		
		return best;
		
	}
	
	
	
	/**
	 *condizione di teminazione presente nel metodo verifia().
	 *
	 * 
	 * @param parziale arrayList su cui lavoro, aggiungo e rimuovo elementi finchè viene rispetata la condizone di terminazione del metodo verifica()
	 * @param best arrayList dove metto la soluzione migliore
	 * @param livello: puo assumere valore da 0 a 14, ogni giorno del mese corrisponde a un livello, indica posizione nell' array
	 * @param cash: tiene il conto di quanto costa la soluzione parziale
	 */
 
	private void aggiungi( ArrayList<MyCity> parziale, ArrayList<MyCity> best, int livello, int cash) {  
		//commento ba
		
	 if(verifica(parziale, best, cash)==false)				
		for(int i=0; i<elencoCitta.size();i++){
			MyCity c=elencoCitta.get(i);
			parziale.add(c);
			
			if(this.filtro(parziale, best, c,livello)==true){
				//commento bb
                   	
				int costo=calcolaCosto(parziale,livello);
				cash+=costo;
						 
				     this.aggiungi(parziale, best,livello+1, cash);
				 cash-=costo;
			}

			parziale.remove(livello);
			
		}
		
	}
	
	
	/**
	 * condizione di terminazione della ricorsione.
	 * La condizione di terminazione e': la soluzione parziale ha attribuito un valore di umidita' a tutti i giorni del mese.
	 * 
	 * se questa e' verificata controllo se la soluzione e' valida guardando se sono presenti le 3 citta, in caso positivo vedo se costano meno del best che gia avevo
	 * 
	 * 
	 * @return true: se verifica che ha parziale ha dimensione max, oppure che parziale ha costo> di best
	 */
	private boolean verifica(ArrayList<MyCity> parziale, ArrayList<MyCity> best, int cash) {
		if(parziale.size()==giorniMese){
			//prova con commento aa
		
			
			
		if(	 controlloTreCitta(parziale)){		
			if((cash<costoViaggio)||(costoViaggio==0)){
				best.clear();
				best.addAll(parziale);
				costoViaggio=cash;
				//commento ca
				
			}
			return true;
		  }
		else{
			return false;
		}
		}
		else{
			if((cash>costoViaggio)&&(costoViaggio!=0)){
				return true;
			}
			return false;
			
		}		
    }
	/**
	 * passa il costo perstare in una determinata citta'in unpreciso giorno.
	 * 
	 * verifica prima che il livello sia>0 ( quindi che in parziale ci siano almeno 2 elemnti), in tal caso
	 * verifica se si è cammbiata città e incrementa di cento.
	 * 
	 * Chiede  all' oggetto parziale.get(livello) di tipo MyCity di verificare in quella citta, in quella precisa data, quanta umidita' c'e'
	 * @param parziale:parziale.size()= livello+1, la dimensione ha il valore dei giorni;
	 * @param livello indica la posizione all' interno dell'ArrayList parzile.
	 * @param livello+1= giorno del mese che si sta esaminando
	 * @return
	 */
	private int calcolaCosto(ArrayList<MyCity> parziale, int livello) {
		int costo=0;
		if(livello>0)
		 if(!parziale.get(livello).equals(parziale.get((livello-1))))
			 costo+=100;
		
                                               // System.out.println(" mese : "+mese);
		                                        //System.out.println("giorno " +(livello+1));
		 costo+= parziale.get(livello).getUmiditaGiorno(mese, (livello+1));
	                                              // 	 System.out.println("costo " +costo);
		 
			 
	return costo;
    }
	
	/**
	 * ha la funzione di escludere alcuni rami della ricorsione che sicuramente non portano
	 * alla soluzione best.
	 * 
	 * verifica che: almeno tre giorni in una certa citta "controlloTreGiorni()"
	 * verifica che nei primi 15 giorni siano visitate tutte le citta "controlloTreCitta()"
	 * verifi max 6 giorni per citta "controlloMaxGioni()"
	 * 
	 * @param parziale
	 * @param best
	 * @param c
	 * @param livello
	 * @return true se il controllo e' superato, false altrimenti
	 */
	private boolean filtro(ArrayList<MyCity> parziale, ArrayList<MyCity> best, MyCity c, int livello) {
		if(!controlloMaxGioni(parziale)){
			return false;
		}
		if(controlloTreGiorni(parziale, livello)==true){
			
				return true;
			
		}
		return false;
	}
	
	private boolean controlloMaxGioni(ArrayList<MyCity> parziale) {
		for(MyCity c: elencoCitta){
			int count=0;
			for(MyCity p: parziale){
				if(c.equals(p)){
					count++;
				}
				if(count==6)
					return false;
			}
		}
		return true;
	}
   /**
    * 
    * @param parziale
    * @return true se contiene le tre citta;
    */
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
//commento aa
/*	System.out.println("yooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
if(parziale.size()>0)
{	MyCity a=parziale.get(0);
int count=0;
int i=0;
for(MyCity b:parziale){
	
	System.out.println("citta " + b.getNome()+" "+i++);
	/*if(b.equals(a)){
		count++;
	}
	else{
		System.out.println("citta " + b.getNome()+" "+count);
		count=1;
		a=b;
	}
}   

if(	controlloTreCitta(parziale)==true){		
	//if((cash<costoViaggio)||(costoViaggio==0)){
		System.out.println(" tre citta va a bomba");
	//}
	//else{
		System.out.println("cash: "+cash+" costo viaggio " +costoViaggio);
	//}
}
}
System.out.println("yooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
*/


//commento ba
/*	if(parziale.size()>0)
{	MyCity a=parziale.get(0);
int count=0;
for(MyCity b:parziale){
	if(b.equals(a)){
		count++;
	}
	else{
		System.out.println("citta " + b.getNome()+" "+count);
		count=1;
		a=b;
	}
}
}
System.out.println("-----------");   */




//comento bb
/*System.out.println("livello " +livello);
System.out.println("cash " +cash);
System.out.println("dimensione parziale " +parziale.size());
System.out.println("ultimoparziale " +parziale.get(parziale.size()-1).toString());
if(!best.isEmpty()){
	System.out.println("\n");
	MyCity a=best.get(0);
	int count=0;
	
	for(MyCity b:best){
		if(b.equals(a)){
			count++;
		}
		else{
			System.out.println("citta " + b.getNome()+" "+count);
			count=1;
			a=b;
		}
	}
	System.out.println("costo del best " +this.costoViaggio);
	System.out.println("\n");

}*/


//commento ca
/*System.out.println("yooooooooooooooo");
int i=1;
for(MyCity b:best){
	System.out.println( " citta: "+b.getNome()+" "+ i++);
	}
System.out.println("costo" +cash);
System.out.println("yooooooooooooooo"); */
