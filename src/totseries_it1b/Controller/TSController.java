/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import totseries_it1b.Model.View;
import totseries_it1b.Model.AbstractView;
import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import totseries_it1b.Model.*;
import totseries_it1b.Model.Types.UserType;
import totseries_it1b.View.InitialScreen;
import totseries_it1b.View.RankingPanel;

/**
 * Controlador principal de l'aplicacio TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class TSController {

    /**
     * Database
     */
    private TotSeries totSeries;
    /**
     * User in session.
     */
    private User user;
    private static TSController instance;
    private String idCurrentSerie;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        // We initialize our database
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        TSController.getInstance(dataManager.getTotSeries());
        TSController.getInstance().runRatingTest();
        InitialScreen.init();
    }

    /**
     * Afegeix valoracions a 9 episodes de breaking bad a mode de test.
     */
    public void runRatingTest() {
        TSController ctrl = TSController.getInstance();
        ArrayList<Episode> episodes = new ArrayList<>();
        Client c1 = (Client) ctrl.getUserByUsername("atormenta");
        Client c2 = (Client) ctrl.getUserByUsername("dtomacal");
        View v;
        for (Serie serie : ctrl.getCatalog()) {
            for (Season season : serie) {
                for (Episode e : season) {
                    ctrl.login(c1.getUsername(), c1.getPassword());
                    v = ctrl.visualizeEpisode(e);
                    ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(0, 6));

                    ctrl.login(c2.getUsername(), c2.getPassword());
                    v = ctrl.visualizeEpisode(e);
                    ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(1, 6));
                }
            }
        }
        ctrl.logout();
    }

    private TSController() {
        this.totSeries = new TotSeries();
    }

    private TSController(TotSeries ts) {
        this.totSeries = ts;
    }

    public static TSController getInstance() {
        if (instance == null) {
            synchronized (BestRatedEpisodes.class) {
                if (instance == null) {
                    instance = new TSController();
                }
            }
        }
        return instance;
    }

    public static TSController getInstance(TotSeries TS) {
        if (instance == null) {
            synchronized (BestRatedEpisodes.class) {
                if (instance == null) {
                    instance = new TSController(TS);
                }
            }
        }
        return instance;
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
        if (username.equals("") || pass.equals("") || name.equals("") || nationality.equals("")) {
            added = false;
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
            totSeries.updateMostViewedSeriesRanking(e.getSerie());
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
    public void rateEpisode(AbstractView v, int rating) {
        if (userIsClient() && user == v.getUser() && !v.getEpisode().isRatedBy((Client) user)) {
            v.setRate(rating);
            Episode ep = v.getEpisode();
            totSeries.updateBestRatedEpisodesRanking(ep);
            totSeries.updateBestRatedSeriesRanking(ep.getSerie());
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
        return user != null && getUserInSessionType() == UserType.CLIENT;
    }

    /**
     * Funcio que retorna l'usuari en sessio.
     *
     * @return
     */
    public User getUserInSession() {
        return this.user;
    }

    public void linkMostViewedSeriesRanking(RankingPanel panel) {
        totSeries.getMostViewedSeriesRanking().addObserver(panel);
    }

    public void linkBestRatedSeriesRanking(RankingPanel panel) {
        totSeries.getBestRatedSeriesRanking().addObserver(panel);
    }

    public void linkBestRatedEpisodesRanking(RankingPanel panel) {
        totSeries.getBestRatedEpisodesRanking().addObserver(panel);
    }

    // GETTERS DE INFO CAP A VISTA
    public ArrayList<String[]> getInfoSeries() {
        ArrayList<String[]> infoSeries = new ArrayList<String[]>();
        for (Serie serie : totSeries.getCatalog()) {
            String[] infoSerie = {serie.getTitle(), serie.getId()};
            infoSeries.add(infoSerie);
        }
        return infoSeries;
    }
    
    public ArrayList<String[]> getInfoSeasons(String id) {
        Serie serie = totSeries.getCatalog().getSerieById(id);
        ArrayList<String[]> infoSeasons = new ArrayList<String[]>();
        for (Season season : serie) {
            String[] infoSeason = {Integer.toString(season.getNumSeason()), serie.getId()};
            infoSeasons.add(infoSeason);
        }
        return infoSeasons;
    }

    public ArrayList<String[]> getMostViewedSeries() {
        ArrayList<String[]> infoSeries = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeriesRanking()) {
            Serie serie = (Serie) obj;
            String[] infoSerie = {serie.getId(), serie.getTitle(), Integer.toString(serie.getTotalViews())};
            infoSeries.add(infoSerie);
        }
        return infoSeries;
    }

    public ArrayList<String[]> getBestRatedSeries() {
        ArrayList<String[]> infoSeries = new ArrayList<String[]>();
        for (Object obj : totSeries.getBestRatedSeriesRanking()) {
            Serie serie = (Serie) obj;
            String[] infoSerie = {serie.getId(), serie.getTitle(), Double.toString(serie.getRatingAverage())};
            infoSeries.add(infoSerie);
        }
        return infoSeries;
    }
    
    public void setIDCurrentSerie(String id){
        idCurrentSerie = id;
    }
    
    public String getIDCurrentSerie(){
        return idCurrentSerie;
    }
    
    public String getTitleCurrentSerie(){
        return totSeries.getCatalog().getSerieById(idCurrentSerie).getTitle();
    }
}
