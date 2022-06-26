package com.example.articleregisterationwithspringboot.base.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseRepository <E, PK extends Serializable>{

    E save(E e);

    E update(E e);

    E findById(PK id);

    List<E> findAll();

    List<E> findAllByIdsIn(Collection<PK> ids);

    void deleteById(PK id);

    void deleteAll();
}
