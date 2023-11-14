package com.tutorial.ecommerceapi.service;

import com.tutorial.ecommerceapi.model.Product;
import com.tutorial.ecommerceapi.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getProducts(){
        return productDAO.findAll();
    }
}
