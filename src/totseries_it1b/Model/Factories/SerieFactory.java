/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Serie;

/**
 *
 * @author gbarquga9.alumnes
 */
public class SerieFactory extends AbstractFactory {

    public Serie create(String id, String title, String desc) {
        return new Serie(id, title, desc, null);
    }
}
