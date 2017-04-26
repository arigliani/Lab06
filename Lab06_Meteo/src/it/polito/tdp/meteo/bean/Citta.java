package it.polito.tdp.meteo.bean;

import java.util.*;

import it.polito.tdp.meteo.db.MeteoDAO;

public class Citta {

	private String nome;
	private ArrayList<Rilevamento> rilevamenti;
	private int counter = 0;
	private MeteoDAO dao = new MeteoDAO();
	
	
	public Citta(String nome) {
		this.nome = nome;
	}
	
	public Citta(String nome, List<Rilevamento> rilevamenti) {
		this.nome = nome;
		this.rilevamenti.addAll(dao.);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Rilevamento> getRilevamenti() {
		

		Collections.sort(rilevamenti, new PrevisioniPerData());
		return rilevamenti;
	}
	
	public Rilevamento getRilevamento(int giorno){
		return rilevamenti.get(giorno);
	}

	public void setRilevamenti(List<Rilevamento> rilevamenti) {
		this.rilevamenti.addAll(rilevamenti);
		
		Collections.sort(rilevamenti, new PrevisioniPerData());
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	/**
	 * giorni passati nella citta
	 */
	public void increaseCounter() {
		this.counter += 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citta other = (Citta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}
