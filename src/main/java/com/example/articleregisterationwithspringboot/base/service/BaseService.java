package com.example.articleregisterationwithspringboot.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseService <E, PK extends Serializable>{

    E save(E e);

    E update(E e);

    E findById(Class<E> eClass,PK id);

    void deleteById(E e);

    List<E> findAll(Class<E> eClass);

    List<E> findAllByIdsIn(Collection<PK> ids);
}
