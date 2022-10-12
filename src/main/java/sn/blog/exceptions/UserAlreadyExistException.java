package sn.blog.exceptions;

public class UserAlreadyExistException extends Exception {
    
    public UserAlreadyExistException(String message){
        super(message);
    }
}
