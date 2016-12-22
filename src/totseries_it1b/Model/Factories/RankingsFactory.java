/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.BestRatedEpisodes;
import totseries_it1b.Model.BestRatedSeasons;
import totseries_it1b.Model.BestRatedSeries;
import totseries_it1b.Model.MostViewedEpisodes;
import totseries_it1b.Model.MostViewedSeasons;
import totseries_it1b.Model.MostViewedSeries;
import totseries_it1b.Model.Ranking;
import totseries_it1b.Model.Types.RankingType;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class RankingsFactory extends AbstractFactory {

    public Ranking create(int type, int num) {
        Ranking ranking = null;
        switch (type) {
            case RankingType.BEST_RATED_EPISODES:
                ranking = new BestRatedEpisodes(num);
                break;
            case RankingType.BEST_RATED_SEASONS:
                ranking = new BestRatedSeasons(num);
                break;
            case RankingType.BEST_RATED_SERIES:
                ranking = new BestRatedSeries(num);
                break;
            case RankingType.MOST_VIEWED_EPISODES:
                ranking = new MostViewedEpisodes(num);
                break;
            case RankingType.MOST_VIEWED_SEASONS:
                ranking = new MostViewedSeasons(num);
                break;
            case RankingType.MOST_VIEWED_SERIES:
                ranking = new MostViewedSeries(num);
                break;

        }
        return ranking;
    }

}