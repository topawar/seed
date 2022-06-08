package com.seed.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: YJ
 * @createTime: 2022/06/06 22:41
 * @company: https://www.xxx.cn
 * @description: 文章
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -158095260504209970L;
    private String ArticleId;
    private String Title;
    private String Content;
    private String ArticleKind;
    private Integer PointNum;
    private Integer FavoriteNum;
    private List<UserComment> UserCommentList;



    public Article() {
    }

    public String getArticleId() {
        return ArticleId;
    }

    public void setArticleId(String articleId) {
        ArticleId = articleId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Integer getPointNum() {
        return PointNum;
    }

    public void setPointNum(Integer pointNum) {
        PointNum = pointNum;
    }

    public Integer getFavoriteNum() {
        return FavoriteNum;
    }

    public void setFavoriteNum(Integer favoriteNum) {
        FavoriteNum = favoriteNum;
    }

    public List<UserComment> getUserCommentList() {
        return UserCommentList;
    }

    public void setUserCommentList(List<UserComment> userCommentList) {
        UserCommentList = userCommentList.stream().collect(Collectors.toList());//java8Steam流API
    }

    public String getArticleKind() {
        return ArticleKind;
    }

    public void setArticleKind(String articleKind) {
        ArticleKind = articleKind;
    }

    public Article(String articleId, String title, String content, String articleKind, Integer pointNum, Integer favoriteNum, List<UserComment> userCommentList) {
        ArticleId = articleId;
        Title = title;
        Content = content;
        ArticleKind = articleKind;
        PointNum = pointNum;
        FavoriteNum = favoriteNum;
        UserCommentList = userCommentList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "ArticleId='" + ArticleId + '\'' +
                ", Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                ", ArticleKind='" + ArticleKind + '\'' +
                ", PointNum=" + PointNum +
                ", FavoriteNum=" + FavoriteNum +
                ", UserCommentList=" + UserCommentList +
                '}';
    }
}
