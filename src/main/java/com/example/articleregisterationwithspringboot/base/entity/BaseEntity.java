package com.example.articleregisterationwithspringboot.base.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<PK extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PK id;

    public void setId(PK id){
        this.id=id;
    }

    public PK getId(){
        return id;

    }
}
