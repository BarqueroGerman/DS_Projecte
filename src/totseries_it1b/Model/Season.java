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
public class Season {
    private int number;
    
    private Serie serie;
    private ArrayList<Episode> episodes;
    
    public Season(Serie serie, int num){
        this.serie = serie;
        this.number = num;
        episodes = new ArrayList<>();
    }
    
    public Episode getEpisodeByNumber(int n){
        boolean found = false;
        Episode toReturn = null;
        
        Iterator it = episodes.iterator();
        while(it.hasNext() && !found){
            toReturn = (Episode)it.next();
            found = toReturn.checkNumber(n);
        }
        if(!found) return null;
        return toReturn;
    }
    
    public boolean checkNumber(int n){
        return this.number == n;
    }
    
    public int getEpisodesCount(){
        return this.episodes.size();
    }
    
    public void addEpisode(Episode e){
        this.episodes.add(e);
    }
    
    @Override
    public String toString(){
        return "Season " + number;
    }
}
