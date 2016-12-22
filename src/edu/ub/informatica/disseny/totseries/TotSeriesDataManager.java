package edu.ub.informatica.disseny.totseries;

import java.util.Calendar;
import totseries_it1b.Model.*;
import totseries_it1b.Model.Factories.*;

/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries per a
 * manegar l'aplicació de gestió de TotSeries.
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

    public TotSeriesDataManager() {
        totSeries = new TotSeries();
    }

    /**
     * Returns the object totSeries. If obtenirDades was called, totSeries
     * contains the info of the xml file.
     *
     * @return totSeries
     */
    public TotSeries getTotSeries() {
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
        SerieFactory sF = FactoryCreator.Create(SerieFactory.class);
        serie = sF.create(id, title, desc);
        totSeries.getCatalog().addSerie(serie);
    }

    /**
     * Crea una nova temporada a partir de la informacio obtinguda del fitxer
     * XML
     *
     * @param numTemporada numero de la temporada
     * @param numEpisodis numero d'episodis
     *
     */
    public void crearTemporada(String numTemporada, String numEpisodis) {
        SeasonFactory sF = FactoryCreator.Create(SeasonFactory.class);
        season = sF.create(serie, Integer.parseInt(numTemporada));
        serie.addSeason(season);

    }

    /**
     * Crea una nova temporada a partir de la informacio obtinguda del fitxer
     * XML
     *
     * @param title titol de lepisodi
     * @param duration duració de l'episodi
     * @param idioma idioma de l'episodi V.O.
     * @param description sinopsi de l'episodi
     * @param data data d'estrena de l'episodi
     *
     */
    public void crearEpisodi(String title, String duration, String idioma, String description, String data) {
        int year = Integer.parseInt(data.substring(data.lastIndexOf("/") + 1));
        int month = Integer.parseInt(data.substring(data.indexOf("/") + 1, data.lastIndexOf("/")));
        int day = Integer.parseInt(data.substring(0, data.indexOf("/")));
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);

        EpisodeFactory eF = FactoryCreator.Create(EpisodeFactory.class);
        Episode e = eF.create(season, season.getEpisodesCount() + 1, title, description, duration, idioma, date);
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
        Artist a;
        int idInt = Integer.parseInt(id);
        if (tipus.equals("director")) {
            DirectorFactory fact;
            fact = FactoryCreator.Create(DirectorFactory.class);
            a = fact.create(idInt, nom, nacionalitat);
        } else {
            ActorFactory fact;
            fact = FactoryCreator.Create(ActorFactory.class);
            a = fact.create(idInt, nom, nacionalitat);
        }
        Serie s = totSeries.getCatalog().getSerieById(idSerie);
        if (s != null) {
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
    public void crearProductora(String id, String nom, String idSerie) {
        ProducerFactory fact = FactoryCreator.Create(ProducerFactory.class);
        Producer prod = fact.create(Integer.parseInt(id), nom);
        Serie s = totSeries.getCatalog().getSerieById(idSerie);
        if (s != null) {
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
        // NO HI HA
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

        AdminFactory fact = FactoryCreator.Create(AdminFactory.class);
        Admin ad = fact.create(id, nom, usuari, password);
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

        boolean isVIP = vip.equals("true");
        ClientFactory fact = FactoryCreator.Create(ClientFactory.class);
        Client c = fact.create(id, nom, usuari, password, isVIP);
        totSeries.addUser(c);
    }
}
