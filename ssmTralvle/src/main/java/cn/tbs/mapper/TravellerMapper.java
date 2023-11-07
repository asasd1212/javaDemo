package cn.tbs.mapper;

import cn.tbs.pojo.Traveller;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TravellerMapper {
    List<Traveller> findAll();
}
