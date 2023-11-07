package cn.tbs.test;

import cn.tbs.mapper.UserMapper;
import cn.tbs.mapper.UserMapperImpl;
import cn.tbs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class test01 {
    @Test
    public void query() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        List<User> list = sqlSession.selectList("UserMapper.findAllUsers");
        list.forEach(System.out::println);

    }
@Test
    public void add() throws IOException {
    InputStream resourceAsStream = null;
    SqlSession sqlSession = null;

    try {
        resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = build.openSession();
        User user = new User(null, "张三", new Date(), "男", "郑州");
        sqlSession.insert("user.addUser",user);
       sqlSession.commit();
    } catch (Exception e) {
        e.printStackTrace();
        sqlSession.rollback();
    } finally {
        sqlSession.close();
        resourceAsStream.close();
    }


    }
    @Test
    public void update(){
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession();
            User user = new User(51,"李四",new Date(),"女","上海");
            int update = sqlSession.update("user.updateUser", user);
            System.out.println(update);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(resourceAsStream != null){
                    resourceAsStream.close();
                }
                if(sqlSession != null){
                    sqlSession.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    @Test
    public void delete(){
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;

        try {
            resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession();
            int delete = sqlSession.delete("user.deleteUser", 51);
            System.out.println(delete);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession.close();
        }

    }
    @Test
    public void UserMapperTest(){
        UserMapper userMapper = new UserMapperImpl();
        List<User> list = userMapper.findAllUsers();
        list.forEach(System.out::println);
    }
    @Test
    public void query2(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            List<User> all = sqlSession.getMapper(UserMapper.class).findAllUsers();
            all.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void add2(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            User user = new User();
            user.setId(null);
            user.setUsername("德玛西亚");
            user.setSex("男");
            user.setAddress("约德尔城");
            user.setBirthday(new Date());
           sqlSession.getMapper(UserMapper.class).save(user);
           sqlSession.commit();
            sqlSession.close();
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete2(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            sqlSession.getMapper(UserMapper.class).delete(61);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test01(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
