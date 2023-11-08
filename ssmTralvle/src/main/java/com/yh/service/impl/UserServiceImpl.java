package com.yh.service.impl;

import com.yh.mapper.UserMapper;
import com.yh.pojo.Role;
import com.yh.pojo.UserInfo;


import com.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Lazy
    @Resource
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userMapper.findUserByUserName(username);
            User user = null;
            if (userInfo!=null){
                List<SimpleGrantedAuthority>simpleGrantedAuthorities=new ArrayList<>();
                List<Role>roles=userInfo.getRoles();
                for (Role role:roles){
                    simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
                }
                user=new User(userInfo.getUsername(),
                        userInfo.getPassword(),
                        userInfo.getStatus()==0?false:true,
                        true,
                        true,
                        true,
                        simpleGrantedAuthorities);
            }
        System.out.println(userInfo.getUsername());
        System.out.println(userInfo.getRoles());
        return user;
    }


    @Override
    public List<UserInfo> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userMapper.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<Role> findOtherRole(Integer id) {
        return userMapper.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        for (Integer id : ids) {
            System.out.println(userId + "---"+ id);
            userMapper.addRoleToUser(userId,id);
        }
    }

    @Override
    public void deleteUserRole(Integer id) {
        userMapper.deleteUserRole(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}

