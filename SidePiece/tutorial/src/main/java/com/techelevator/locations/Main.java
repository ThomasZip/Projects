package com.techelevator.locations;




import com.techelevator.locations.model.Game;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Game newGame = new Game();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Harper: Welcome to The USS Zanzibar space fleet,");
        newGame.setPlayerCount();//Enter number of players:


        newGame.setPlayerNamesAndRolesCreatePlayerList(newGame.getPlayerCount());//Makes a list of all the players
        newGame.setNumOfGoodPlayers();
        newGame.setNumofBadPlayers();
        newGame.setEvilPlayers();
        newGame.setBadPlayersList();
        newGame.playersReceiveOrders();
        for(int i = 0; i < newGame.listOfPlayers.size(); i++){
            System.out.println(newGame.listOfPlayers.get(i).getPlayerName());
            System.out.println(newGame.listOfPlayers.get(i).getPlayerRole());
            System.out.println(newGame.listOfPlayers.get(i).getPlayerRole().getDescription());
            System.out.println("\n");

        }
        newGame.setPlayerStartingInventory();
















    }



}