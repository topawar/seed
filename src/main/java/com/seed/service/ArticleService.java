package com.seed.service;

import com.seed.entity.Article;
import com.seed.entity.UserComment;

import java.util.List;


/**
 * @author: YJ
 * @createTime: 2022/06/06 22:44
 * @company: https://www.xxx.cn
 * @description: 文章应用层
 */

public interface ArticleService {
    Integer addArticle(String uid, Article article);

    List<Article> getArticleList(String ArticleKind,String Title);

    Integer addUserComment(UserComment userComment);


}
