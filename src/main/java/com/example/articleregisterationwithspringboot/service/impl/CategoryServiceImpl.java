package com.example.articleregisterationwithspringboot.service.impl;

import com.example.articleregisterationwithspringboot.base.service.impl.BaseServiceImpl;
import com.example.articleregisterationwithspringboot.service.CategoryService;
import com.example.articleregisterationwithspringboot.domains.Category;
import com.example.articleregisterationwithspringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryRepository> implements CategoryService {


    @Autowired
    @Qualifier(value = "categoryRepository")
    CategoryRepository categoryRepository;


    @Override
    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
