/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import edu.ub.informatica.disseny.totseries.Consola;
import java.util.ArrayList;
import java.util.Calendar;
import totseries_it1b.Model.*;

/**
 * Controlador principal de l'aplicacio TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class TSController {

    private final static int ADMIN_TYPE = 0;
    private final static int CLIENT_TYPE = 1;

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
    }

    public TSController(TotSeries ts) {
        this.totSeries = ts;
    }

    /**
     * Mètode que registra un client amb la informacio passada com a parametre.
     * Si ja existeix usuari amb aquell username, no el crea i retorna false.
     *
     * @param username
     * @param pass
     * @param name
     * @param nationality
     * @param birthdate
     * @return
     */
    public boolean createClient(String username, String pass, String name, String nationality, Calendar birthdate) {
        boolean added = false;
        if (!totSeries.usernameRegistered(username)) {
            user = new Client(username, pass, name, nationality, birthdate);
            added = totSeries.addUser(user);
        }
        return added;
    }

    /**
     * Metode que crea una visualitzacio per l'episodi amb el client en sessio.
     * Si no es client no es crea.
     *
     * @param e
     * @return
     */
    public View visualizeEpisode(Episode e) {
        View v = null;
        if (userIsClient()) {
            v = new View();
            e.addView(v);
            ((Client) user).addView(v);
        }
        return v;
    }

    /**
     * Mètode que retorna true si l'username ja esta agafat i false sino.
     *
     * @param user
     * @return
     */
    public boolean usernameExists(String user) {
        return totSeries.usernameRegistered(user);
    }

    /**
     * NO IMPLEMENTADA
     *
     * @param c
     * @param VIP
     */
    public void setClientVIP(Client c, boolean VIP) {
        // NO IMPLEMENTAT
    }

    /**
     * Metode que afegeix una valoracio a una visualitzacio (si es client i no
     * l'ha valorat encara)
     *
     * @param v
     * @param rating
     */
    public void rateEpisode(View v, int rating) {
        if (userIsClient() && user == v.getClient() && !v.getEpisode().isRatedBy((Client) user)) {
            v.setRate(rating);
        }
    }

    /**
     * Retorna true si hi ha algu loguejat.
     *
     * @return
     */
    public boolean isLogged() {
        return user != null;
    }

    /**
     * Funcio que comprova que username i pass siguin correctes i logueja
     * l'usuari.
     *
     * @param username
     * @param pass
     * @return
     */
    public boolean login(String username, String pass) {
        User u = totSeries.getUserByUsername(username);
        if (u != null && u.isPasswordCorrect(pass) && u instanceof Client) {
            user = u;
            return true;
        }
        return false;
    }

    /**
     * Funcio que desconecta l'usuari de la sessio.
     */
    public void logout() {
        this.user = null;
    }

    /**
     * Getter del cataleg de TotSeries.
     *
     * @return
     */
    public Catalog getCatalog() {
        return totSeries.getCatalog();
    }

    /**
     * Funcio que genera el top 10 episodis millor valorats.
     *
     * @return
     */
    public ArrayList<Episode> generateRank() {
        return totSeries.generateRank(10);
    }

    /**
     * Retorna l'usuari amb el nom d'usuari passat com a parametre. null si no
     * n'hi ha cap
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        return totSeries.getUserByUsername(username);
    }

    /**
     * Retorna 0 si l'usuari en sessio es Admin o 1 si es Client.
     *
     * @return
     */
    public int getUserInSessionType() {
        if (user != null && user instanceof Admin) {
            return 0;
        } else if (user != null && user instanceof Client) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Funcio que retorna true si l'usuari en sessio es un client.
     *
     * @return
     */
    public boolean userIsClient() {
        return user != null && getUserInSessionType() == CLIENT_TYPE;
    }

    /**
     * Funcio que retorna l'usuari en sessio.
     *
     * @return
     */
    public User getUserInSession() {
        return this.user;
    }
}
