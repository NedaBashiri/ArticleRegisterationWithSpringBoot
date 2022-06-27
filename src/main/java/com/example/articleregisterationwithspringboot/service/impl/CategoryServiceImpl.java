package com.example.articleregisterationwithspringboot.service.impl;

import com.example.articleregisterationwithspringboot.base.service.impl.BaseServiceImpl;
import com.example.articleregisterationwithspringboot.service.CategoryService;
import com.example.articleregisterationwithspringboot.domains.Category;
import com.example.articleregisterationwithspringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryRepository> implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
