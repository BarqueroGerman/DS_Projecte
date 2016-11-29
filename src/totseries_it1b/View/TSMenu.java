/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import edu.ub.informatica.disseny.totseries.Consola;
import java.util.Calendar;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TSMenu {
    private TSController ctrl;
    private Consola console;
    
    public TSMenu(){
        ctrl = new TSController();
    }
    
    public TSMenu(TSController ctrl){
        this.ctrl = ctrl;
    }
    
    //Inici del programa
    public void init(){
        int option1 = -1;
        //Mentre no vulgui sortir del programa(4)
        while(option1 != 4){
            //Obtenim instrucció
            option1 = showFirstMenu();
            //Tractem instrucció
            optionsFirstMenu(option1);
        }
    }
    
    //Mostra el primer menu
    public int showFirstMenu(){
        console.escriu("Welcome to TotSeries. Select an option, please:"
                + "\n(1)Login"
                + "\n(2)Register"
                + "\n(3)Consult catalog"
                + "\n(4)Exit\n");
        int option = console.llegeixInt();
        
        //Espera a tenir una instrucció vàlida
        while(option > 4 || option <= 0){
            System.out.println("Opció no vàlida. Torni a escriure l'opcio desitjada.");
            option = console.llegeixInt();
        }
        return option;
    }
    
    public int showClientMenu(){
        console.escriu("Welcome,dear Client of TotSeries\nPress 4 to get the fuck out of here.");
        int option = console.llegeixInt();
        
        //Espera a tenir una instrucció vàlida
        while(option > 4 || option <= 0){
            System.out.println("Opció no vàlida. Torni a escriure l'opcio desitjada.");
            option = console.llegeixInt();
        }
        return option;
    }

    private void optionsFirstMenu(int option) {
        switch(option){
            case 1: // IDENTIFICARSE
                login();
                showClientMenu();
                break;
            case 2: // REGISTRARSE
                register();
                break;
            case 3: // CONSULTAR CATÀLEG
                consultCatalog();
                break;
        }
    }
    
    private void optionsClientMenu(int option) {
    }

    private void consultCatalog() {
        ctrl.consultCatalog();
    }

    private boolean register() {
        String username, pass, name, nationality, dateString;
        Calendar birthdate = Calendar.getInstance();
        
        console.escriu("Write your username:");
        username = console.llegeixString();
        console.escriu("Write your password:");
        pass = console.llegeixString();
        console.escriu("Write your name:");
        name = console.llegeixString();
        console.escriu("Write your nationality:");
        nationality = console.llegeixString();
        console.escriu("Write your birthdate (DD/MM/YYYY):");
        dateString = console.llegeixString();
        
        boolean dateOk = false;
        Calendar date = Calendar.getInstance();
        while(!dateOk){
            try{
                int year = Integer.parseInt(dateString.substring(dateString.lastIndexOf("/")+1));
                int month = Integer.parseInt(dateString.substring(dateString.indexOf("/")+1, dateString.lastIndexOf("/")));
                int day = Integer.parseInt(dateString.substring(0,dateString.indexOf("/")));
                date.set(year, month, day);
                dateOk = true;
            }catch(Exception ex){
                console.escriu("Write your birthdate again with the format DD/MM/YYYY:");
                dateString = console.llegeixString();
            }
        }
        while(!ctrl.createClient(username, pass, name, nationality, date)) {
            console.escriu("We are sorry, there is already someone with that username...");
            console.escriu("Write a different username, please:");
            username = console.llegeixString();
        }
        console.escriu("Congratulations, you have been correctly registered in TotSeries.");
        return true;
    }

    private void login() {
        boolean rightUsername = false;
        boolean rightPassword = false;
        String username, password;
        console.escriu("Please, write your username:");
        username = console.llegeixString();
        rightUsername = ctrl.usernameExists(username);
        while(!rightUsername){
            console.escriu("We are sorry, that username doesn't exists.\nPlease, try again:");
            username = console.llegeixString();
            rightUsername = ctrl.usernameExists(username);
        }
        console.escriu("Please, write your password:");
        password = console.llegeixString();
        rightPassword = ctrl.correctPassword(username,password);
        while(!rightPassword){
            console.escriu("We are sorry, that password is incorrect.\nPlease, try again:");
            password = console.llegeixString();
            rightPassword = ctrl.correctPassword(username,password);
        }console.escriu("Congratulations, you have been correctly logged in.\n");

    }
    
}
