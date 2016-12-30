/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class Episode {

    private int number;
    private String title;
    private String description;
    private String length;
    private String originalLanguage;
    private Calendar releaseDate;
    private double ratingAverage;
    private int ratingCount;

    private ArrayList<AbstractView> views;
    private Season season;

    public Episode(Season season, int num, String title, String desc, String length, String lang, Calendar date) {
        this.season = season;
        this.number = num;
        this.title = title;
        this.description = desc;
        this.length = length;
        this.originalLanguage = lang;
        this.releaseDate = date;
        this.ratingAverage = 0;
        this.ratingCount = 0;
        views = new ArrayList<AbstractView>();
    }

    public void addView(AbstractView v) {
        views.add(v);
        v.setEpisode(this);
    }

    public boolean isRatedBy(Client client) {
        return getRateByClient(client) != -1;
    }

    public int getRateByClient(Client client) {
        int rating = -1;
        Iterator it = views.iterator();
        boolean rated = false;
        while (it.hasNext() && !rated) {
            AbstractView v = (AbstractView) it.next();
            if (v.getRating() != null && v.getUser().compareUsername(client.getUsername())) {
                rating = v.getRating().getValue();
            }
        }
        return rating;
    }

    public void updateRating(Rating r) {
        ratingAverage = (ratingAverage * ratingCount + r.getValue()) / (ratingCount + 1);
        ratingCount += 1;
    }

    public boolean checkNumber(int n) {
        return this.number == n;
    }

    public double getRatingAverage() {
        return ratingAverage;
    }

    public double getRoundedRatingAverage() {
        String ratingStr = "0";
        DecimalFormat numberFormat = new DecimalFormat("#.00");
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

    public int getViewsCount() {
        return this.views.size();
    }

    public Serie getSerie() {
        return this.season.getSerie();
    }

    public Season getSeason() {
        return this.season;
    }

    public int getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] parse(boolean addViews, boolean addRating) {
        double rating = 0;
        int views = 0;
        if (addRating) {
            rating = getRoundedRatingAverage();
        }
        if (addViews) {
            views = getViewsCount();
        }
        return new String[]{
            season.getSerie().getId(), season.getSerie().getTitle(), Integer.toString(season.getNumSeason()), title, Integer.toString(number), description, Integer.toString(views), Double.toString(rating)
        };
    }
}
