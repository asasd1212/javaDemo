package cn.tbs.dao.impl;

import cn.tbs.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){
        System.out.println("无参被调用了");
    }
    public void getUser(){
        System.out.println("获取用户数据");
    }
}
