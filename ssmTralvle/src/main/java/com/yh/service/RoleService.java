package com.yh.service;

import com.yh.pojo.Permission;
import com.yh.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    void addRole(Role role);

    Role findById(Integer id);

    void addPermissionToRole(Integer roleId, Integer[] ids);

    List<Permission> findOtherPermission(Integer id);
}
