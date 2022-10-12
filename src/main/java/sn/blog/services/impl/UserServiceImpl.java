package sn.blog.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sn.blog.exceptions.UserNotFoundException;
import sn.blog.models.User;
import sn.blog.services.UserService;
import sn.blog.utils.TokenGenerator;

@Getter
public class UserServiceImpl implements UserService {

    private Map<Integer, User> users = new HashMap<>();
    private Map<String, User> connectedUsers = new HashMap<>();

    @Override
    public User create(User user) {
        int id = users.size() + 1;
        user.setId(id);
        users.put(id, user);
        return users.get(id);
    }

    @Override
    public String login(String username, String password) throws UserNotFoundException{
        User userExist = userExist(username, password);
        if(userExist == null) throw new UserNotFoundException("Login ou mot de passe incorrect");
        String token = TokenGenerator.getRandomAlphaNumeric();
        connectedUsers.put(token, userExist);

        return token;
    }

    @Override
    public boolean logout(String token) {
        Boolean response = false;
        if(connectedUsers.containsKey(token)){
            response = true;
            connectedUsers.remove(token);
        }
        return response;
    }

    public User getUserByToken(String token) throws UserNotFoundException{
        User user = this.connectedUsers.get(token);

        if(user == null) {
            throw new UserNotFoundException("Votre token est invalid");
        }

        return user;
    }

    private User userExist(String username, String password) {
        User response = null;
        User user;
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            user = entry.getValue();
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                response = user;
                break;
            }
        }

        return response;
    }
    
}
