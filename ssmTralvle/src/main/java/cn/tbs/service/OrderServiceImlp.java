package cn.tbs.service;

import cn.tbs.mapper.OrderMapper;
import cn.tbs.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImlp implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Orders> findAll() {
        System.out.println("OrderService");
        return orderMapper.findAll();

    }

    @Override
    public Orders findById(Integer id) {
        return orderMapper.findById(id);
    }

    @Override
    public void save(Orders orders) {
        orderMapper.save(orders);
    }

    @Override
    public Integer findByOrderNum(String orderNum) {
        return this.orderMapper.findByOrderNum(orderNum);
    }
}
