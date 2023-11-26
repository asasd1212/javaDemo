package cn.tbs.mapper;

import cn.tbs.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUserName(String username);
}
