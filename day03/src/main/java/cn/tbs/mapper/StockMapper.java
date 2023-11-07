package cn.tbs.mapper;

import cn.tbs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockMapper {
//    @Select("select * from stock")
    public List<User>findAllStock();

    User getStockById(Integer id);
}
