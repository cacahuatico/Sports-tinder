package org.academiadecodigo.cachealots.sports.controller;

import org.academiadecodigo.cachealots.sports.model.User;
import org.academiadecodigo.cachealots.sports.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {


        private UserService userService;

        /**
         * Sets the customer service
         *
         * @param userService the customer service to set
         */
        @Autowired
        public void setUserService(UserService userService) {
            this.userService = userService;
        }



        /**
         * Retrieves a representation of the list of customers
         *
         * @return the response entity
         */
        @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
        public ResponseEntity<List<User>> listCustomers() {

                List<User> userList = userService.list();

            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
}
