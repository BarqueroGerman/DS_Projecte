/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import edu.ub.informatica.disseny.totseries.Consola;
import java.util.Calendar;
import totseries_it1b.Model.*;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TSController {

    private final static int ADMIN_TYPE = 0;
    private final static int CLIENT_TYPE = 1;

    private Consola console;
    /**
     * Database
     */
    private TotSeries totSeries;
    /**
     * User in session.
     */
    private User user;

    public TSController() {
        totSeries = new TotSeries();
        console = new Consola();
    }

    public TSController(TotSeries ts) {
        this.totSeries = ts;
    }

    public boolean createClient(String username, String pass, String name, String nationality, Calendar birthdate) {
        boolean added = false;
        if (!totSeries.usernameRegistered(username)) {
            user = new Client(username, pass, name, nationality, birthdate);
            added = totSeries.addUser(user);
        }
        return added;
    }

    public View visualizeEpisode(Episode e) {
        View v = null;
        if (userInSessionType() == CLIENT_TYPE) {
            v = new View();
            e.addView(v);
            ((Client) user).addView(v);
        }
        return v;
    }

    public boolean usernameExists(String user) {
        return totSeries.usernameRegistered(user);
    }

    public void setClientVIP(Client c, boolean VIP) {

    }

    public void rateEpisode(View v, int rating) {
        if (userInSessionType() == CLIENT_TYPE && !v.getEpisode().isRatedBy(v.getClient())) {
            v.setRate(rating);
        }
    }

    public boolean isLogged() {
        return user != null;
    }

    public boolean login(String username, String pass) {
        User u = totSeries.getUserByUsername(username);
        if (u != null && u.isPasswordCorrect(pass) && u instanceof Client) {
            user = u;
            return true;
        }
        return false;
    }

    public void logout() {
        this.user = null;
    }

    public Catalog getCatalog() {
        return totSeries.getCatalog();
    }

    public int userInSessionType() {
        if (user instanceof Admin) {
            return 0;
        } else if (user instanceof Client) {
            return 1;
        } else {
            return -1;
        }
    }

    public User getUserInSession() {
        return this.user;
    }
}
