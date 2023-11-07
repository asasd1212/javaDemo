package cn.tbs;

import cn.tbs.mapper.OrderMapper;
import cn.tbs.mapper.UserMapper;
import cn.tbs.pojo.Order;
import cn.tbs.pojo.User;
import cn.tbs.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    //测试多对多
    @Test
    public void t4(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        User user = sqlSession.getMapper(UserMapper.class).findByIdWithRole(41);
        System.out.println(user);
        sqlSession.close();
    }

    //测试一对多
    @Test
    public void t3(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        User user = sqlSession.getMapper(UserMapper.class).findByIdWithOrder(41);
        System.out.println(user);
        sqlSession.close();
    }

    //测试一对一或者多对一
    @Test
    public void t2(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        Order order = sqlSession.getMapper(OrderMapper.class).findByIdWithUser(1);
        System.out.println(order);
        sqlSession.close();
    }

    @Test
    public void t1(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).findAll();
        System.out.println(userList);
        sqlSession.close();
    }
}
