package com.example.articleregisterationwithspringboot.domains;


import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Category(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
