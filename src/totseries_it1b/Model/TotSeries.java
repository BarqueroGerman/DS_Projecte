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
    /**
     * RANKINGS
     */
    private BestRatedEpisodes bestRatedEp;
    private BestRatedSeasons bestRatedSeas;
    private BestRatedSeries bestRatedSer;
    private MostViewedSeries mostViewedSer;
    private MostViewedSeasons mostViewedSeas;
    private MostViewedEpisodes mostViewedEp;

    private UsersList userslist;

    public TotSeries() {
        this.catalog = new Catalog(this);
        userslist = new UsersList();

        bestRatedEp = new BestRatedEpisodes(10);
        bestRatedSeas = new BestRatedSeasons(10);
        bestRatedSer = new BestRatedSeries(10);
        mostViewedEp = new MostViewedEpisodes(10);
        mostViewedSeas = new MostViewedSeasons(10);
        mostViewedSer = new MostViewedSeries(10);
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

    /**
     * RANKING RELATED
     *
     * @return
     */
    public BestRatedEpisodes getBestRatedEpisodesRanking() {
        return this.bestRatedEp;
    }

    public void updateBestRatedEpisodesRanking(Episode ep) {
        this.bestRatedEp.update(ep);
    }

    public BestRatedSeasons getBestRatedSeasonsRanking() {
        return this.bestRatedSeas;
    }

    public void updateBestRatedSeasonsRanking(Season s) {
        this.bestRatedSeas.update(s);
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

    public MostViewedSeasons getMostViewedSeasonsRanking() {
        return this.mostViewedSeas;
    }

    public void updateMostViewedSeasonsRanking(Season s) {
        this.mostViewedSeas.update(s);
    }

    public MostViewedEpisodes getMostViewedEpisodesRanking() {
        return this.mostViewedEp;
    }

    public void updateMostViewedEpisodesRanking(Episode ep) {
        this.mostViewedEp.update(ep);
    }

}
