/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import edu.ub.informatica.disseny.totseries.Consola;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import totseries_it1b.Controller.TSController;
import totseries_it1b.Model.Catalog;
import totseries_it1b.Model.Client;
import totseries_it1b.Model.Episode;
import totseries_it1b.Model.Season;
import totseries_it1b.Model.Serie;
import totseries_it1b.Model.User;
import totseries_it1b.Model.View;

/**
 * Classe que inicialitza el menu principal de TotSeries (Vista)
 *
 * @author Enric Calvo & German Barquero
 */
public class TSMenu {

    private TSController ctrl;
    private Consola console;

    public TSMenu() {
        ctrl = TSController.getInstance();
    }

    public TSMenu(TSController ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * Funcio que inicia el menu i totes les funcions previes necessaries.
     */
    public void init() {
        runRatingTest();
        showMenu();
    }

    /**
     * Afegeix valoracions a 9 episodes de breaking bad a mode de test.
     */
    private void runRatingTest() {
        ArrayList<Episode> episodes = new ArrayList<>();
        Client c1 = (Client) ctrl.getUserByUsername("atormenta");
        Client c2 = (Client) ctrl.getUserByUsername("dtomacal");
        Serie serie = ctrl.getCatalog().getSerieById("bbad");
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(1));
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(2));
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(3));
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(4));
        episodes.add(serie.getSeasonByNumber(2).getEpisodeByNumber(1));
        episodes.add(serie.getSeasonByNumber(2).getEpisodeByNumber(2));
        episodes.add(serie.getSeasonByNumber(2).getEpisodeByNumber(3));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(1));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(2));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(3));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(4));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(5));
        View v;
        for (Episode e : episodes) {
            ctrl.login(c1.getUsername(), c1.getPassword());
            v = ctrl.visualizeEpisode(e);
            ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(0, 6));

            ctrl.login(c2.getUsername(), c2.getPassword());
            v = ctrl.visualizeEpisode(e);
            ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(1, 6));
        }
        ctrl.logout();
    }

    /**
     * Inicia el bucle principal del programa, amb els menus corresponents.
     */
    private void showMenu() {
        int option1 = -1, option2 = -1;
        //Mentre no vulgui sortir del programa(4)
        while (option1 != 5) {
            //Obtenim instrucció
            option1 = showAnonymousMenu();
            //Tractem instrucció
            optionsAnonymousMenu(option1);
            while (ctrl.userIsClient()) {
                option2 = showClientMenu();
                optionsClientMenu(option2);
            }
        }
    }

    /**
     * Mostra el menu d'usuari anonim i retorna l'opcio escollida.
     *
     * @return option
     */
    private int showAnonymousMenu() {
        console.escriu("Welcome to TotSeries. Select an option, please:"
                + "\n(1)Login"
                + "\n(2)Register"
                + "\n(3)Consult catalog"
                + "\n(4)Show ranking"
                + "\n(5)Exit\n"
        );
        int option = console.llegeixInt();

        //Espera a tenir una instrucció vàlida
        while (option > 5 || option <= 0) {
            console.escriu("Opció no vàlida. Torni a escriure l'opcio desitjada.");
            option = console.llegeixInt();
        }
        return option;
    }

    /**
     * Mostra el menu de client i retorna la opcio escollida.
     *
     * @return option
     */
    private int showClientMenu() {
        console.escriu("Welcome dear client of TotSeries. Select an option, please:"
                + "\n(1)Consult catalog"
                + "\n(2)Show ranking"
                + "\n(3)Log out\n"
        );
        int option = console.llegeixInt();

        //Espera a tenir una instrucció vàlida
        while (option > 4 || option <= 0) {
            console.escriu("Opció no vàlida. Torni a escriure l'opcio desitjada.");
            option = console.llegeixInt();
        }
        return option;
    }

    /**
     * Rep l'opcio escollida per l'usuari anonim i realitza les accions
     * pertinents.
     *
     * @param option
     */
    private void optionsAnonymousMenu(int option) {
        switch (option) {
            case 1: // IDENTIFICARSE
                login();
                break;
            case 2: // REGISTRARSE
                register();
                break;
            case 3: // CONSULTAR CATÀLEG
                consultCatalog();
                break;
            case 4: // CONSULTAR CATÀLEG
                consultRanking();
                break;
        }
    }

    /**
     * Rep l'opcio escollida pel client i realitza les accions pertinents.
     *
     * @param option
     */
    private void optionsClientMenu(int option) {
        switch (option) {
            case 1: // CONSULTAR CATÀLEG
                consultCatalog();
                break;
            case 2: // CONSULTAR RANKING
                consultRanking();
                break;
            case 3: // LOGOUT
                logout();
                break;
        }
    }

    /**
     * Funcio que inicialitza la consulta del cataleg.
     */
    private void consultCatalog() {
        Catalog catalog = ctrl.getCatalog();
        chooseSerieFromCatalog(catalog);
    }

    /**
     * Funcio que mostra les series de la base de dades i gestiona la seleccio
     * d'una per part de l'usuari.
     *
     * @param catalog
     */
    private void chooseSerieFromCatalog(Catalog catalog) {
        String serieID = "";
        Serie serie;

        /* Per sortir, l'usuari ha d'entrar un -1 */
        while (!serieID.equals("-1")) {
            console.escriu(catalog.toString());
            console.escriu("\n  --> Write the ID of the serie that you want to watch (-1 to go back): ");
            serieID = console.llegeixString();

            // si ha entrat un id, busquem la serie corresponent
            if (!serieID.equals("-1")) {
                serie = catalog.getSerieById(serieID);
            } else {
                serie = null;
            }

            // si existeix la serie, passem a escollir temporada
            if (serie != null) {
                chooseSeasonFromSerie(serie);
            } else if (!serieID.equals("-1")) {
                // si ha introduit un id no valid
                console.escriu("Serie ID not valid.\n");
            }
        }
    }

    /**
     * Funcio que mostra les temporades d'una serie i gestiona la seleccio d'una
     * per part de l'usuari.
     *
     * @param serie
     */
    private void chooseSeasonFromSerie(Serie serie) {
        int seasonID = 0;
        Season season;

        /* Per sortir, l'usuari ha d'entrar un -1 */
        while (seasonID != -1) {
            console.escriu(serie.getSeasonsString());
            console.escriu("\n  --> Write the number of the season that you want to watch (-1 to go back): ");
            seasonID = console.llegeixInt();

            if (seasonID != -1) {
                season = serie.getSeasonByNumber(seasonID);
            } else {
                season = null;
            }

            if (season != null) {
                chooseEpisodeFromSeason(season);
            } else if (seasonID != -1) {
                console.escriu("Season number not valid.\n");
            }
        }
    }

    /**
     * Funcio que mostra els episodis d'una temporada d'una serie i gestiona la
     * seleccio d'un per part de l'usuari.
     *
     * @param season
     */
    private void chooseEpisodeFromSeason(Season season) {
        Episode episode;
        int episodeID = 0;

        /* Per sortir, l'usuari ha d'entrar un -1 */
        while (episodeID != -1) {
            console.escriu(season.getEpisodesString());
            console.escriu("\n  --> Write the number of the episode that you want to watch (-1 to go back): ");
            episodeID = console.llegeixInt();

            if (episodeID != -1) {
                episode = season.getEpisodeByNumber(episodeID);
            } else {
                episode = null;
            }

            if (episode != null) {
                showEpisodeFullInformation(episode);
            } else if (episodeID != -1) {
                console.escriu("Episode number not valid.\n");
            }
        }
    }

    /**
     * Funcio que mostra la informacio completa d'un episodi i si es client el
     * deixa visualitzarlo.
     *
     * @param episode
     */
    private void showEpisodeFullInformation(Episode episode) {
        int option;
        console.escriu(episode.toString());
        console.escriu("\n\n  --> What would you like to do now?");
        if (ctrl.userIsClient()) {
            console.escriu("\n  1. Watch the episode.");
        }
        console.escriu("\n  *. Go back.\n");
        option = console.llegeixInt();
        if (option == 1 && ctrl.userIsClient()) {
            visualizeEpisode(episode);
        }
    }

    /**
     * Visualitza l'episodi (si es client) i li dona l'opcio de valorarlo (si no
     * ho ha fet ja)
     *
     * @param episode
     */
    private void visualizeEpisode(Episode episode) {
        if (ctrl.userIsClient()) {
            View view = ctrl.visualizeEpisode(episode);
            console.escriu("The episode finished. Thanks for watching.\n");
            if (view != null && !episode.isRatedBy((Client) ctrl.getUserInSession())) {
                rateEpisode(view);
            }
        }
    }

    /**
     * Un cop visualitzat l'episodi, aquesta funcio demana a l'usuari una
     * valoracio.
     *
     * @param view
     */
    private void rateEpisode(View view) {
        console.escriu("Would you like to rate this episode? (y/*): ");
        if (console.llegeixString().toLowerCase().equals("y")) {
            console.escriu("Please, enter a number between 0 and 5: ");
            int rate = console.llegeixInt();
            while (rate < 0 || rate > 5) {
                console.escriu("The rate must be a number between 0 and 5. Please, write it again: ");
                rate = console.llegeixInt();
            }
            ctrl.rateEpisode(view, rate);
        }
    }

    /**
     * Mètode que demana les dades de registre a l'usuari i crea un client. Un
     * cop creat, es logueja automaticament.
     *
     * @return ok
     */
    private boolean register() {
        String username, pass, name, nationality, dateString;
        Calendar birthdate = Calendar.getInstance();

        console.escriu("Write your username: ");
        username = console.llegeixString();
        console.escriu("Write your password: ");
        pass = console.llegeixString();
        console.escriu("Write your name: ");
        name = console.llegeixString();
        console.escriu("Write your nationality: ");
        nationality = console.llegeixString();
        console.escriu("Write your birthdate (DD/MM/YYYY): ");
        dateString = console.llegeixString();

        boolean dateOk = false;
        Calendar date = Calendar.getInstance();
        while (!dateOk) {
            try {
                int year = Integer.parseInt(dateString.substring(dateString.lastIndexOf("/") + 1));
                int month = Integer.parseInt(dateString.substring(dateString.indexOf("/") + 1, dateString.lastIndexOf("/")));
                int day = Integer.parseInt(dateString.substring(0, dateString.indexOf("/")));
                date.set(year, month, day);
                dateOk = true;
            } catch (Exception ex) {
                console.escriu("Write your birthdate again with the format DD/MM/YYYY: ");
                dateString = console.llegeixString();
            }
        }
        while (!ctrl.createClient(username, pass, name, nationality, date)) {
            console.escriu("We are sorry, there is already someone with that username...");
            console.escriu("Write a different username, please: ");
            username = console.llegeixString();
        }
        console.escriu("Congratulations, you have been correctly registered in TotSeries.\n");
        return true;
    }

    /**
     * Mètode que demana les credencials a l'usuari i el logueja.
     */
    private void login() {
        boolean rightUsername = false;
        boolean rightPassword = false;
        String username, password;
        console.escriu("Please, write your username: ");
        username = console.llegeixString();
        rightUsername = ctrl.usernameExists(username);
        while (!rightUsername) {
            console.escriu("We are sorry, that username doesn't exists.\nPlease, try again: ");
            username = console.llegeixString();
            rightUsername = ctrl.usernameExists(username);
        }
        console.escriu("Please, write your password: ");
        password = console.llegeixString();
        rightPassword = ctrl.login(username, password);
        while (!rightPassword) {
            console.escriu("We are sorry, that password is incorrect.\nPlease, try again: ");
            password = console.llegeixString();
            rightPassword = ctrl.login(username, password);
        }
        console.escriu("Congratulations, you have been correctly logged in.\n");

    }

    /**
     * Funcio que desconecta a l'usuari de la sessio.
     */
    private void logout() {
        ctrl.logout();
        console.escriu("You have been correctly logged out.");
    }

    /**
     * Funcio que imprimeix el ranking dels 10 episodis millor valorats i permet
     * als clients visualitzarlos.
     */
    private void consultRanking() {
        ArrayList<Episode> ranks = new ArrayList<Episode>();
        ranks = ctrl.generateRank();
        if (ranks.size() > 0) {
            int count = 0;
            boolean done = false;
            while (!done) {
                Iterator it = ranks.iterator();
                while (it.hasNext()) {
                    count++;
                    console.escriu("[" + count + "] " + it.next().toString() + "\n");
                }
                if (ctrl.isLogged()) {
                    console.escriu("Select an epsiode:\n(-1)to go back\n");
                    int ep = console.llegeixInt();
                    if (ep != -1) {
                        while (ep <= 0 || ep > ranks.size()) {
                            console.escriu("You entered an invalid number of episode. Please, select an episode: ");
                            ep = console.llegeixInt();
                        }
                        showEpisodeFullInformation(ranks.get(ep - 1));
                    }
                }
                done = true;
                count = 0;
            }
        } else {
            console.escriu("There is not enough valorations of episodes to show a ranking.");
        }
    }

}
