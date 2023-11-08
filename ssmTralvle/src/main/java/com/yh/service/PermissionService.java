package com.yh.service;

import com.yh.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();
    void save(Permission permission);
}
