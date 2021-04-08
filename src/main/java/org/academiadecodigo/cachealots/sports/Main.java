package org.academiadecodigo.cachealots.sports;

import org.academiadecodigo.cachealots.sports.model.User;
import org.academiadecodigo.cachealots.sports.services.UserService;
import org.academiadecodigo.cachealots.sports.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {



    public static void main(String[] args) {
        User rui = new User();
        rui.setAge(24);
        UserServiceImpl userService = new UserServiceImpl();
        userService.add(rui);

    }


}
