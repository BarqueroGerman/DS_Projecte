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
public class Producer {
    private String name;
    private int id;
    private int foundationYear;
    
    private ArrayList<Serie> series;
    
    public Producer(String n, int id, int year){
        this.name = n;
        this.id = id;
        this.foundationYear = year;
        
        series = new ArrayList<Serie>();
    }
    
    public void addSerie(Serie s){
        // TODO check if existent
        series.add(s);
    }
    
    public String getName(){
        return name;
    }
}
