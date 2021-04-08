package org.academiadecodigo.cachealots.sports.services;


import org.academiadecodigo.cachealots.sports.model.User;
import org.springframework.stereotype.Service;

/**
 * An {@link AuthService} implementation
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserService UserService;
    private User accessingUser;

    /**
     * Sets the customer service
     *
     * @param userService the customer service to set
     */
    public void setUserService(UserService userService) {
        this.UserService = userService;
    }

    /**
     * @see AuthService#authenticate(String email,String password)
     */
    @Override
    public boolean authenticate(String email,String password) {
        accessingUser = UserService.get(email);
        if (accessingUser==null){return false;}
        if (accessingUser.getPassword()!=password){return false;}
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
