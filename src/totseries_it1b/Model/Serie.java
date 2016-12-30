/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class Serie implements Iterable<Season> {

    private String id;
    private String title;
    private String description;

    private ArrayList<Season> seasons;
    private Producer producer;
    private ArrayList<Artist> artists;
    private Catalog catalog;

    public Serie(String id, String title, String desc, Producer prod) {
        this.id = id;
        this.title = title;
        this.description = desc;

        this.producer = prod;
        seasons = new ArrayList<>();
        artists = new ArrayList<>();
    }

    public Season getSeasonByNumber(int id) {
        boolean found = false;
        Season toReturn = null;

        Iterator it = seasons.iterator();
        while (it.hasNext() && !found) {
            toReturn = (Season) it.next();
            found = toReturn.checkNumber(id);
        }
        if (!found) {
            return null;
        }
        return toReturn;
    }

    public boolean checkId(String id) {
        return this.id.equals(id);
    }

    public double getRatingAverage() {
        int num = 0;
        double sum = 0;
        for (Season season : this) {
            for (Episode e : season) {
                sum += e.getRatingAverage();
                num += 1;
            }
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
        for (Season season : this) {
            sum += season.getTotalViews();
        }
        return sum;
    }

    public void addSeason(Season s) {
        seasons.add(s);
    }

    public void addArtist(Artist a) {
        this.artists.add(a);
    }

    public String getSeasonsString() {
        String toReturn = "";
        Iterator it = seasons.iterator();
        while (it.hasNext()) {
            toReturn += ((Season) it.next()).toString() + "\n";
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return "[ID = " + this.id + "]  " + this.title + "\n       " + this.description;
    }

    public String getId() {
        return this.id;
    }

    public void setCatalog(Catalog c) {
        this.catalog = c;
    }

    public void setProducer(Producer prod) {
        this.producer = prod;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return artists.get(0).name;
    }

    public String getProducer() {
        return producer.getName();
    }

    @Override
    public Iterator<Season> iterator() {
        return this.seasons.iterator();
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
            id, title, Integer.toString(views), Double.toString(rating)
        };
    }
}
