package cn.tbs.service;

import cn.tbs.pojo.User;

public interface UserService {
    User findByUserName(String username);
}
