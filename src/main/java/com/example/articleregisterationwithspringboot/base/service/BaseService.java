package com.example.articleregisterationwithspringboot.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseService <E, PK extends Serializable>{

    E save(E e);

    E update(E e);

    E findById(PK id);

    void deleteById(PK id);

    List<E> findAll();

    List<E> findAllByIdsIn(Collection<PK> ids);
}
