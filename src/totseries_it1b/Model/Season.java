/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

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

    public String getEpisodesString() {
        String toReturn = "";
        Iterator it = episodes.iterator();
        while (it.hasNext()) {
            toReturn += ((Episode) it.next()).getNumAndTitle() + "\n";
        }
        return toReturn;
    }
    
    public int getNumSeason(){
        return this.number;
    }

    public Serie getSerie() {
        return this.serie;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "Season " + number;
    }

    @Override
    public Iterator<Episode> iterator() {
        return this.episodes.iterator();
    }
}
