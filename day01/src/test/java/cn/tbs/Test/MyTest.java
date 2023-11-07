package cn.tbs.Test;

import cn.tbs.dao.UserDao;
import cn.tbs.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void TS1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applictionContext.xml");
        UserDao userDao = classPathXmlApplicationContext.getBean("userDao", UserDao.class);
        userDao.getUser();

    }

    @Test
    public void ts2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applictionContext.xml");
        UserDao userDao = classPathXmlApplicationContext.getBean("userDao", UserDao.class);
        UserDao userDao1 = classPathXmlApplicationContext.getBean("userDao", UserDao.class);
        System.out.println(userDao1);
        System.out.println(userDao);
    }
    @Test
    public void ts3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applictionContext.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
