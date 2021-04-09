package org.academiadecodigo.cachealots.sports.services;


import org.academiadecodigo.cachealots.sports.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An {@link AuthService} implementation
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserService userService;
    private User accessingUser;

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
     * @see AuthService#authenticate(String email, String password)
     */
    @Override
    public boolean authenticate(String email, String password) {
        accessingUser = userService.get(email);
        if (accessingUser == null){return false;}
        if (!accessingUser.getPassword().equals(password)){return false;}
        return true;
    }

    /**
     * @see AuthService#getAccessingUser()
     */
    @Override
    public User getAccessingUser() {
        return accessingUser;
    }
}
