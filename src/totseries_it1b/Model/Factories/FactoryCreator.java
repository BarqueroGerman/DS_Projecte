/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import java.util.logging.Level;
import java.util.logging.Logger;
import totseries_it1b.Model.Director;
import totseries_it1b.Model.Types.*;

/**
 *
 * @author gbarquga9.alumnes
 */
public class FactoryCreator<T> {

    public static <T extends AbstractFactory> T Create(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FactoryCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
