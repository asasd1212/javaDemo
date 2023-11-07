package cn.tbs.mapper;

import cn.tbs.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 查询所有
    public List<User> findAllUsers();

    // 新增
    public void save(User user);

    // 修改
    public void update(User user);

    // 删除
    public void delete(Integer id);

    List<User> findUserByParams1(@Param("id") Integer id,@Param("name") String name);

    List<User> findUserByLike1(String username);


    List<User> findUserByLike2(String username);


    public List<User> findByIdAndUsernameIf(User user);

    void updateUserSet(User user);

    List<User> findUsersForEacheList(List<Integer> list);
}
