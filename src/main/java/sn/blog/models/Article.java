package sn.blog.models;

import lombok.*;
import sn.blog.services.dtos.ArticleDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
    private int id;
    private String title;
    private String content;
    private User user;

    public Article(ArticleDto articleDto, User user){
        content = articleDto.getContent();
        title = articleDto.getTitle();
        this.user = user;
    }
}
