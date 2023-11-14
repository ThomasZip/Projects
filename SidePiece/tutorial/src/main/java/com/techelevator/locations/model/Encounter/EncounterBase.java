package com.techelevator.locations.model.Encounter;

import com.techelevator.locations.model.Classes.Player;
import com.techelevator.locations.model.Planets.PlanetMinSize1;

import java.util.List;

public abstract class EncounterBase {
    private String encounterName;

    private List<Player> playersOnEncounter;
    private List<PlanetMinSize1> planetOptions;
    private String planetOneDesc;
    private String planetTwoDesc;
    private String planetOneNavigatorDesc;
    private String planetTwoNavigatorDesc;

    public String getEncounterName() {
        return encounterName;
    }

    public void setEncounterName(String encounterName) {
        this.encounterName = encounterName;
    }

    public List<Player> getPlayersOnEncounter() {
        return playersOnEncounter;
    }

    public void setPlayersOnEncounter(List<Player> playersOnEncounter) {
        this.playersOnEncounter = playersOnEncounter;
    }

    public List<PlanetMinSize1> getPlanetOptions() {
        return planetOptions;
    }

    public void setPlanetOptions(List<PlanetMinSize1> planetOptions) {
        this.planetOptions = planetOptions;
    }

    public String getPlanetOneDesc() {
        return planetOneDesc;
    }

    public void setPlanetOneDesc(String planetOneDesc) {
        this.planetOneDesc = planetOneDesc;
    }

    public String getPlanetTwoDesc() {
        return planetTwoDesc;
    }

    public void setPlanetTwoDesc(String planetTwoDesc) {
        this.planetTwoDesc = planetTwoDesc;
    }

    public String getPlanetOneNavigatorDesc() {
        return planetOneNavigatorDesc;
    }

    public void setPlanetOneNavigatorDesc(String planetOneNavigatorDesc) {
        this.planetOneNavigatorDesc = planetOneNavigatorDesc;
    }

    public String getPlanetTwoNavigatorDesc() {
        return planetTwoNavigatorDesc;
    }

    public void setPlanetTwoNavigatorDesc(String planetTwoNavigatorDesc) {
        this.planetTwoNavigatorDesc = planetTwoNavigatorDesc;
    }



}
