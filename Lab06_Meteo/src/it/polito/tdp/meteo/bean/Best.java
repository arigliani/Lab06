package it.polito.tdp.meteo.bean;

import java.util.ArrayList;

public class Best {
	
	private ArrayList<MyCity> best= new ArrayList<MyCity>();
	private int costo;
	
	
	public Best(ArrayList<MyCity> best, int costo) {
		super();
		this.best = best;
		this.costo = costo;
	}


	@Override
	public String toString() {
		String s="";
		MyCity a=best.get(0);
		int count=0;
		
		for(MyCity b:best){
			//System.out.println("citta"+ b.getNome() );
			if(b.equals(a)){
				count++;
			}
			else{
				s+=("citta "+ a.getNome()+" "+count+ "\n");
				count=1;
				a=b;
			}
		}
		s+=("citta "+ a.getNome()+" "+count+ "\n");
		s=s+"costo totale soluzione best: "+costo;
		return  s;
	}
	
	

}
