package com.example.articleregisterationwithspringboot.domains;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "tb_article")
public class Article extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    @Size(min = 5, message = " عنوان باید بیشتر از پنج کاراکتر باشد")
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    @Size(min = 10, message = "خلاصه باید بیشتر از ده کاراکتر باشد")
    private String brief;

    @Column(nullable = false, columnDefinition = "text")
    @Size(min = 10, message = "محتوا باید بیشتر از ده کاراکتر باشد")
    private String content;

    @Column(name = "create_date", updatable = false, nullable = false)
    private LocalDate createDate;

    @Column(name = "published", nullable = false)
    private boolean published;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "article_user", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "article_category", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Category category;

    public Article() {
    }

    public Article(String title, String brief, String content, LocalDate createDate, boolean published) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.published = published;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}