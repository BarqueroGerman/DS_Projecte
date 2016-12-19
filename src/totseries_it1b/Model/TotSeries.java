/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que conte totes les dades de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class TotSeries {

    private Catalog catalog;
    private BestRatedEpisodes bestRatedEp;
    private BestRatedSeries bestRatedSer;
    private MostViewedSeries mostViewedSer;
    private UsersList userslist;

    public TotSeries() {
        this.catalog = new Catalog(this);
        userslist = new UsersList();

        bestRatedEp = new BestRatedEpisodes(this, 10);
        bestRatedSer = new BestRatedSeries(this, 10);
        mostViewedSer = new MostViewedSeries(this, 10);
    }

    /**
     * Mètode que retorna true si existeix un usuari amb aquell username.
     *
     * @param username
     * @return
     */
    public boolean usernameRegistered(String username) {
        return userslist.getByUsername(username) != null;
    }

    /**
     * Mètode que retorna l'usuari amb aquell username.
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        return userslist.getByUsername(username);
    }

    /**
     * Mètode que afegeix un usuari a la base de dades.
     *
     * @param u
     * @return
     */
    public boolean addUser(User u) {
        if (!usernameRegistered(u.getUsername())) {
            this.userslist.add(u);
            return true;
        }
        return false;
    }

    /**
     * Getter de cataleg.
     *
     * @return cataleg
     */
    public Catalog getCatalog() {
        return this.catalog;
    }

    public BestRatedEpisodes getBestRatedEpisodesRanking() {
        return this.bestRatedEp;
    }

    public void updateBestRatedEpisodesRanking(Episode ep) {
        this.bestRatedEp.update(ep);
    }

    public BestRatedSeries getBestRatedSeriesRanking() {
        return this.bestRatedSer;
    }

    public void updateBestRatedSeriesRanking(Serie ser) {
        this.bestRatedSer.update(ser);
    }

    public MostViewedSeries getMostViewedSeriesRanking() {
        return this.mostViewedSer;
    }

    public void updateMostViewedSeriesRanking(Serie ser) {
        this.mostViewedSer.update(ser);
    }

}
