package com.example.articleregisterationwithspringboot.base.repository.impl;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;
import com.example.articleregisterationwithspringboot.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;

import java.util.Collection;
import java.util.List;

@Repository(value = "baseRepository")
public class BaseRepositoryImpl <E extends BaseEntity<PK>,PK extends Serializable> implements BaseRepository<E,PK> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<E> clazz;


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
    public E findById(PK id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<E> findAll() {
        TypedQuery<E> query = entityManager.createQuery("select o from"+clazz.getSimpleName()+"o",clazz);
        return query.getResultList();
    }

    @Override
    public List<E> findAllByIdsIn(Collection<PK> ids) {

        return null;
    }

    @Override
    public void deleteById(PK id) {
        entityManager.remove(entityManager.getReference(clazz,id));
    }
}
