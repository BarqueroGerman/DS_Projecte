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
public class Catalog implements Iterable<Serie> {

    private TotSeries totSeries;
    private ArrayList<Serie> series;

    public Catalog(TotSeries totSeries) {
        series = new ArrayList<>();
        this.totSeries = totSeries;
    }

    public Serie getSerieById(String id) {
        boolean found = false;
        Serie toReturn = null;

        Iterator it = series.iterator();
        while (it.hasNext() && !found) {
            toReturn = (Serie) it.next();
            found = toReturn.checkId(id);
        }
        if (!found) {
            return null;
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "";
        Iterator it = series.iterator();
        while (it.hasNext()) {
            toReturn += ((Serie) it.next()).toString() + "\n";
        }
        return toReturn;
    }

    public boolean addSerie(Serie serie) {
        if (getSerieById(serie.getId()) != null) {
            return false;
        }
        this.series.add(serie);
        serie.setCatalog(this);
        return true;
    }

    public int getNumSeries() {
        return series.size();
    }

    public Serie getSerie(int i) {
        return series.get(i);
    }

    @Override
    public Iterator<Serie> iterator() {
        return this.series.iterator();
    }
}
