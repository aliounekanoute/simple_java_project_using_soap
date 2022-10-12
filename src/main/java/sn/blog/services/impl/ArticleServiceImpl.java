package sn.blog.services.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sn.blog.models.Article;
import sn.blog.models.User;
import sn.blog.services.ArticleService;
import sn.blog.services.dtos.ArticleDto;

@NoArgsConstructor
@Getter
public class ArticleServiceImpl implements ArticleService{

    private List<Article> articles = new ArrayList<>();


    @Override
    public Article add(ArticleDto articleDto, User user) {
        Article article = new Article(articleDto, user);
        article.setId(articles.size() + 1);
        articles.add(article);
        return article;
    }

    @Override
    public List<Article> getAll() {
        return articles;
    }
    
}
