package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2018/5/30.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询
     * @return
     */
    @Override
    @Cacheable(value="list",key="1")//在redis中开启key为list开头的存储空间
    public List<User> list() {
        System.out.println("hah");
        return userMapper.selectByExample(null);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    @Override
    @CacheEvict(value="list",allEntries=true)//执行此方法的时候删除上面的缓存(以findAllUser为名称的)
    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加
     * @param user
     */
    @Transactional
    @Override
    @CacheEvict(value="list",allEntries=true)//执行此方法的时候删除上面的缓存(以findAllUser为名称的)
    public void add(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Transactional
    @Override
    @CacheEvict(value="list",allEntries=true)//执行此方法的时候删除上面的缓存(以findAllUser为名称的)
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
