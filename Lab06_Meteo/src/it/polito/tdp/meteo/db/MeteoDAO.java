package it.polito.tdp.meteo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.meteo.bean.Rilevamento;

public class MeteoDAO {

	public List<Rilevamento> getAllRilevamenti() {

		final String sql = "SELECT Localita, Data, Umidita FROM situazione ORDER BY data ASC";

		List<Rilevamento> rilevamenti = new ArrayList<Rilevamento>();

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
				rilevamenti.add(r);
			}

			conn.close();
			return rilevamenti;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Rilevamento> getAllRilevamentiLocalitaMese(int mese, String localita) {
	
		
		final String sql = "SELECT umidita,data FROM situazione WHERE Localita=? AND month(data)=? ";
		
		
		List<Rilevamento> rilevamenti= new ArrayList<Rilevamento>();
		
		try{
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setString(1, localita);
			st.setInt(2, mese);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {

				Rilevamento r = new Rilevamento(localita, rs.getDate("Data"), rs.getInt("Umidita"));
				rilevamenti.add(r);
			}
			conn.close();
			return rilevamenti;
		}catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	 
	/**
	 * dato un preciso mese e giorno torna il valore di umidita
	 * @param mese
	 * @param localita
	 * @param giorno
	 * @return inteto, valore umidita
	 */
	  public Rilevamento getAllRilevamentiCittaGiorno(int mese, String localita, int giorno) {
	
		
		final String sql = "SELECT umidita,data FROM situazione WHERE Localita=? AND month(data)=? AND day(data)=? ";
		
		
		
		
		try{
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setString(1, localita);
			st.setInt(2, mese);
			st.setInt(3, giorno);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {

				Rilevamento r = new Rilevamento(localita, rs.getDate("Data"), rs.getInt("Umidita"));
				conn.close();
				return r;
			}
			return null;
		}catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	 

	public Double getAvgRilevamentiLocalitaMese(int mese, String localita) {
		double umiditaMedia=0;
		
		final String sql=" SELECT AVG(umidita) as media FROM situazione Where localita = ? AND month(data)= ?";
				
		try{
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setString(1, localita);
			st.setInt(2, mese);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				umiditaMedia=rs.getDouble("media");
				
			}
			conn.close();
			return umiditaMedia;
		}catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}

