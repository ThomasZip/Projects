package com.techelevator.locations.model.Items;

public abstract class Weapon extends Items {
    private String weaponName;
    private int ammoRemaining;
    private String description;
    private int weaponDamage;
    public Weapon(String weaponName,String description, int weaponDamage, int ammo){
        super(weaponName, description);
        this.weaponDamage = weaponDamage;
        this.ammoRemaining = ammo;
    }

    public String getWeaponName() {
        return weaponName;
    }


    public int getAmmoRemaining() {
        return ammoRemaining;
    }

    public void setAmmoRemaining(int ammoRemaining) {
        this.ammoRemaining = ammoRemaining;
    }

    public String getDescription() {
        return description;
    }



    public int getWeaponDamage() {
        return weaponDamage;
    }






}
