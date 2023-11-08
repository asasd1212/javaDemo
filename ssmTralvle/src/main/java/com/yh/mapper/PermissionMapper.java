package com.yh.mapper;

import com.yh.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PermissionMapper {

    List<Permission> findAll();
    void save(Permission permission);
}
