package cn.tbs.service;

import cn.tbs.pojo.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();

    Orders findById(Integer id);

    void save(Orders orders);

    Integer findByOrderNum(String orderNum);
}
