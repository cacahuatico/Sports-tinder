package org.academiadecodigo.cachealots.sports.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class User extends AbstractModel{


    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    //@NotNull(message = "Age is mandatory")
    //@NotBlank(message = "Age is mandatory")
    private Integer age;
    //@NotNull(message = "City is mandatory")
    //@NotBlank(message = "City is mandatory")
    private String city;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 3, max = 64)
    private String password;
    @JsonFormat(with = JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)
    private List<Sports> sportsList;
    @JsonIgnore
    private List<User> friendsList;


    public List<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
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

    public String getCity() {
        return city;
    }

    public void setCityId(String city) {
        this.city = city;
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
