package com.yh.service.impl;

import com.yh.mapper.OrderMapper;
import com.yh.pojo.Orders;
import com.yh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Orders> findAll() {
        return orderMapper.findAll();
    }
}
