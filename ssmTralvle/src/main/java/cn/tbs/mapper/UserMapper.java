package cn.tbs.mapper;

import cn.tbs.pojo.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserInfo findUserByUserName(String s);

    List<UserInfo> findAllUsers();
}
