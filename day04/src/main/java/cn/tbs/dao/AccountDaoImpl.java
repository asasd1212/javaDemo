package cn.tbs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void outUser(String user, Double money) {
        // 1.编写sql
        String sql = "update account set money = money - ? where name = ?";
        // 2.执行sql
        jdbcTemplate.update(sql, money,user);
    }

    public void inUser(String user, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        // 2.执行sql
        jdbcTemplate.update(sql, money,user);
    }
}
