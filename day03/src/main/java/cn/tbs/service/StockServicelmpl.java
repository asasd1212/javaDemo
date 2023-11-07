package cn.tbs.service;



import cn.tbs.mapper.StockMapper;
import cn.tbs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockServicelmpl implements StockService {
    @Autowired
    StockMapper stockMapper;
    @Override
    public List<User> finAllStocks() {
        return stockMapper.findAllStock();
    }

    @Override
    public User getStockById(Integer id) {
        System.out.println("service"+id);
        return stockMapper.getStockById(id);
    }


}


