package com.techelevator.locations.model.Classes;

import com.techelevator.locations.model.Classes.Role;

public class SecurityForces extends Role {

    //TODO give all classes their items.
    public SecurityForces(){
        super("Security Forces", "Security Forces is responsible for the direct protection of the VIP and crew, in that order. ");

    }

    @Override
    public String toString(){
        return "Security Forces";
    }
}
