package it.polito.tdp.meteo.bean;

import java.util.Comparator;

public class PrevisioniPerData implements Comparator<Rilevamento> {

	@Override
	public int compare(Rilevamento a, Rilevamento b) {
		return a.getData().compareTo(b.getData());
	
	}

}
