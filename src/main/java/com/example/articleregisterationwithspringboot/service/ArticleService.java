package com.example.articleregisterationwithspringboot.service;

import com.example.articleregisterationwithspringboot.base.service.BaseService;
import com.example.articleregisterationwithspringboot.domains.Article;

public interface ArticleService extends BaseService<Article,Long> {

    Article findByTitle(String title);
}
