package com.example.articleregisterationwithspringboot.service;

import com.example.articleregisterationwithspringboot.base.service.BaseService;
import com.example.articleregisterationwithspringboot.domains.Article;

import java.util.List;

public interface ArticleService extends BaseService<Article,Long> {

    Article findByTitle(String title);

    List<Article> findPublishedArticles();

    List<Article> findByUserName(String userName);
}
