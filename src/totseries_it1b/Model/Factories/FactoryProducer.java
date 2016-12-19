/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Types.*;

/**
 *
 * @author gbarquga9.alumnes
 */
public class FactoryProducer {
    
    public AbstractFactory getFactory(int type){
        AbstractFactory factory = null;
        switch(type){
            case FactoryType.USER:
                break;
        }
        return factory;
    }
}
