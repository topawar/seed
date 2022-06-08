package com.seed.dao;

import com.seed.entity.Article;
import com.seed.entity.UserComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: YJ
 * @createTime: 2022/06/06 22:43
 * @company: https://www.xxx.cn
 * @description: 文章接口层
 */
@Mapper
public interface ArticleDao {
    Integer addArticle(@Param("uid")String uid, @Param("at")Article article);

    List<Article> getArticleList(@Param("ArticleKind")String ArticleKind,@Param("Title")String Title);

    Integer addUserComment(UserComment userComment);

    List<UserComment> getUserCommentList();

}
