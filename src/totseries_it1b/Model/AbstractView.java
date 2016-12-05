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
public abstract class AbstractView {

    private Calendar date;
    private boolean active;

    private User user;
    private Rating rating;
    private Episode episode;

    public AbstractView() {
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public Episode getEpisode() {
        return this.episode;
    }

    public void setEpisode(Episode e) {
        this.episode = e;
    }

}
