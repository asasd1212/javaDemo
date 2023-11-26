package cn.tbs.service.impl;

import cn.tbs.mapper.UserMapper;
import cn.tbs.pojo.User;
import cn.tbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
