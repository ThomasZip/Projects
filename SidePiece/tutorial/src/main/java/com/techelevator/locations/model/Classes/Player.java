package com.techelevator.locations.model.Classes;




import com.techelevator.locations.model.Items.Items;

import java.util.List;

public class Player {
   private String playerName;// from user input
   private int playerNumber;//comes from order player enters name
   private boolean isEvil; //assigned at random
   private Role playerRole;

   private List<Items> inventory; // if player.role = nav they have navs invetory etc.
   private int playerHealthRemaining = 3;
   private boolean isCaptain;




   public Player(int number, String name, List<Items> inventory){
      this.playerNumber = number;
      this.playerName = name;
      this.inventory = inventory;

   }

   public Player(){}



   public String getPlayerName() {
      return this.playerName;
   }

   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   public int getPlayerNumber() {
      return this.playerNumber;
   }

   public void setPlayerNumber(int playerNumber) {
      this.playerNumber = playerNumber;
   }

   public boolean isEvil() {
      return this.isEvil;
   }

   public void setEvil(boolean evil) {
      this.isEvil = evil;
   }
   public Role getPlayerRole() {
      return playerRole;
   }

   public void setPlayerRole(Role playerRole) {
      this.playerRole = playerRole;
   }
   public List<Items> getPlayerInv(){
      return inventory;
   }
   public String getInventoryAsString() {
      for(Items items: inventory){
         return items.getName() + " " +  items.getDescription() ;
      }
      return "\n";
   }

   public void addToInventory(Items item){
      inventory.add(item);
   }
   public void setCaptain(String playerName){
      if(playerName.equals(getPlayerName())){
         isCaptain = true;
      }else{
         isCaptain = false;
      }
   }

   public boolean getIsCaptain(){
      return this.isCaptain;
   }

   public int getPlayerHealthRemaining() {
      return playerHealthRemaining;
   }

   public void setPlayerHealthRemaining(int playerHealthRemaining) {
      this.playerHealthRemaining = playerHealthRemaining;
   }







}


