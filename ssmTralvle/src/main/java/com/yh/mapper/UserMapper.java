package com.yh.mapper;

import com.yh.pojo.Role;
import com.yh.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    UserInfo findUserByUserName(String username);
    List<UserInfo> findAllUsers();
    void save(UserInfo userInfo);
    UserInfo findById(Integer id);

    List<Role> findOtherRoles(Integer id);

    void addRoleToUser(@Param("userId") Integer userId, @Param("roleid") Integer roleid);

    void deleteUserRole(Integer id);

    void deleteUser(Integer id);
}
