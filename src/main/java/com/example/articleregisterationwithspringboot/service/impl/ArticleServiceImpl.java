package com.example.articleregisterationwithspringboot.service.impl;

import com.example.articleregisterationwithspringboot.base.service.impl.BaseServiceImpl;
import com.example.articleregisterationwithspringboot.domains.Article;
import com.example.articleregisterationwithspringboot.repository.ArticleRepository;
import com.example.articleregisterationwithspringboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, Long, ArticleRepository> implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    @Override
    public List<Article> findPublishedArticles() {
        return articleRepository.findPublishedArticles();
    }
}
