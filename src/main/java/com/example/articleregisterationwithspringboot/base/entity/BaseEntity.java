package com.example.articleregisterationwithspringboot.base.entity;

import java.io.Serializable;

public class BaseEntity<PK extends Serializable> implements Serializable {

    private PK id;

    public void setId(PK id){
        this.id=id;
    }

    public PK getId(){
        return id;

    }
}
