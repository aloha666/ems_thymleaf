package com.springb.dao;

import com.springb.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {

    void save(User user);

    User login(@Param("username") String username, @Param("password") String password);
}
