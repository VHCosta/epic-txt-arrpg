package org.academiadecodigo.cachealots.epic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.HashMap;
import java.util.Map;

public class Histouria {

        private final Prompt epicPrompt;
        private final Map<String, Integer> accounts;

    public Histouria() {

        epicPrompt = new Prompt(System.in, System.out);

        accounts = new HashMap<>();

    }

    public void start(){

        //menu
        //  -login
        //  -register

        String[] menuOptions = {"Login", "Register"};

        MenuInputScanner epicMenu = new MenuInputScanner(menuOptions);

        epicMenu.setMessage("Welcome to the most EPIC game you will ever play!!!1\n" +
                "\n" +
                "Please joint our forces...");

        Integer action = epicPrompt.getUserInput(epicMenu);

        if(action == 1) login(); else register();
        //-register
        //  username
        //  password
        //

    }

    private void login(){


    }

    private void register(){

        //scanner: username
        //scanner: password
        StringInputScanner askUsername = new StringInputScanner();
        PasswordInputScanner askPassword = new PasswordInputScanner();

        askUsername.setMessage("Choose your username: ");
        askPassword.setMessage("Choose a password: ");


        //save in map
        String username = epicPrompt.getUserInput(askUsername);  //username as String
        int password = epicPrompt.getUserInput(askPassword).hashCode(); //password as hashcode; might replace with String if problems;

        accounts.put(username, password);







    }



}
