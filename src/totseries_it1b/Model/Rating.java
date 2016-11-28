/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class Rating {
    private int value;
    
    private View view;
    
    public Rating(int v){
        this.value = v;
    }
    
    public void setView(View v){
        this.view = v;
    }
    
    public int getValue(){
        return this.value;
    }
}
