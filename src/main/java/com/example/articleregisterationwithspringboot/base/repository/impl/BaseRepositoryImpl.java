package com.example.articleregisterationwithspringboot.base.repository.impl;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;
import com.example.articleregisterationwithspringboot.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;

import java.util.Collection;
import java.util.List;

@Repository(value = "baseRepository")
public class BaseRepositoryImpl<E extends BaseEntity<PK>, PK extends Serializable> implements BaseRepository<E, PK> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public E save(E e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public E update(E e) {
        entityManager.merge(e);
        return e;
    }

    @Override
    public E findById(Class<E> eClass, PK id) {
        return entityManager.find(eClass, id);
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        TypedQuery<E> query = entityManager.createQuery("select o from" + eClass.getAnnotation(Entity.class).name() + "o", eClass);
        return query.getResultList();
    }

    @Override
    public List<E> findAllByIdsIn(Collection<PK> ids) {

        return null;
    }

    @Override
    public void deleteById(E e) {
        e = entityManager.merge(e);
        entityManager.remove(e);
    }
}
