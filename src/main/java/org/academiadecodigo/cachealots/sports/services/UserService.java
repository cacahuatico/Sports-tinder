package org.academiadecodigo.cachealots.sports.services;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface UserService {

    /**
     * Gets the customer
     *
     * @param id the customer id
     * @return the customer with the given id
     */
     User get(Integer id);


    /**
     * Gets the list of customers
     *
     * @return the customer list
     */
    List<User> list();



    /**
     * Adds a customer to the service
     *
     * @param user the customer to add
     */
    void add(User user);
}
