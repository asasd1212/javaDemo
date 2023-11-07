package cn.tbs.mapper;

import cn.tbs.pojo.Order;

public interface OrderMapper {
    Order findByIdWithUser(Integer id);
}
