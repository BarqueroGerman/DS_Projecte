/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class Season implements Iterable<Episode> {

    private int number;

    private Serie serie;
    private ArrayList<Episode> episodes;

    public Season(Serie serie, int num) {
        this.serie = serie;
        this.number = num;
        episodes = new ArrayList<>();
    }

    public Episode getEpisodeByNumber(int n) {
        boolean found = false;
        Episode toReturn = null;

        Iterator it = episodes.iterator();
        while (it.hasNext() && !found) {
            toReturn = (Episode) it.next();
            found = toReturn.checkNumber(n);
        }
        if (!found) {
            return null;
        }
        return toReturn;
    }

    public boolean checkNumber(int n) {
        return this.number == n;
    }

    public double getRatingAverage() {
        int num = 0;
        double sum = 0;
        for (Episode e : this) {
            sum += e.getRatingAverage();
            num += 1;
        }
        return sum / num;
    }

    public double getRoundedRatingAverage() {
        String ratingStr = "0";
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double ratingAverage = getRatingAverage();
        if (ratingAverage - (int) ratingAverage == 0) {
            ratingStr = Integer.toString((int) ratingAverage);
        } else if (ratingAverage < 1) {
            ratingStr = "0" + numberFormat.format(ratingAverage);
        } else {
            ratingStr = numberFormat.format(ratingAverage);
        }

        ratingStr = ratingStr.replace(",", ".");
        return Double.parseDouble(ratingStr);
    }

    public int getTotalViews() {
        int sum = 0;
        for (Episode e : this) {
            sum += e.getViewsCount();
        }
        return sum;
    }

    public int getEpisodesCount() {
        return this.episodes.size();
    }

    public void addEpisode(Episode e) {
        this.episodes.add(e);
    }

    public int getNumSeason() {
        return this.number;
    }

    public Serie getSerie() {
        return this.serie;
    }

    @Override
    public Iterator<Episode> iterator() {
        return this.episodes.iterator();
    }

    public String[] parse(boolean addViews, boolean addRating) {
        double rating = 0;
        int views = 0;
        if (addRating) {
            rating = getRoundedRatingAverage();
        }
        if (addViews) {
            views = getTotalViews();
        }
        return new String[]{
            serie.getId(), serie.getTitle(), Integer.toString(number), Integer.toString(views), Double.toString(rating)
        };
    }
}
