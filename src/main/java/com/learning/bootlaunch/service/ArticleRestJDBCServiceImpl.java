package com.learning.bootlaunch.service;

import com.learning.bootlaunch.dao.ArticleJDBCDAO;
import com.learning.bootlaunch.model.Article;
import com.learning.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;


    @Transactional
    public Article saveArticle( Article article) {
        articleJDBCDAO.save(article,primaryJdbcTemplate);
        articleJDBCDAO.save(article,secondaryJdbcTemplate);
        int a = 2/0;
        return article;
    }

    public void deleteArticle(Long id){
        articleJDBCDAO.deleteById(id);
    }

    public void updateArticle(Article article){
        articleJDBCDAO.updateById(article);
    }

    public Article getArticle(Long id){
        return articleJDBCDAO.findById(id);
    }

    public List<Article> getAll(){
        return articleJDBCDAO.findAll();
    }
}
