package cn.tbs.mapper;

import cn.tbs.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper {
   void updateById(Integer id);


   List<Orders> findAll();

    Orders findById(Integer id);

    void save(Orders orders);

    Integer findByOrderNum(String orderNum);
}
