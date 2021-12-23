package com.selfmadeties.clothinglist.DAO;

import com.selfmadeties.clothinglist.entity.Product;

import java.util.List;
import java.util.Optional;

public interface DAO {
        Product saveProduct(Product product);
        Product updateProduct(Product product);
        Product getById(int id);
        String deleteById(int id);
        List<Product> allProducts();


    }

