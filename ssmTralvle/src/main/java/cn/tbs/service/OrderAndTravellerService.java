package cn.tbs.service;

import java.util.List;

public interface OrderAndTravellerService {
    void add(Integer orderId, List<Integer> travellerIds);
}
