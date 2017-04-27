package it.polito.tdp.meteo.bean;

import java.util.List;

import it.polito.tdp.meteo.db.MeteoDAO;

public class MyCity {
	private String nome;
	private Rilevamento rilevamento;
	private MeteoDAO dao= new MeteoDAO();
	
	public MyCity(String nome) {
		super();
		this.nome = nome;
	}
	
	/**
	 * torna il valore di umidita in un preciso giorno
	 * di un reciso mese
	 */
	public int getUmiditaGiorno (int mese, int giorno){
		//System.out.println("mese: "+mese+" citta: "+this.nome+" gioro "+giorno);
		rilevamento=dao.getAllRilevamentiCittaGiorno(mese, this.nome, giorno);
		return rilevamento.getUmidita();
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
		MyCity other = (MyCity) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyCity [nome=" + nome + "]";
	}

	public String getNome() {
		
		return this.nome;
	}
	
	
	
	


}
