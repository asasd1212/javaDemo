package cn.tbs.dao;

import cn.tbs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements  EmployeeDao{
    @Autowired
    private EmployeeDao employeeDao;
    public void save() {
        System.out.println("执行保存操作..............");
    }

    public void update() {
        System.out.println("执行更新操作..............");
    }
}
