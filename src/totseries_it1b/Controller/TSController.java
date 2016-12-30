/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;
import totseries_it1b.Model.*;
import totseries_it1b.Model.Factories.*;
import totseries_it1b.Model.Types.*;
import totseries_it1b.View.InitialScreen;
import totseries_it1b.View.Rankings.AbstractRankingPanel;

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

    public void runRatingTest() {
        TSController ctrl = TSController.getInstance();
        Client c1 = (Client) totSeries.getUserByUsername("atormenta");
        Client c2 = (Client) totSeries.getUserByUsername("dtomacal");
        int v;
        for (Serie serie : totSeries.getCatalog()) {
            for (Season season : serie) {
                for (Episode e : season) {
                    for (int i = ThreadLocalRandom.current().nextInt(0, 7); i < 10; i++) {
                        ctrl.login(c1.getUsername(), c1.getPassword());
                        v = ctrl.visualizeEpisode(serie.getId(), season.getNumSeason(), e.getNumber());
                        if (ThreadLocalRandom.current().nextInt(0, 4) > 2) {
                            ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(0, 6));
                        }
                    }
                    for (int i = ThreadLocalRandom.current().nextInt(0, 8); i < 10; i++) {
                        ctrl.login(c2.getUsername(), c2.getPassword());
                        v = ctrl.visualizeEpisode(serie.getId(), season.getNumSeason(), e.getNumber());
                        if (ThreadLocalRandom.current().nextInt(0, 4) > 2) {
                            ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(1, 6));
                        }
                    }
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
            synchronized (TSController.class) {
                if (instance == null) {
                    instance = new TSController();
                }
            }
        }
        return instance;
    }

    public static TSController getInstance(TotSeries TS) {
        if (instance == null) {
            synchronized (TSController.class) {
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
            ClientFactory fact = FactoryCreator.Create(ClientFactory.class);
            user = fact.create(username, pass, name, nationality, birthdate, false);
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
    public int visualizeEpisode(String serieId, int numSeason, int episodeId) {
        int viewId = -1;
        if (userIsClient()) {
            ViewFactory fact = FactoryCreator.Create(ViewFactory.class);
            Episode e = totSeries.getCatalog().getSerieById(serieId).getSeasonByNumber(numSeason).getEpisodeByNumber(episodeId);
            AbstractView v = fact.create(e, (Client) user);
            viewId = v.getId();
            totSeries.updateMostViewedSeriesRanking(e.getSerie());
            totSeries.updateMostViewedSeasonsRanking(e.getSeason());
            totSeries.updateMostViewedEpisodesRanking(e);
        }
        return viewId;
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
     * Metode que afegeix una valoracio a una visualitzacio (si es client i no
     * l'ha valorat encara)
     *
     * @param v
     * @param rating
     */
    public void rateEpisode(int viewId, int rating) {
        AbstractView v = user.findViewById(viewId);
        if (v != null && userIsClient() && user == v.getUser() && !v.getEpisode().isRatedBy((Client) user)) {
            v.setRate(rating);
            Episode ep = v.getEpisode();
            totSeries.updateBestRatedEpisodesRanking(ep);
            totSeries.updateBestRatedSeasonsRanking(ep.getSeason());
            totSeries.updateBestRatedSeriesRanking(ep.getSerie());
        }
    }

    public void rateEpisodeByAdmin(String serieId, int numSeason, int episodeId, int rating, int count) {
        for (int i = 0; i < count; i++) {
            ViewFactory fact = FactoryCreator.Create(ViewFactory.class);
            Episode e = totSeries.getCatalog().getSerieById(serieId).getSeasonByNumber(numSeason).getEpisodeByNumber(episodeId);
            AbstractView v = fact.create(e, user, true);
            v.setRate(rating);
            totSeries.updateBestRatedEpisodesRanking(e);
            totSeries.updateBestRatedSeasonsRanking(e.getSeason());
            totSeries.updateBestRatedSeriesRanking(e.getSerie());
            totSeries.updateMostViewedSeriesRanking(e.getSerie());
            totSeries.updateMostViewedSeasonsRanking(e.getSeason());
            totSeries.updateMostViewedEpisodesRanking(e);
        }
    }

    public int getClientRateOfEpisode(String serieId, int numSeason, int epId) {
        if (userIsClient()) {
            Episode e = totSeries.getCatalog().getSerieById(serieId).getSeasonByNumber(numSeason).getEpisodeByNumber(epId);
            return e.getRateByClient((Client) user);
        }
        return -1;
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
        if (u != null && u.isPasswordCorrect(pass)) {
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
     * Retorna 0 si l'usuari en sessio es Admin o 1 si es Client.
     *
     * @return
     */
    private int getUserInSessionType() {
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
     * Funcio que retorna true si l'usuari en sessio es un client.
     *
     * @return
     */
    public boolean userIsAdmin() {
        return user != null && getUserInSessionType() == UserType.ADMIN;
    }

    public void linkMostViewedSeriesRanking(Observer panel) {
        totSeries.getMostViewedSeriesRanking().addObserver(panel);
    }

    public void linkMostViewedSeasonsRanking(Observer panel) {
        totSeries.getMostViewedSeasonsRanking().addObserver(panel);
    }

    public void linkMostViewedEpisodesRanking(Observer panel) {
        totSeries.getMostViewedEpisodesRanking().addObserver(panel);
    }

    public void linkBestRatedSeriesRanking(Observer panel) {
        totSeries.getBestRatedSeriesRanking().addObserver(panel);
    }

    public void linkBestRatedSeasonsRanking(Observer panel) {
        totSeries.getBestRatedSeasonsRanking().addObserver(panel);
    }

    public void linkBestRatedEpisodesRanking(Observer panel) {
        totSeries.getBestRatedEpisodesRanking().addObserver(panel);
    }

    // GETTERS DE INFO CAP A VISTA
    public ArrayList<String[]> getInfoSeries() {
        ArrayList<String[]> infoSeries = new ArrayList<String[]>();
        for (Serie serie : totSeries.getCatalog()) {
            infoSeries.add(serie.parse(false, false));
        }
        return infoSeries;
    }

    public ArrayList<String[]> getInfoSeasonsBySerieId(String id) {
        Serie serie = totSeries.getCatalog().getSerieById(id);
        ArrayList<String[]> infoSeasons = new ArrayList<String[]>();
        for (Season season : serie) {
            infoSeasons.add(season.parse(false, false));
        }
        return infoSeasons;
    }

    public ArrayList<String[]> getInfoEpisodesBySeasonId(String id, int numSeason) {
        Serie serie = totSeries.getCatalog().getSerieById(id);
        Season season = serie.getSeasonByNumber(numSeason);
        ArrayList<String[]> infoEpisodes = new ArrayList<String[]>();
        for (Episode episode : season) {
            infoEpisodes.add(episode.parse(false, false));
        }
        return infoEpisodes;
    }

    public String getDescriptionSerie(String id) {
        return totSeries.getCatalog().getSerieById(id).getDescription();
    }

    public String getDirector(String id) {
        return totSeries.getCatalog().getSerieById(id).getDirector();
    }

    public String getProducer(String id) {
        return totSeries.getCatalog().getSerieById(id).getProducer();
    }

    public ArrayList<String[]> getMostViewedSeries() {
        ArrayList<String[]> infoSeries = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeriesRanking()) {
            Serie serie = (Serie) obj;
            infoSeries.add(serie.parse(true, false));
        }
        return infoSeries;
    }

    public ArrayList<String[]> getBestRatedSeries() {
        ArrayList<String[]> infoSeries = new ArrayList<String[]>();
        for (Object obj : totSeries.getBestRatedSeriesRanking()) {
            Serie serie = (Serie) obj;
            infoSeries.add(serie.parse(false, true));
        }
        return infoSeries;
    }

    public ArrayList<String[]> getMostViewedSeasons() {
        ArrayList<String[]> infoSeasons = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeasonsRanking()) {
            Season season = (Season) obj;
            infoSeasons.add(season.parse(true, false));
        }
        return infoSeasons;
    }

    public ArrayList<String[]> getBestRatedSeasons() {
        ArrayList<String[]> infoSeasons = new ArrayList<String[]>();
        for (Object obj : totSeries.getBestRatedSeasonsRanking()) {
            Season season = (Season) obj;
            infoSeasons.add(season.parse(false, true));
        }
        return infoSeasons;
    }

    public ArrayList<String[]> getMostViewedEpisodes() {
        ArrayList<String[]> infoEpisodes = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedEpisodesRanking()) {
            Episode episode = (Episode) obj;
            infoEpisodes.add(episode.parse(true, false));
        }
        return infoEpisodes;
    }

    public ArrayList<String[]> getBestRatedEpisodes() {
        ArrayList<String[]> infoEpisodes = new ArrayList<String[]>();
        for (Object obj : totSeries.getBestRatedEpisodesRanking()) {
            Episode episode = (Episode) obj;
            infoEpisodes.add(episode.parse(false, true));
        }
        return infoEpisodes;
    }

    public String getImagePathBySerieId(String id) {
        return SerieImagePath.getImagePath(id);
    }
}
