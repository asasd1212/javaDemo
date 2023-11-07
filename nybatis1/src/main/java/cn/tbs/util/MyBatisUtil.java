package cn.tbs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("Mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession(){
        //默认是手动事务
        return sqlSessionFactory.openSession();
    }

    public static void close(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
