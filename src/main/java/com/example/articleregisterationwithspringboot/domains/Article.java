package com.example.articleregisterationwithspringboot.domains;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;
import com.example.articleregisterationwithspringboot.exception.InValidDataException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;


@Entity
@Table(name = "tb_article")
public class Article extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String brief;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(updatable = false, nullable = false)
    private LocalDate Date;

    @Column(name = "is_published",nullable = false)
    private boolean isPublished;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "article_user", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_category", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new TreeSet<>();

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

    public void setTitle(String title) throws InValidDataException {
        if (!title.matches("[a-zA-Z\\s.,&\\d\\(\\)]{5,}")) {
            throw new InValidDataException("Title");
        }
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) throws InValidDataException {
        if (brief.length() < 10) {
            throw new InValidDataException("Brief");
        }
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws InValidDataException {
        if (content.length() < 10) {
            throw new InValidDataException("Content");
        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}