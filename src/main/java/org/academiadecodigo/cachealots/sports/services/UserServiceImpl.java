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

        Optional<User> user1 = userMap.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();
        if (user1.isPresent()){
            return user1.get();
        }
        return null;
    }

    public User getById(Integer id) {


        return userMap.get(id);
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
        System.out.println(getNextId());

        System.out.println(user.getId());
        userMap.put(user.getId(), user);
    }

    public void addFriend(Integer idCustomer,Integer idFriend){
       List<User> userList= userMap.get(idCustomer).getFriendsList()==null? new LinkedList<>(): userMap.get(idCustomer).getFriendsList();

       userList.add(userMap.get(idFriend));
       userMap.get(idCustomer).setFriendsList(userList);
    }

}
