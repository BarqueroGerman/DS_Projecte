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
public class Serie {
    private String id;
    private String title;
    private String description;
    
    private ArrayList<Season> seasons;
    private Producer producer;
    private ArrayList<Artist> artists;
    private Catalog catalog;
    
    public Serie(String id, String title, String desc, Producer prod){
        this.id = id;
        this.title = title;
        this.description = desc;
        
        this.producer = prod;
        seasons = new ArrayList<>();
        artists = new ArrayList<>();
    }
    
    public Season getSeasonByNumber(int id){
        boolean found = false;
        Season toReturn = null;
        
        Iterator it = seasons.iterator();
        while(it.hasNext() && !found){
            toReturn = (Season)it.next();
            found = toReturn.checkNumber(id);
        }
        if(!found) return null;
        return toReturn;
    }
    
    public boolean checkId(String id){
        return this.id.equals(id);
    }
    
    public void addSeason(Season s){
        seasons.add(s);
    }
    
    public void addArtist(Artist a){
        this.artists.add(a);
    }
    
    @Override
    public String toString(){
        return this.id + "-" + this.title + "\n" + this.description;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setCatalog(Catalog c){
        this.catalog = c;
    }
    
    public void setProducer(Producer prod){
        this.producer = prod;
    }
}
