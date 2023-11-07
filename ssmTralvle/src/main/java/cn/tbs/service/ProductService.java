package cn.tbs.service;

import cn.tbs.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);

    Product findById(Integer id);

    void edit(Product product);

    void deleteById(Integer id);
    void updateById(Integer id);
}
