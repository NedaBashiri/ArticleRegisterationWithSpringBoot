package com.example.articleregisterationwithspringboot.domains;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;
import com.example.articleregisterationwithspringboot.exception.InValidDataException;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User extends BaseEntity<Long> {

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws InValidDataException {
        if (!userName.matches("(\\w\\d*){3,}")) {
            throw new InValidDataException("Username");
        }
        this.userName = userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) throws InValidDataException {
        if (!nationalCode.matches("\\d{10}")) {
            throw new InValidDataException("National Code");
        }
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

    public void setPassword(String password) throws InValidDataException {
        if (!password.matches("[a-zA-Z0-9]{3,}")) {
            throw new InValidDataException("Password");
        }
        this.password = password;
    }
}
