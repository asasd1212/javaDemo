package cn.tbs.service;

import cn.tbs.mapper.OrderMapper;
import cn.tbs.mapper.ProductMapper;
import cn.tbs.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImlp implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired

//    @RolesAllowed("ADMIN")
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("authentication.principal.username == 'jack'")
    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public void edit(Product product) {
        productMapper.edit(product);
    }

    @Override
    public void deleteById(Integer id) {
        productMapper.deleteById(id);
    }

    @Override
    public void updateById(Integer id) {
        orderMapper.updateById(id);
    }
}
