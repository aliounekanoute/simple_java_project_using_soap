package sn.blog.controllers;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import sn.blog.exceptions.UserNotFoundException;
import sn.blog.models.Article;
import sn.blog.models.User;
import sn.blog.services.dtos.ArticleDto;
import sn.blog.services.impl.ArticleServiceImpl;
import sn.blog.services.impl.UserServiceImpl;

@WebService(name = "BlogAppServices")
public class BlogAppController {
    private UserServiceImpl userService = new UserServiceImpl();
    private ArticleServiceImpl articleService = new ArticleServiceImpl();


    @WebMethod
    public User create(@WebParam(name = "user")User user) {
        System.out.println("User creation");
        return userService.create(user);
    }

    @WebMethod
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) throws UserNotFoundException {
        System.out.println("User sign in");
        return userService.login(username, password);
    }

    @WebMethod
    public boolean logout(@WebParam(name = "token") String token){
        System.out.println("User sign out");
        return userService.logout(token);
    }

    @WebMethod
    public Article addArticle(@WebParam(name = "article") ArticleDto article, @WebParam(name = "token") String token) throws UserNotFoundException {

        User user = userService.getUserByToken(token);

        return articleService.add(article, user);
    }

    @WebMethod
    public List<Article> getAllArticle() {
        return articleService.getAll();
    }
    
}
