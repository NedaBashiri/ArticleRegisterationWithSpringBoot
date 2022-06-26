package com.example.articleregisterationwithspringboot.service;

import com.example.articleregisterationwithspringboot.base.service.BaseService;
import com.example.articleregisterationwithspringboot.domains.User;

public interface UserService extends BaseService<User, Long> {

    boolean isUserName(String userName);

    boolean isPassword(String Password);

    User findByUsername(String username);

    User findByPassword(String password);
}
