package com.example.articleregisterationwithspringboot.repository;

import com.example.articleregisterationwithspringboot.base.repository.BaseRepository;
import com.example.articleregisterationwithspringboot.domains.User;

public interface UserRepository extends BaseRepository<User,Long> {

    boolean isUserName(String userName);

    boolean isPassword(String Password);

    User findByUsername(String username);

    User findByPassword(String password);
}
