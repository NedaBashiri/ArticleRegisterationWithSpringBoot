package com.example.articleregisterationwithspringboot.domains;

import com.example.articleregisterationwithspringboot.base.entity.BaseEntity;
import com.example.articleregisterationwithspringboot.exception.InValidDataException;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User extends BaseEntity<Long> {

    @Column(name = "username")
    @Size(min = 3, message = "نام باید بیشتر از دو کاراکتر باشد")
    private String userName;

    @Column(name = "national_code")
    @Pattern(regexp = "[0-9]{10}", message = "کد ملی 10 رقمی است")
    private String nationalCode;

    private String birthdate;

    @Min(value = 4, message = "پسورد بیشتر از 4 کاراکتر باشد")
    private String password;

    public User() {
    }

    public User(String userName, String nationalCode, String birthdate, String password) {
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.birthdate = birthdate;
        this.password = password;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
