package sn.blog.services;

import java.util.List;

import sn.blog.models.Article;
import sn.blog.models.User;
import sn.blog.services.dtos.ArticleDto;

public interface ArticleService {
    Article add(ArticleDto articleDto, User user);
    List<Article> getAll();
}
