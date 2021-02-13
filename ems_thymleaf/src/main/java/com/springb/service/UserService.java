package com.springb.service;

import com.springb.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void register(User user);
    User login(String username, String password);
}
