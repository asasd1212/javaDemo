package com.yh.mapper;

import com.yh.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper {

void updateById(Integer pdi);


 List<Orders> findAll();
}
