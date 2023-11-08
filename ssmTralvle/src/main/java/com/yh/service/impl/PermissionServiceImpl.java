package com.yh.service.impl;

import com.yh.mapper.PermissionMapper;
import com.yh.pojo.Permission;
import com.yh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionMapper.save(permission);
    }
}
