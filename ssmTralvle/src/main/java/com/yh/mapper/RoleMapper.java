package com.yh.mapper;

import com.yh.pojo.Permission;
import com.yh.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper {
    List<Role> findAllRoles();
    void addRole(Role role);

    Role findById(Integer id);

    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

    List<Permission> findOtherPermission(Integer id);

    void deleteRole(Integer id);
    void deleteUser_roleById(Integer id);

    void deleteRole_permission(Integer id);
}
