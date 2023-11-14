package com.techelevator.locations.model.Items;

public abstract class Items {


    private String name;
    private String description;

    public Items(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
