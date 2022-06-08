package com.seed.controller;

import com.seed.entity.Article;
import com.seed.entity.User;
import com.seed.entity.UserComment;
import com.seed.service.ArticleService;
import com.seed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;


    @PostMapping("/addArticle")
    public Integer addArticle(Article article) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        article.setArticleId(uuid);
        User user = (User) request.getSession().getAttribute("user");
        String uid=null;
        List<User> userList = userService.selectAll();
        for (User userL : userList) {
            if (user.getName().equals(userL.getName())){
                uid=userL.getUid();
            }
        }
        System.out.println(article);
        Integer result = articleService.addArticle(uid, article);
        return result;
    }

    @GetMapping("/getArticleList")
    public List<Article> getArticleList(@RequestParam("ArticleKind")String ArticleKind,@RequestParam("Title")String Title){
        System.out.println(ArticleKind);
       return articleService.getArticleList(ArticleKind,Title);
    }

    @PostMapping("/addUserComment")
    public Integer addUserComment(UserComment userComment,String ArticleId){
//        userComment.setArticleId(ArticleId);
        userComment.setArticleId("d83153223703494eb65d2c171d76f1dd");
        return articleService.addUserComment(userComment);
    }
}
