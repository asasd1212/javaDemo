package cn.tbs.service;

import cn.tbs.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao dao;
    public void save() {
        dao.save();
        System.out.println("保存成功~~");
    }

    public void update() {
        dao.update();
    }

    public String go(String address) {
        System.out.println(1/0);
        return "去"+ address;

    }
}
