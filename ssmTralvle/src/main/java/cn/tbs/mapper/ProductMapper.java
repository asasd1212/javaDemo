package cn.tbs.mapper;
import cn.tbs.pojo.Product;
import cn.tbs.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import cn.tbs.pojo.UserInfo;

import java.util.List;
@Mapper
public interface ProductMapper {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void edit(Product product);

    void deleteById(Integer id);

    List<UserInfo> findAllUsers();
}
