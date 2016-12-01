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
    private UsersList userslist;

    public TotSeries() {
        this.catalog = new Catalog(this);
        userslist = new UsersList();
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
     * Genera una llista ordenada dels "num" millor valorats episodis (TOP num).
     *
     * @param num
     * @return
     */
    public ArrayList<Episode> generateRank(int num) {
        ArrayList<Episode> rank = new ArrayList<Episode>();
        boolean added = false;
        for (int i = 0; i < catalog.getNumSeries(); i++) {
            Serie serie = catalog.getSerie(i);
            for (int j = 0; j < serie.getNumSeasons(); j++) {
                Season season = serie.getSeason(j);
                for (int k = 0; k < season.getEpisodesCount(); k++) {
                    Episode episode = season.getEpisode(k);
                    // Busquem la posicio que li tocaria segons el rating i l'afegim.
                    double rating = episode.getRatingAverage();
                    // Nomes si el rating > 0
                    if (rating > 0) {
                        added = false;
                        int index = 0;
                        // Busquem la posicio on tocaria posarlo.
                        while (index < rank.size() && !added) {
                            double ep = rank.get(index).getRatingAverage();
                            if (ep <= rating) {
                                rank.add(index, episode);
                                if (rank.size() > num) {
                                    rank.remove(rank.size() - 1);
                                }
                                added = true;
                            }
                            index++;
                        }
                        // Si no hem trobat la seva posicio i hi ha lloc a la llista l'afegim al final.
                        if (rank.size() < num && !added) {
                            rank.add(rank.size(), episode);
                        }
                    }
                }
            }
        }
        return rank;
    }

}
