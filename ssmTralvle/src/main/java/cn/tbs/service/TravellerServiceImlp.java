package cn.tbs.service;

import cn.tbs.mapper.TravellerMapper;
import cn.tbs.pojo.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TravellerServiceImlp implements TravellerService {
    @Autowired
    TravellerMapper travellerMapper;
    @Override
    public List<Traveller> findAll() {
        return travellerMapper.findAll();
    }
}
