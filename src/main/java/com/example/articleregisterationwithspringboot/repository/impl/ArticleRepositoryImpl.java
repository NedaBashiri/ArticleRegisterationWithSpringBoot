package com.example.articleregisterationwithspringboot.repository.impl;

import com.example.articleregisterationwithspringboot.base.repository.impl.BaseRepositoryImpl;
import com.example.articleregisterationwithspringboot.domains.Article;
import com.example.articleregisterationwithspringboot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


@Repository
public class ArticleRepositoryImpl extends BaseRepositoryImpl<Article,Long> implements ArticleRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Article findByTitle(String title) {
        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a where a.title=:x", Article.class);
        query.setParameter("x", title);
        Article article = null;
        try {
            article = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return article;
    }
}