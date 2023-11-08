package com.yh.mapper;

import com.yh.pojo.Product;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface ProductMapper {
    List<Product>findAll();

    void save(Product Product);

    Product findById(int pid);

    void edit(Product Product);


    void deleteById(Integer pid);
}

