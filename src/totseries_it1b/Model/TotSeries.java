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
public class TotSeries {

    private Catalog catalog;
    private UsersList userslist;

    public TotSeries() {
        this.catalog = new Catalog(this);
        userslist = new UsersList();
    }

    public boolean usernameRegistered(String username) {
        return userslist.getByUsername(username) != null;
    }

    public User getUserByUsername(String username) {
        return userslist.getByUsername(username);
    }

    public boolean addUser(User u) {
        if (!usernameRegistered(u.getUsername())) {
            this.userslist.add(u);
            return true;
        }
        return false;
    }

    public Catalog getCatalog() {
        return this.catalog;
    }
    
    public ArrayList<Episode> generateRank(){
        ArrayList<Episode> rank = new ArrayList<Episode>();
        boolean trobat = false;
        for(int i = 0;i<catalog.getNumSeries();i++){
            Serie serie = catalog.getSerie(i);
            
            for(int j = 0;j<serie.getNumSeasons();j++){
                Season season = serie.getSeason(j);
                
                for(int k = 0;k<season.getEpisodesCount();k++){                    
                    Episode episode = season.getEpisode(k);
                    double rating = episode.getRating();
                    
                    Iterator it = rank.iterator();
                    int index = 0;
                    while(it.hasNext() && !trobat){
                        if(((Episode)it.next()).getRating() <= rating){
                            rank.add(index, episode);
                            if(rank.size()>10){
                                rank.remove(rank.size()-1);
                            }
                            trobat = true;
                        }index++;
                    }
                    if(rank.size()==0){
                        rank.add(episode);
                    }trobat = false;
                }
            }
        }return rank;
    }
    
}

