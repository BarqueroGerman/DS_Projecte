/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.ArrayList;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public abstract class Artist {
    protected int id;
    protected String name;
    protected String nationality;
    
    protected ArrayList<Serie> series;
    
    public Artist(int id, String name, String nationality){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        series = new ArrayList<Serie>();
    }
    
    public void addSerie(Serie s){
        this.series.add(s);
    }
}
