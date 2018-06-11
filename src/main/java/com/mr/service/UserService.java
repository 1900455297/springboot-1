package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by lenovo on 2018/5/30.
 */
public interface UserService {

    List<User> list();

    void deleteById(Integer id);

    void add(User user);

    User selectById(Integer id);

    void update(User user);
}
