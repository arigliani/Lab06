package it.polito.tdp.meteo.db;

import java.util.List;

import it.polito.tdp.meteo.bean.Rilevamento;

public class TestDAO {

	public static void main(String[] args) {

		MeteoDAO dao = new MeteoDAO();
       Rilevamento c= dao.getAllRilevamentiCittaGiorno(1, "Genova", 3);
       System.out.println(c.toString());
		System.out.println("----------");
		
		
		System.out.println("umidita media a Genove mese di aprile: "+dao.getAvgRilevamentiLocalitaMese(4, "Genova"));
		
		System.out.println("----------");
		
		List<Rilevamento> list = dao.getAllRilevamenti();

		// STAMPA: localita, giorno, mese, anno, umidita (%)
		for (Rilevamento r : list) {
			System.out.format("%-10s %2td/%2$2tm/%2$4tY %3d%%\n", r.getLocalita(), r.getData(), r.getUmidita());
		}
		
//		System.out.println(dao.getAllRilevamentiLocalitaMese(1, "Genova"));
//		System.out.println(dao.getAvgRilevamentiLocalitaMese(1, "Genova"));
//		
//		System.out.println(dao.getAllRilevamentiLocalitaMese(5, "Milano"));
//		System.out.println(dao.getAvgRilevamentiLocalitaMese(5, "Milano"));
//		
//		System.out.println(dao.getAllRilevamentiLocalitaMese(5, "Torino"));
//		System.out.println(dao.getAvgRilevamentiLocalitaMese(5, "Torino"));
        System.out.println(("-----------------"));
		
		System.out.println(dao.getAllRilevamentiCittaGiorno(4, "Genova", 22));
	}

}
