/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import totseries_it1b.Model.*;
import totseries_it1b.Model.Factories.*;
import totseries_it1b.Model.Types.*;
import totseries_it1b.View.InitialScreen;
import totseries_it1b.View.Rankings.RankingPanel;

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

    /**
     * Afegeix valoracions a 9 episodes de breaking bad a mode de test.
     */
    public void runRatingTest() {
        TSController ctrl = TSController.getInstance();
        ArrayList<Episode> episodes = new ArrayList<>();
        Client c1 = (Client) ctrl.getUserByUsername("atormenta");
        Client c2 = (Client) ctrl.getUserByUsername("dtomacal");
        AbstractView v;
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
    public AbstractView visualizeEpisode(Episode e) {
        AbstractView v = null;
        if (userIsClient()) {
            ViewFactory fact = FactoryCreator.Create(ViewFactory.class);
            v = fact.create(e, (Client) user);
            totSeries.updateMostViewedSeriesRanking(e.getSerie());
            totSeries.updateMostViewedSeasonsRanking(e.getSeason());
            totSeries.updateMostViewedEpisodesRanking(e);
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
            totSeries.updateBestRatedSeasonsRanking(ep.getSeason());
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

    public void linkMostViewedSeasonsRanking(RankingPanel panel) {
        totSeries.getMostViewedSeasonsRanking().addObserver(panel);
    }

    public void linkMostViewedEpisodesRanking(RankingPanel panel) {
        totSeries.getMostViewedEpisodesRanking().addObserver(panel);
    }

    public void linkBestRatedSeriesRanking(RankingPanel panel) {
        totSeries.getBestRatedSeriesRanking().addObserver(panel);
    }

    public void linkBestRatedSeasonsRanking(RankingPanel panel) {
        totSeries.getBestRatedSeasonsRanking().addObserver(panel);
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
    
    public ArrayList<String[]> getInfoEpisodes(String id, int numSeason) {
        Serie serie = totSeries.getCatalog().getSerieById(id);
        Season season = serie.getSeasonByNumber(numSeason);
        ArrayList<String[]> infoEpisodes = new ArrayList<String[]>();
        for (Episode episode : season) {
            String[] infoEpisode = {episode.getTitle(), serie.getId(),Integer.toString(episode.getNumber()),episode.getDescription()};
            infoEpisodes.add(infoEpisode);
        }
        return infoEpisodes;
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
    
    public String getDescriptionSerie(String id){
        return totSeries.getCatalog().getSerieById(id).getDescription();
    }
    
    public String getDirector(String id){
        return totSeries.getCatalog().getSerieById(id).getDirector();
    }
    
    public String getProducer(String id){
        return totSeries.getCatalog().getSerieById(id).getProducer();
    }

    public ArrayList<String[]> getMostViewedSeasons() {
        ArrayList<String[]> infoSeasons = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeasonsRanking()) {
            Season season = (Season) obj;
            String[] infoSeason = {Integer.toString(season.getNumber()), Integer.toString(season.getTotalViews())};
            infoSeasons.add(infoSeason);
        }
        return infoSeasons;
    }

    public ArrayList<String[]> getBestRatedSeasons() {
        ArrayList<String[]> infoSeasons = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeasonsRanking()) {
            Season season = (Season) obj;
            String[] infoSeason = {Integer.toString(season.getNumber()), Double.toString(season.getRatingAverage())};
            infoSeasons.add(infoSeason);
        }
        return infoSeasons;
    }

    public ArrayList<String[]> getMostViewedEpisodes() {
        ArrayList<String[]> infoEpisodes = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeasonsRanking()) {
            Episode episode = (Episode) obj;
            String[] infoEpisode = {Integer.toString(episode.getNumber()), episode.getTitle(), Integer.toString(episode.getViewsCount())};
            infoEpisodes.add(infoEpisode);
        }
        return infoEpisodes;
    }

    public ArrayList<String[]> getBestRatedEpisodes() {
        ArrayList<String[]> infoEpisodes = new ArrayList<String[]>();
        for (Object obj : totSeries.getMostViewedSeasonsRanking()) {
            Episode episode = (Episode) obj;
            String[] infoEpisode = {Integer.toString(episode.getNumber()), episode.getTitle(), Double.toString(episode.getRatingAverage())};
            infoEpisodes.add(infoEpisode);
        }
        return infoEpisodes;
    }
    
    public String[] getEpisode(String id, int seas, int ep){
        Episode epi = totSeries.getCatalog().getSerieById(id).getSeasonByNumber(seas).getEpisodeByNumber(ep);
        String des =  epi.getDescription();
        String tit = epi.getTitle();
        String[] str = new String[2];
        str[0] = des;
        str[1] = tit;
        return str;        
    }
}
