/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import totseries_it1b.Model.Rankings.BestRatedSeasons;
import totseries_it1b.Model.Rankings.MostViewedSeries;
import totseries_it1b.Model.Rankings.BestRatedSeries;
import totseries_it1b.Model.Rankings.BestRatedEpisodes;
import totseries_it1b.Model.Rankings.MostViewedSeasons;
import totseries_it1b.Model.Rankings.MostViewedEpisodes;
import totseries_it1b.Model.Factories.CatalogFactory;
import totseries_it1b.Model.Factories.FactoryCreator;
import totseries_it1b.Model.Factories.RankingsFactory;
import totseries_it1b.Model.Factories.UsersListFactory;
import totseries_it1b.Model.Types.RankingType;

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
        CatalogFactory catFact = FactoryCreator.Create(CatalogFactory.class);
        this.catalog = catFact.create();

        UsersListFactory usersFact = FactoryCreator.Create(UsersListFactory.class);
        userslist = usersFact.create();

        int num = 10;
        RankingsFactory rankFact = FactoryCreator.Create(RankingsFactory.class);
        bestRatedEp = (BestRatedEpisodes) rankFact.create(RankingType.BEST_RATED_EPISODES, num);
        bestRatedSeas = (BestRatedSeasons) rankFact.create(RankingType.BEST_RATED_SEASONS, num);
        bestRatedSer = (BestRatedSeries) rankFact.create(RankingType.BEST_RATED_SERIES, num);
        mostViewedEp = (MostViewedEpisodes) rankFact.create(RankingType.MOST_VIEWED_EPISODES, num);
        mostViewedSeas = (MostViewedSeasons) rankFact.create(RankingType.MOST_VIEWED_SEASONS, num);
        mostViewedSer = (MostViewedSeries) rankFact.create(RankingType.MOST_VIEWED_SERIES, num);
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
