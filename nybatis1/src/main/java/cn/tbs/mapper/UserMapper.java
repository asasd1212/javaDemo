package cn.tbs.mapper;

import cn.tbs.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findByIdWithOrder(Integer id);

    User findByIdWithRole(Integer id);
}
