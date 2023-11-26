package cn.tbs.mapper;

import cn.tbs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select("select * from users where id=#{id}")
    User getUserById(String id);
}
