package edu.ub.informatica.disseny.totseries;

import java.util.Calendar;
import java.util.Date;
import totseries_it1b.Model.*;


/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries 
 * per a manegar l'aplicació de gestió de TotSeries.
 * 
 */
public class TotSeriesDataManager {

	/* -------------------------------------------------------------------
	 * Metodes a implementar per vosaltres. En aquests metodes creareu els
	 * vostres objectes a partir de la informacio obtinguda del fitxer XML
	 * 
	 * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
	 * dades que retorna el metode, es a dir que sou lliures de
	 * modificar-ho al gust, excepte les crides inicials que es fan.
	 * -------------------------------------------------------------------
	 */
        private TotSeries totSeries;
        private Serie serie;
        private Season season;

        public TotSeriesDataManager (){
            totSeries = new TotSeries();
        }
    
        /**
         * Returns the object totSeries. If obtenirDades was called, totSeries contains
         * the info of the xml file.
         * @return totSeries
         */
        public TotSeries getTotSeries(){
            return this.totSeries;
        }

	/**
	 * Obté les dades del fitxer XML passat per paràmetre
	 * 
	 * @param nomFitxer ruta del fitxer XML del que obtenir les dades
	 */
	public void obtenirDades(String nomFitxer) {
		TotSeriesXMLParser parser = new TotSeriesXMLParser(this);
		parser.parse(nomFitxer);
	}

	/**
	 * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la serie. El podeu utilitzar o no
	 * @param title títol de la serie
         * @param desc descripcio de la serie
	 */
	
	public void crearSerie(String id, String title, String desc) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova serie.
		 */

		/*System.out.println("\nSerie amb ID: " + id);
		System.out.println("--------------------------------------------------");
		System.out.println("Titol: " + title);
		System.out.println("Descripció: " + desc);*/
                
                serie = new Serie(id, title, desc, null);
                totSeries.getCatalog().addSerie(serie);
	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param numTemporada numero de la temporada
	 * @param numEpisodis numero d'episodis
         * 
	 */
	
	public void crearTemporada(String numTemporada, String numEpisodis) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova temporada.
		 */

		/*System.out.println("Temporada: " + numTemporada + " Numero Episodis: "+ numEpisodis);
                System.out.println("--------------------------------------------------");*/
                
                season = new Season(serie, Integer.parseInt(numTemporada));
                serie.addSeason(season);

	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param title titol de lepisodi
	 * @param duration duració de l'episodi
         * @param idioma idioma de l'episodi V.O.
         * @param description sinopsi de l'episodi
         * @param data data d'estrena de l'episodi
         * 
	 */
	
	public void crearEpisodi(String title, String duration, String idioma, String description, String data) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nou episodi.
		 */

		/*System.out.println("\nTitol: " + title);
                System.out.println("--------------------------------------------------");
                System.out.println("Duració; " + duration);
                System.out.println("Data d'estrena: " + data);
                System.out.println("Idioma: " + idioma);
                System.out.println(description);*/
                
                int year = Integer.parseInt(data.substring(data.lastIndexOf("/")+1));
                int month = Integer.parseInt(data.substring(data.indexOf("/")+1, data.lastIndexOf("/")));
                int day = Integer.parseInt(data.substring(0,data.indexOf("/")));
                Calendar date = Calendar.getInstance();
                date.set(year, month, day);
                Episode e = new Episode(season, season.getEpisodesCount()+1, title, description, duration, idioma, date);
                season.addEpisode(e);
                
	}

	/**
	 * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del artista. El podeu utilitzar o no
	 * @param nom nom del artista
	 * @param tipus tipus (director\actor) del artista
	 * @param idSerie serie a la qual treballa. El podeu utilitzar o no
         * @param nacionalitat 
	 */

	public void crearArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {

		/* TODO: Aqui feu el necessari per a crear els artistes per a la serie
		 */

		System.out.println("\nArtista amb ID: " + id);
		System.out.println("--------------------------------------");
		System.out.println("Nom: " + nom);
		System.out.println("Tipus: " + tipus);
		System.out.println("Serie ID: " + idSerie);
                System.out.println("Nacionalitat: " + nacionalitat);
                
                Artist a;
                int idInt = Integer.parseInt(id);
                if(tipus.equals("director")) a = new Director(idInt, nom, nacionalitat);
                else a = new Actor(idInt, nom, nacionalitat);
                Serie s = totSeries.getCatalog().getSerieById(idSerie);
                if(s != null){
                    a.addSerie(s);
                    s.addArtist(a);
                }
	}
	
		
	/**
	 * Crea productora del fitxer XML
	 * 
	 * @param id id de la productora
	 * @param nom nom de la productora
	 * @param idSerie id de la serie que va fer. El podeu utilitzar o no
	 */
	public void crearProductora (String id, String nom, String idSerie) {

		/* TODO: Aqui feu el necessari per a crear les productores per a les series
		 */

		System.out.println("\nProductora amb ID: " + id);
		System.out.println("--------------------------------------");
		System.out.println("Nom: " + nom);
		System.out.println("Serie ID: " + idSerie);
                
                Producer prod = new Producer(nom, Integer.parseInt(id), 0);
                Serie s = totSeries.getCatalog().getSerieById(idSerie);
                if(s != null){
                    s.setProducer(prod);
                    prod.addSerie(s);
                }
	}

	/**
	 * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la valoracio. El podeu utilitzar o no
	 * @param client identificador del client. El podeu utilitzar o no
	 * @param episodi identificador de la serie. El podeu utilitzar o no
	 * @param puntuacio puntuacio donada al episodi
	 * @param data data en la que es va fer la puntuacio
	 */
	
	public void crearValoracio(String id, String client, String episodi, String puntuacio, String data) {

		/* TODO: A partir d'aqui creeu la valoracio
		 */
		System.out.println("\nValoracio amb ID: " + id);
		System.out.println("--------------------------------------");
		System.out.println("Client: " + client);
		System.out.println("Episodi: " + episodi);
		System.out.println("Puntuacio: " + puntuacio);
		System.out.println("Data: " + data);
                
                
	}

	/**
	 * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del administrador
	 * @param nom nom del administrador
	 * @param usuari usuari del administrador
	 * @param password password del administrador
	 */
	public void crearAdmin(String id, String nom, String usuari, String password) {

		/* TODO: Creeu aqui el vostre admin
		 */

		System.out.println("\nAdmin ID: " + id);
		System.out.println("-----------------");
		System.out.println("Nom: " + nom);
		System.out.println("Usuari: " + usuari);
		System.out.println("Password: " + password);
                
                Admin ad = new Admin(totSeries, id, nom, usuari, password);
                totSeries.addUser(ad);
	}

	/**
	 * Crea un nou client a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del client
	 * @param nom nom del client
	 * @param dni dni del client
	 * @param adreca adreça del client
	 * @param usuari usuari al sistema del client
	 * @param password password del client
	 * @param vip true si el client es vip. false si no
	  */

	public void crearClient(String id, String nom, String dni, String adreca, String usuari, String password, String vip) {

		/* TODO: Creeu aqui el vostre client
		 */

		System.out.println("\nClient ID: " + id);
		System.out.println("-----------------");
		System.out.println("Nom: " + nom);
		System.out.println("Usuari: " + usuari);
		System.out.println("Dni: " + dni);
		System.out.println("Adreça: " + adreca);
		System.out.println("Password: " + password);
		System.out.println("Es VIP: " + vip);
		
                // TODO birthdate??
                Client c;
                if(vip.equals("true")) c = new VIPClient(totSeries, id, usuari, password, nom, "Spain", adreca, null);
                else c = new Client(totSeries, id, usuari, password, nom, "Spain", adreca, null);
                totSeries.addUser(c);
	}
}
