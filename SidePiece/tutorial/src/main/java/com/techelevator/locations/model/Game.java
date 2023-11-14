package com.techelevator.locations.model;




import com.techelevator.locations.model.Classes.*;
import com.techelevator.locations.model.Items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.RandomAccessFile;

public class Game {
    Scanner userInput = new Scanner(System.in);
    private int playerCount;
    private int numOfGoodPlayers;
    private int numofBadPlayers;
    public List<Player> listOfPlayers = new ArrayList<>(); //how to access specific player names. indexed from 0
    Random playerRandomAssigner = new Random();
    File orders = new File("C:\\Users\\Student\\workspace\\thomas-saunders-student-code\\SidePiece\\tutorial\\src\\main\\java\\com\\techelevator\\locations\\model\\Logs", "Orders.txt");
    PrintWriter orderWriter = new PrintWriter(orders);
    private List<Player> badPlayerList = new ArrayList<>();

    Player player = new Player();

    //new instances of roles:
    //TODO Add more roles.
    Navigator newNav = new Navigator();
    Engineer newEng = new Engineer();
    SecurityForces newSecFo = new SecurityForces();
    RadioOp newRadioOp = new RadioOp();

    Placeholder placeholder = new Placeholder();
    GammaPulseRifle gammaPulseRifle = new GammaPulseRifle();
    PlasmaWrench plasmaWrench = new PlasmaWrench();


    public Game() throws FileNotFoundException {
    }


    //Asks how many players, stored in
    public void setPlayerCount(){
        int count = 0;

            try {
                System.out.println("How many crew members do you have today?");
                String playerCountStr = userInput.nextLine();
                count = Integer.parseInt(playerCountStr);


            } catch (Exception ex) {
                System.err.println("Please enter a valid number of crew.");
                setPlayerCount();
            }

        this.playerCount = count;

    }
    public int getPlayerCount(){
        return this.playerCount;
    }

    public void setPlayerNamesAndRolesCreatePlayerList(int playerCount){
        for(int i = 1; i <= playerCount; i++){
            System.out.println("Player " + i + " enter your name: ");//TODO add if for valid strings only.
            String playerName = userInput.nextLine();
            List<Items>playerInv = new ArrayList<>();
            Player newPlayer = new Player(i, playerName, playerInv);
            listOfPlayers.add(newPlayer);
        }

        Collections.shuffle(listOfPlayers,playerRandomAssigner);
        for(int i = 1; i <= listOfPlayers.size(); i++){
            if(i == 1){
                listOfPlayers.get(0).setPlayerRole(newNav);
            }else if(i == 2){
                listOfPlayers.get(1).setPlayerRole(newEng);
            }else if(i == 3){
                listOfPlayers.get(2).setPlayerRole(newSecFo);
            }else if(i == 4){
                listOfPlayers.get(3).setPlayerRole(newRadioOp);
            }
        }
    }
    public void setNumOfGoodPlayers(){
        if(playerCount == 3){
            this.numOfGoodPlayers = 2;
        }
        if(playerCount == 4){
            this.numOfGoodPlayers = 3;
        }
        if(playerCount == 5){
            this.numOfGoodPlayers = 3;
        }
        if(playerCount == 6){
            this.numOfGoodPlayers = 4;
        }
    }
    public int getNumOfGoodPlayers(){
        return this.numOfGoodPlayers;
    }
    public void setNumofBadPlayers(){
        this.numofBadPlayers = playerCount - numOfGoodPlayers;
    }

    public int getNumofBadPlayers() {
        return this.numofBadPlayers;
    }


    public void setEvilPlayers(){
        Collections.shuffle(listOfPlayers, playerRandomAssigner);
        for(int i = 0; i < numofBadPlayers; i ++){
            listOfPlayers.get(i).setEvil(true);
            }
        }

    public void setBadPlayersList(){
        for(Player entry : listOfPlayers){
            if(entry.isEvil()){
                this.badPlayerList.add(entry);
            }
        }
    }
    public void playersReceiveOrders() throws IOException {//TODO will need to delete order file at the end of the program.
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile(orders, "rw");

            Collections.shuffle(listOfPlayers, playerRandomAssigner);
            for (Player entry : listOfPlayers) {
                // Move the file pointer to the beginning for writing
                file.seek(0);

                if (entry.isEvil()) { // if isBad == true
                    file.setLength(0); // Clear the file before writing new content
                    file.writeBytes(entry.getPlayerName() + " You are a member of the Separatist Commonwealth. \nYour mission is to infiltrate this wretched crew and ensure the VIP on board does not make it to their destination. \n" +
                            "You will have to use all subterfuge tactics at your disposal. Our members on board are as follows: " + badPlayerList + ". More orders to follow.");
                } else {
                    file.setLength(0); // Clear the file before writing new content
                    file.writeBytes(entry.getPlayerName() + " You are a member of the Human coalition, Welcome to the glorious USS Zanzibar! \nYour mission is to ensure our glorious senator survives this journey. We have intel, stating " +
                            numofBadPlayers + " Separatists members on board. \nIf you can, eliminate them, but don't let this come at the cost of the senator. Good luck comrade.");
                }

                System.out.println(entry.getPlayerName() + " Please read your orders now from the 'Orders.txt' file.");
                System.out.println("When you're ready, close the orders file and press enter.");
                String pass = userInput.nextLine();
            }
        } catch (IOException ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    public void setPlayerStartingInventory(){//TODO: add actual items for nav and radio op.
        for(Player player : listOfPlayers){
            if(player.getPlayerRole().getName().equals("Engineer")){
                player.addToInventory(plasmaWrench);
            }
            if(player.getPlayerRole().getName().equals("Security Forces")){
                player.addToInventory(gammaPulseRifle);
            }
            if(player.getPlayerInv().size()>0) {
                System.out.println(player.getPlayerRole() + " " + player.getPlayerName() + " You are equipped with the following: " + player.getPlayerInv().get(0).getName());
            }else{
                System.out.println(player.getPlayerRole() + " " + player.getPlayerName() + " You have nothing in your inventory currently.");
            }

        }

    }

    public void firstPlayerVote(){
        System.out.println("I know it's early in your journey; but as is tradition on a Commonwealth spacecraft, it's time to vote on a Captain for the first leg of your journey. \n" +
                "Take some time to discuss who you believe would be the best fit and then choose accordingly. Every crew member gets one vote and they cannot vote for themselves.\n" +
                "Start with Player 1 and move clockwise around the crew announcing your vote publicly."
        );

        System.out.println("Once a Crew member ahs a majority of the vote enter their name here:");
        String firstCaptain = userInput.nextLine();

        for(Player user: listOfPlayers){
            user.setCaptain(firstCaptain);
            if(user.getIsCaptain()){
                System.out.println(user.getPlayerName() + "You have been elected the first Captain, congratulations!");
            }
        }



    }





    }




