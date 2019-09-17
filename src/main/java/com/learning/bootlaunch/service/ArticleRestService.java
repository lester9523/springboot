package com.learning.bootlaunch.service;

import com.learning.bootlaunch.AjaxResponse;
import com.learning.bootlaunch.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.util.*;

@Slf4j
@Service
public class ArticleRestService {
    public String saveArcticle(Article article){
        log.info("save :{}",article);
        return "test";
    }


    public static void main(String[] args) {
        Boolean result ;
        String s = "";
        Stack<String> stack = new Stack();
        Map<String,String> map = new HashMap<>();
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");
        List<String> list = new ArrayList<>();
        list.add(")");
        list.add("]");
        list.add("}");
        if(StringUtils.isEmpty(s)){
            result = false;
        }






    }
}
