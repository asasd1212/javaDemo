package cn.tbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrderAndTravellerMapper {
    void add(@Param("orderId") Integer orderId, @Param("travellerId") List<Integer> travellerId );
}
