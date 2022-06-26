package com.example.articleregisterationwithspringboot.repository.impl;

import com.example.articleregisterationwithspringboot.base.repository.impl.BaseRepositoryImpl;
import com.example.articleregisterationwithspringboot.domains.Category;
import com.example.articleregisterationwithspringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class CategoryRepositoryImpl extends BaseRepositoryImpl<Category,Long> implements CategoryRepository {

    @Autowired
    EntityManager entityManager;


    @Override
    public Category findByTitle(String title) {
        TypedQuery<Category> query = entityManager.createQuery("SELECT a FROM Category a where a.title=:x", Category.class);
        query.setParameter("x", title);
        Category category = null;
        try {
            category = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return category;
    }
}
