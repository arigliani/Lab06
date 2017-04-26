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
		return "Best [best=" + best + ", costo=" + costo + "]";
	}
	
	

}
