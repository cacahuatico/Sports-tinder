package org.academiadecodigo.cachealots.sports.model;

import java.util.List;

public class User extends AbstractModel{

    private String firstName;
    private String lastName;
    private Integer age;
    private City cityId;
    private String email;
    private String password;

    private List<Sports> sportsList;
    private List<Friend> friendsList;

    public List<Friend> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<Friend> friendsList) {
        this.friendsList = friendsList;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Sports> getSportsList() {
        return sportsList;
    }

    public void setSportsList(List<Sports> sportsList) {
        this.sportsList = sportsList;
    }
}
