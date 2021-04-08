package org.academiadecodigo.cachealots.sports.services;

import org.academiadecodigo.cachealots.sports.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
/**
 * An {@link UserService} implementation
 */
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, User> userMap = new HashMap<>();

    /**
     * Gets the next user id
     *
     * @return the next id
     */
    private Integer getNextId() {
        return userMap.isEmpty() ? 1 : Collections.max(userMap.keySet()) + 1;
    }

    /**
     * @see UserService#get(String)
     */
    @Override
    public User get(String email) {
        return userMap.values().stream().filter(user -> user.getEmail()==email).findFirst().get();
    }

    /**
     * @see UserService#list()
     */
    @Override
    public List<User> list() {
        return new ArrayList<>(userMap.values());
    }


    /**
     * @see UserService#add(User)
     */
    @Override
    public void add(User user) {

        if (user.getId() == null) {
            user.setId(getNextId());
        }

        userMap.put(user.getId(), user);
    }
}
