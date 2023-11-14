package com.techelevator.locations.model.Classes;

public class RadioOp extends Role {
    public RadioOp(){//TODO add op inv
        super("Radio Operator", "The Radio Op allows full communication between the crew, while planet side (talking is fully permitted while they are on the mission).");
    }


    @Override
    public String toString(){
        return "Radio Operator";
    }
}
