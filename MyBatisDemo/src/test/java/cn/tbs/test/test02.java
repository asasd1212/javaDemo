package cn.tbs.test;

import cn.tbs.mapper.AdminMapper;
import cn.tbs.mapper.UserMapper;
import cn.tbs.pojo.Admin;
import cn.tbs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class test02 {
    @Test
    public void test01(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            List<Admin> all = sqlSession.getMapper(AdminMapper.class).findAll2();
            all.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("Mybatis.xml");

// 构建SqlSessionFactory工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

// 通过工厂创建SqlSession会话对象
        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.findUserByParams1(41,"老王");
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @Test
    public void test03() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findUserByLike1("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test04() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findUserByLike2("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test06() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"哈哈", new Date(), "男", "河南郑州");
        mapper.save(user);
        System.out.println(user.getId());
    }


    @Test
    public void test07() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        User user = new User();
        user.setSex("男");
        List<User> byIdAndUsernameIf = sqlSession.getMapper(UserMapper.class).findByIdAndUsernameIf(user);
        byIdAndUsernameIf.forEach(System.out::println);
    }

    @Test
    public void test08() throws IOException {
        InputStream is = Resources.getResourceAsStream("Mybatis.xml");

        // 构建SqlSessionFactory工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 通过工厂创建SqlSession会话对象
        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 拼接条件
        User param = new User();
        // param.setId(41);
        // param.setUsername("老王");

        List<User> list = userMapper.findByIdAndUsernameIf(param);

        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test09() throws IOException {
        InputStream is = Resources.getResourceAsStream("Mybatis.xml");

        // 构建SqlSessionFactory工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 通过工厂创建SqlSession会话对象
        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 拼接条件
        User param = new User();
        param.setId(41);
        param.setUsername("王王");

        userMapper.updateUserSet(param);
        sqlSession.commit();
    }

@Test
public void test10() throws IOException {
    InputStream is = Resources.getResourceAsStream("Mybatis.xml");

    // 构建SqlSessionFactory工厂对象
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

    // 通过工厂创建SqlSession会话对象
    SqlSession sqlSession = sessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<Integer> integers = Arrays.asList(41, 42, 43);
    List<User> usersForEacheList = mapper.findUsersForEacheList(integers);
    for (User user : usersForEacheList) {
        System.out.println(user);
    }

}
}
