package com.techelevator.locations.model.Classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Role {
    private String roleName;
    private String roleDescription;


    public Role(String name, String description){
        this.roleName = name;
        this.roleDescription = description;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }

    public String getDescription() {
        return roleDescription;
    }

    public void setDescription(String description) {
        this.roleDescription = description;
    }
    @Override
    public String toString(){
        return roleName;
    }


}
