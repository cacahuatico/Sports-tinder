package org.academiadecodigo.cachealots.sports.services;


/**
 * An {@link AuthService} implementation
 */
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
     * @see AuthService#authenticate(Integer)
     */
    @Override
    public boolean authenticate(Integer id) {

        accessingUser = UserService.get(id);
        return accessingUser != null;
    }

    /**
     * @see AuthService#getAccessingUser()
     */
    @Override
    public User getAccessingUser() {
        return accessingUser;
    }
}
