package cn.tbs.service;

import cn.tbs.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StockService {
    List<User> finAllStocks();
    User getStockById(Integer id);
}


