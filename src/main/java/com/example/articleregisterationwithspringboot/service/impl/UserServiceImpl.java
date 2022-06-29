package com.example.articleregisterationwithspringboot.service.impl;

import com.example.articleregisterationwithspringboot.base.service.impl.BaseServiceImpl;
import com.example.articleregisterationwithspringboot.service.UserService;
import com.example.articleregisterationwithspringboot.domains.User;
import com.example.articleregisterationwithspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    @Autowired
    @Qualifier(value = "userRepository")
    UserRepository userRepository;


    @Override
    public boolean isUserName(String userName) {
        return userRepository.isUserName(userName);
    }

    @Override
    public boolean isPassword(String password) {
        return userRepository.isPassword(password);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }
}
