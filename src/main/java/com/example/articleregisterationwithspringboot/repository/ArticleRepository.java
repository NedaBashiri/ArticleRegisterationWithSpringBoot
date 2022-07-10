package com.example.articleregisterationwithspringboot.repository;

import com.example.articleregisterationwithspringboot.base.repository.BaseRepository;
import com.example.articleregisterationwithspringboot.domains.Article;

import java.util.List;

public interface ArticleRepository extends BaseRepository<Article,Long> {

    Article findByTitle(String title);

    List<Article> findPublishedArticles();

    List<Article> findByUserName(String userName);
}
