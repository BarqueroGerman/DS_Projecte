/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class View {

    private Calendar date;
    private boolean active;

    private Client client;
    private Rating rating;
    private Episode episode;

    public View() {
        this.date = Calendar.getInstance();
        active = false; // In our system, the episode is instantly watched, so not active in any moment.
    }

    public void setRate(int rate) {
        this.rating = new Rating(rate);
        episode.updateRating(rating);
    }

    public void setRate(Rating rating) {
        this.rating = rating;
        episode.updateRating(rating);
    }

    public Rating getRating() {
        return this.rating;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client c) {
        this.client = c;
    }

    public Episode getEpisode() {
        return this.episode;
    }

    public void setEpisode(Episode e) {
        this.episode = e;
    }

}
