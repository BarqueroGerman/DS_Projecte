/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import java.util.Calendar;
import totseries_it1b.Model.Episode;
import totseries_it1b.Model.Season;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class EpisodeFactory extends AbstractFactory {

    public Episode create(Season season, int num, String title, String desc, String duration, String lang, Calendar date) {
        return new Episode(season, num, title, desc, duration, lang, date);
    }
}
