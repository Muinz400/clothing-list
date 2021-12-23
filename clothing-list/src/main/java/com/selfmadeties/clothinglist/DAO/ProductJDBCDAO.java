package com.selfmadeties.clothinglist.DAO;

import com.selfmadeties.clothinglist.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductJDBCDAO implements DAO {
    private static final String INSERT_PRODUCT_QUERY = "INSERT INTO product(id, name, quantity, price) values(?,?,?,?)";
    private static final String UPDATE_PRODUCT_BY_ID_QUERY = "UPDATE PRODUCT SET NAME=? WHERE ID=?";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM PRODUCT WHERE ID=?";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM PRODUCT WHERE ID=?";
    private static final String GET_PRODUCT_QUERY = "SELECT * FROM PRODUCT";

    @Autowired
    JdbcTemplate JdbcTemplate;


    @Override
    public Product saveProduct(Product product) {
        JdbcTemplate.update(INSERT_PRODUCT_QUERY, product.getId(), product.getName(), product.getQuantity(), product.getPrice());
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        JdbcTemplate.update(UPDATE_PRODUCT_BY_ID_QUERY, product.getName(), product.getId());
        return null;
    }


    @Override
    public Product getById(int id) {
        return JdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_QUERY, (rs, rowNum) -> {
            return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
        });
    }

    @Override
    public String deleteById(int id) {
        JdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
        return "USER GOT DELETED WITH ID" + id;
    }

    @Override
    public List<Product> allProducts() {
        return JdbcTemplate.query(GET_PRODUCT_QUERY, (rs, rowNum) -> {
            return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));

        });
    }
}



