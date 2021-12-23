package com.selfmadeties.clothinglist.Controller;

import com.selfmadeties.clothinglist.DAO.ProductJDBCDAO;
import com.selfmadeties.clothinglist.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductJDBCDAO productJDBCDAO;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productJDBCDAO.saveProduct(product);

    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productJDBCDAO.updateProduct(product);

    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productJDBCDAO.getById(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productJDBCDAO.allProducts();

    }
}


