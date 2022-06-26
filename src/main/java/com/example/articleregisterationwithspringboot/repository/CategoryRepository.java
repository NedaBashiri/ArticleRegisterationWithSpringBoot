package com.example.articleregisterationwithspringboot.repository;

import com.example.articleregisterationwithspringboot.base.repository.BaseRepository;
import com.example.articleregisterationwithspringboot.domains.Category;

public interface CategoryRepository extends BaseRepository<Category,Long> {

    Category findByTitle(String title);
}
