package com.yh.service.impl;

import com.yh.mapper.RoleMapper;
import com.yh.pojo.Permission;
import com.yh.pojo.Role;
import com.yh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> findAllRoles() {
        return roleMapper.findAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public Role findById(Integer id) {
        System.out.println("findById");
       return  roleMapper.findById(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] ids) {
        for (Integer id : ids) {
            roleMapper.addPermissionToRole(roleId,id);
        }

    }

    @Override
    public List<Permission> findOtherPermission(Integer id) {
        return roleMapper.findOtherPermission(id);
    }
}
