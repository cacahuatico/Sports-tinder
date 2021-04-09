package org.academiadecodigo.cachealots.sports.controller;

import org.academiadecodigo.cachealots.sports.model.Sports;
import org.academiadecodigo.cachealots.sports.model.User;
import org.academiadecodigo.cachealots.sports.services.AuthServiceImpl;
import org.academiadecodigo.cachealots.sports.services.UserService;
import org.academiadecodigo.cachealots.sports.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {


    private UserServiceImpl userService;
    private AuthServiceImpl authService;

    /**
     * Sets the customer service
     *
     * @param userService the customer service to set
     */
    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAuthService(AuthServiceImpl authService) {
        this.authService = authService;
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

    @RequestMapping(method = RequestMethod.GET, path = "/friends/{id}")
    public ResponseEntity<List<User>> listFriends(@PathVariable Integer id) {

        List<User> friendList = userService.getById(id).getFriendsList();

        return new ResponseEntity<>(friendList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/access"})
    public ResponseEntity authUser(@Valid @RequestBody User user, BindingResult bindingResult) {


        User user2 = null;

        if (authService.authenticate(user.getEmail(), user.getPassword())) {
            user2 = userService.get(user.getEmail());
            return new ResponseEntity<>(user2, HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Adds a customer
     *
     * @param user the user
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<User> addCustomer(@Valid @RequestBody User user, BindingResult bindingResult) {
        List<User> userList = userService.list().stream().filter(user1 -> user1.getEmail().equals(user.getEmail())).collect(Collectors.toList());


        if (bindingResult.hasErrors() || user.getId() != null || !userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        userService.add(user);
        User user1 = userService.get(user.getEmail());

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/many")
    public ResponseEntity<String> addManyCustomer(@Valid @RequestBody List<User> user, BindingResult bindingResult) {

        for (User user1 : user) {
            List<User> userList = userService.list().stream().filter(user2 -> user2.getEmail().equals(user1.getEmail())).collect(Collectors.toList());


            if (bindingResult.hasErrors() || user1.getId() != null || !userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


            userService.add(user1);

        }


        return new ResponseEntity<>("Users Created Success", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addFriend/{cid}")
    public ResponseEntity addFriend(@RequestBody User user, @PathVariable Integer cid) {

        userService.addFriend(user.getId(), cid);

        return new ResponseEntity<>("You have followed " + userService.getById(cid).getFirstName(), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/addsport")
    public ResponseEntity addSports(@RequestBody String sports) {
        return new ResponseEntity<>("You have followed " + authService.getAccessingUser().getFirstName(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sports")
    public ResponseEntity<List<Sports>> listSports() {

        List<Sports> sportsList = Arrays.asList(Sports.values().clone());

        return new ResponseEntity<>(sportsList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/city")
    public ResponseEntity<List<User>> listUsersByCity(@RequestParam String city) {

        List<User> usersList = userService.list().stream().filter(user -> user.getCity().equals(city)).collect(Collectors.toList());

        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
}
