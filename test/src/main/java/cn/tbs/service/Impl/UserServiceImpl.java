package cn.tbs.service.Impl;

import cn.tbs.mapper.UserMapper;
import cn.tbs.pojo.User;
import cn.tbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User findByUserName(String username){
        return userMapper.findByUserName(username);
    }
}
