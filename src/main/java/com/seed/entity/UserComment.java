package com.seed.entity;

import java.io.Serializable;

/**
 * @author: YJ
 * @createTime: 2022/06/06 22:41
 * @company: https://www.xxx.cn
 * @description: 文章评论区
 */
public class UserComment implements Serializable {
    private static final long serialVersionUID = -2339870971706914949L;
    private String Name;
    private String ArticleId;
    private String Comment;
    private Integer IsAnonymity;

    public UserComment() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArticleId() {
        return ArticleId;
    }

    public void setArticleId(String articleId) {
        ArticleId = articleId;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Integer getIsAnonymity() {
        return IsAnonymity;
    }

    public void setIsAnonymity(Integer isAnonymity) {
        IsAnonymity = isAnonymity;
    }

    public UserComment(String name, String articleId, String comment, Integer isAnonymity) {
        Name = name;
        ArticleId = articleId;
        Comment = comment;
        IsAnonymity = isAnonymity;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "Name='" + Name + '\'' +
                ", ArticleId='" + ArticleId + '\'' +
                ", Comment='" + Comment + '\'' +
                ", IsAnonymity=" + IsAnonymity +
                '}';
    }
}
