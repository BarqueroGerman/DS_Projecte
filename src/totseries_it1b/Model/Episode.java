/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    private ArrayList<View> views;
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
        views = new ArrayList<View>();
    }

    public void addView(View v) {
        views.add(v);
        v.setEpisode(this);
    }

    public boolean isRatedBy(Client client) {
        Iterator it = views.iterator();
        boolean rated = false;
        while (it.hasNext() && !rated) {
            View v = (View) it.next();
            rated = v.getRating() != null && v.getClient().compareUsername(client.getUsername());
        }
        return rated;
    }

    public void updateRating(Rating r) {
        ratingAverage = (ratingAverage * ratingCount + r.getValue()) / (ratingCount + 1);
        ratingCount += 1;
    }

    public boolean checkNumber(int n) {
        return this.number == n;
    }

    public String getNumAndTitle() {
        return this.number + " - " + this.title;
    }

    @Override
    public String toString() {
        String ratingStr = "0";
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        if (ratingAverage - (int) ratingAverage == 0) {
            ratingStr = Integer.toString((int) ratingAverage);
        } else {
            ratingStr = numberFormat.format(ratingAverage);
        }
        return number + " - " + title + " (" + ratingStr + "/5)\n" + description;
    }
    
    public double getRating(){
        return ratingAverage;
    }
}
