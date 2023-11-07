package cn.tbs.mapper;

import cn.tbs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperImpl implements UserMapper{
    @Override
    public List<User> findAllUsers() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            List<User> list = sqlSession.selectList("user.findAllUsers");
            // 5.释放资源
            sqlSession.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {


    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findUserByParams1(Integer id, String name) {
        return null;
    }

    @Override
    public List<User> findUserByLike1(String username) {
        return null;
    }

    @Override
    public List<User> findUserByLike2(String username) {
        return null;
    }

    @Override
    public List<User> findByIdAndUsernameIf(User user) {
        return null;
    }

    @Override
    public void updateUserSet(User user) {

    }

    @Override
    public List<User> findUsersForEacheList(List<Integer> list) {
        return null;
    }
}
