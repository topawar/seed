package com.seed.service.impl;

import com.seed.dao.ArticleDao;
import com.seed.dao.UserDao;
import com.seed.entity.Article;
import com.seed.entity.User;
import com.seed.entity.UserComment;
import com.seed.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: YJ
 * @createTime: 2022/06/06 22:45
 * @company: https://www.xxx.cn
 * @description: 文章应用实现层
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public Integer addArticle(String uid, Article article) {
        return articleDao.addArticle(uid,article);
    }

    @Override
    public List<Article> getArticleList(String ArticleKind,String Title) {
        List<Article> articleList = articleDao.getArticleList(ArticleKind,Title);//获取所有文章列表
        List<UserComment> userCommentList = articleDao.getUserCommentList();//获取所有文章评论列表
        List<UserComment> userComments=new ArrayList<>();
        /**
         * 双循环，通过文章列表，与文章评论列表中相同的文章id,取对应的用户评论。
         */
        for (Article article : articleList) {
//            userComments=new ArrayList<>();
            for (UserComment userComment : userCommentList) {
                if (article.getArticleId().equals(userComment.getArticleId())){
                    userComments.add(userComment);
                }
            }
            article.setUserCommentList(userComments);
            userComments.clear();//会清空列表中的所有元素，使用clear需重写set方法,采用深拷贝
        }
        return articleList;
    }

    @Override
    public Integer addUserComment(UserComment userComment) {
        User user=(User)request.getSession().getAttribute("user");
        userComment.setName(user.getName());
        if(userComment.getIsAnonymity()==null){
            userComment.setIsAnonymity(0);
        }else{
            userComment.setIsAnonymity(1);
        }
        return articleDao.addUserComment(userComment);
    }


}
