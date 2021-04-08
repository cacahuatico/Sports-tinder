package org.academiadecodigo.cachealots.sports.model;

import java.util.List;

public class City{

    private String name;

    private List<Places> placesList;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Places> getPlacesList() {
        return placesList;
    }

    public void setPlacesList(List<Places> placesList) {
        this.placesList = placesList;
    }
}
