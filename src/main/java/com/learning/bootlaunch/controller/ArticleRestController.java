package com.learning.bootlaunch.controller;

import com.learning.bootlaunch.AjaxResponse;
import com.learning.bootlaunch.model.Article;
import com.learning.bootlaunch.service.ArticleRestJDBCServiceImpl;
import com.learning.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

//    @Resource
//    ArticleRestJDBCServiceImpl articleRestJDBCServiceImpl;

    @Resource(name = "articleRestJDBCServiceImpl")
    ArticleRestService articleRestService;

    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {

        articleRestService.saveArticle(article);
        return  AjaxResponse.success(article);
    }
 
//    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }
 
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }
 
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {

        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping(value = "article")
    public AjaxResponse getAllArticle(){
        return AjaxResponse.success(articleRestService.getAll());
    }
}