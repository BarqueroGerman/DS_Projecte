/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.Calendar;
import totseries_it1b.Model.Factories.FactoryCreator;
import totseries_it1b.Model.Factories.RatingFactory;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public abstract class AbstractView {

    private static int counter = 0;

    private int id;
    private Calendar date;
    private boolean active;

    private User user;
    private Rating rating;
    private Episode episode;

    public AbstractView() {
        this.date = Calendar.getInstance();
        this.id = counter;
        counter++;
        active = false; // In our system, the episode is instantly watched, so not active in any moment.
    }

    public void setRate(int rate) {
        RatingFactory fact = FactoryCreator.Create(RatingFactory.class);
        this.rating = fact.create(rate);
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

    public boolean checkId(int id) {
        return this.id == id;
    }

    public int getId() {
        return this.id;
    }

}
