package com.example.articleregisterationwithspringboot.base.domains;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "national_code")
    private String nationalCode;

    private String birthday;
    private String password;

    public User() {
    }

    public User(String userName, String nationalCode, String birthday, String password) {
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }

    public User(Long id, String userName, String nationalCode, String birthday, String password) {
        this.id = id;
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
