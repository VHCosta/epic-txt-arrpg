package org.academiadecodigo.cachealots.epic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Histouria {

        private final Prompt epicPrompt;
        private final Map<String, Integer> accounts;
        private BufferedWriter writer;
        private BufferedReader reader;
        private final String savedAccounts;

    public Histouria() throws IOException {

        epicPrompt = new Prompt(System.in, System.out);

        savedAccounts = "resources/savedAccounts.txt";

        accounts = new HashMap<>();

        loadContent();
    }

    private void loadContent() throws IOException {

        //Load saved content
        reader = new BufferedReader(new FileReader(savedAccounts));

            //while saved file has content left to read
            while(reader.ready()){

                //get the next line
                String currentLine = reader.readLine();

                //split username and password and add to map
                String[] credentials = currentLine.split(":");
                accounts.put(credentials[0], Integer.valueOf(credentials[1]));

            }

            reader.close();
    }

    public void start() throws IOException {

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

    private void login() throws IOException {

        StringInputScanner askUsername = new StringInputScanner();
        PasswordInputScanner askPassword = new PasswordInputScanner();

        StringInputScanner askRegister = new StringInputScanner();


        askUsername.setMessage("Enter your username: ");
        askPassword.setMessage("Enter your password: ");
        askRegister.setMessage("Would you like to Register? [yes/no]");


        boolean loginSuccess = false;

        while(!loginSuccess){

            String username = epicPrompt.getUserInput(askUsername);  //username as String
            int password = epicPrompt.getUserInput(askPassword).hashCode(); //password as hashcode; might replace with String if problems;


            if(accounts.containsKey(username)){

                if(accounts.get(username) == password) loginSuccess = true;
                else System.out.println("Wrong password!");

            } else {
                System.out.println("This user doesn't exist!");
                String registeredResponse = epicPrompt.getUserInput(askRegister);

                if (registeredResponse.equals("yes")) register(); else exit();


            }

        }

        System.out.println("\nLogin successful! \nWelcome to Jumanji. \n\n\n jklol");
    }

    private void register() throws IOException {

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
        System.out.println("\nRegistered user: " + username + "!");


        writer = new BufferedWriter(new FileWriter(savedAccounts));

        System.out.println("\nSaving you data...\n");

        writer.write(username + ":" + password + "\n");
        writer.flush();
        writer.close();

    }

    private void exit(){
        System.out.println("\nExiting...\nSafe travels, adventurer!\n");
        System.exit(0);
    }



}
