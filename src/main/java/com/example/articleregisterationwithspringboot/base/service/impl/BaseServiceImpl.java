package com.example.articleregisterationwithspringboot.base.service.impl;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;
import com.example.articleregisterationwithspringboot.base.repository.BaseRepository;
import com.example.articleregisterationwithspringboot.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class BaseServiceImpl<E extends BaseEntity, PK extends Serializable, Repository extends BaseRepository<E, PK>> implements BaseService<E, PK>  {

    @Autowired
    protected Repository baseRepository;


    @Override
    public E save(E e) {
        return  baseRepository.save(e);
    }

    @Override
    public E update(E e) {
        return baseRepository.update(e);
    }

    @Override
    public E findById(PK id) {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteById(PK id) {
        baseRepository.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<E> findAllByIdsIn(Collection<PK> ids) {
        return baseRepository.findAllByIdsIn(ids);
    }
}
