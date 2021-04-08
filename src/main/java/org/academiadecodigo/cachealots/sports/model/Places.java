package org.academiadecodigo.cachealots.sports.model;

import java.util.List;

public class Places extends AbstractModel{

    private String name;
    private City cityId;
    private String address;

    private List<Sports> sportsList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }


    public List<Sports> getSportsList() {
        return sportsList;
    }

    public void setSportsList(List<Sports> sportsList) {
        this.sportsList = sportsList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
