package cn.tbs.service;

import cn.tbs.mapper.OrderAndTravellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderAndTravellerServiceImpl implements OrderAndTravellerService{
    @Autowired
    OrderAndTravellerMapper orderAndTravellerMapper;
    @Override
    public void add(Integer orderId, List<Integer> travellerIds) {
        orderAndTravellerMapper.add(orderId,travellerIds);
    }
}
