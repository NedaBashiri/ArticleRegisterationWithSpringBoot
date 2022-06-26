package com.example.articleregisterationwithspringboot.domains;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "tb_article")
public class Article extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String brief;
    private String content;
    private LocalDate Date;

    @Column(name = "is_published")
    private boolean isPublished;

    public Article() {
    }

    public Article(String title, String brief, String content, LocalDate date, boolean isPublished) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        Date = date;
        this.isPublished = isPublished;
    }

    public Article(Long id, String title, String brief, String content, LocalDate date, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        Date = date;
        this.isPublished = isPublished;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }
}