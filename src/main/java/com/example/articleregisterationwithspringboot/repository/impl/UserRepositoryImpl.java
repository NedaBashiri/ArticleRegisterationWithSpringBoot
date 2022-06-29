package com.example.articleregisterationwithspringboot.repository.impl;

import com.example.articleregisterationwithspringboot.base.repository.impl.BaseRepositoryImpl;
import com.example.articleregisterationwithspringboot.domains.User;
import com.example.articleregisterationwithspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository("userRepository")
public class UserRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean isUserName(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT a FROM User a where a.userName=:username", User.class);
        query.setParameter("username", username);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return (user == null) ? false : true;
    }

    @Override
    public boolean isPassword(String password) {
        TypedQuery<User> query = entityManager.createQuery("SELECT a FROM User a where a.password=:password", User.class);
        query.setParameter("password", password);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }


        return (user == null) ? false : true;
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT a FROM User a where a.userName=:x", User.class);
        query.setParameter("x", username);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public User findByPassword(String password) {
        TypedQuery<User> query = entityManager.createQuery("SELECT a FROM User a where a.password=:x", User.class);
        query.setParameter("x", password);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }
}
