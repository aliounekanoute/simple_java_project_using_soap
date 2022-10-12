package sn.blog.services;

import sn.blog.exceptions.UserNotFoundException;
import sn.blog.models.User;

public interface UserService {

    User create(User user);
    String login(String username, String password) throws UserNotFoundException;
    boolean logout(String username);
}
