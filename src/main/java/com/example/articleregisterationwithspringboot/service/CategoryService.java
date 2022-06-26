package com.example.articleregisterationwithspringboot.service;

import com.example.articleregisterationwithspringboot.base.service.BaseService;
import com.example.articleregisterationwithspringboot.domains.Category;

public interface CategoryService extends BaseService<Category,Long> {

    Category findByTitle(String title);
}
