package com.yh.service;

import com.yh.pojo.Role;
import com.yh.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAllUsers();
    void save(UserInfo userInfo);
    UserInfo findById(Integer id);

    List<Role> findOtherRole(Integer id);

    void addRoleToUser(Integer userId, Integer[] ids);

    void deleteUserRole(Integer id);

    void deleteUser(Integer id);
}
