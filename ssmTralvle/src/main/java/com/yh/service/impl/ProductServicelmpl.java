package com.yh.service.impl;

import com.yh.mapper.OrderMapper;
import com.yh.mapper.ProductMapper;
import com.yh.pojo.Product;
import com.yh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class ProductServicelmpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
   @Autowired
    OrderMapper orderMapper;
    @RolesAllowed("ADMIN")
    @Override
    public List<Product> findAll(){return productMapper.findAll();}

    @Override
    public void save(Product Product) {
        productMapper.save(Product);
    }

    @Override
    public Product editById(int pid) {
        return productMapper.findById(pid);
    }

    @Override
    public void deleteById(Integer pid) {
        System.out.println(pid);
        orderMapper.updateById(pid);
        productMapper.deleteById(pid);
    }

    @Override
    public void edit(Product product){
        productMapper.edit(product);
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

}



