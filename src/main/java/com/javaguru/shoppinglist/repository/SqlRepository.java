package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.Product;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

public class SqlRepository {

    private Connection connection = null;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public SqlRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public Product saveProduct(Product product) {
        PreparedStatement preparedStatement;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM product");
            resultSet.next();
            int id = resultSet.getInt(1);
            product.setId(id + 1);
            String query = "INSERT INTO product (" +
                    "name, category, description, price, discount" +
                    ") " +
                    "VALUES (" +
                    "?, ?, ?, ?, ?" +
                    ");";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.setBigDecimal(5, product.getDiscount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public Product getProduct(int id) {
        Product retrievedProduct = new Product();
        try {
            connection = dataSource.getConnection();
            String query = "SELECT * FROM product WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                retrievedProduct.setId(resultSet.getInt("id"));
                retrievedProduct.setName(resultSet.getString("name"));
                retrievedProduct.setCategory(resultSet.getString("category"));
                retrievedProduct.setDescription(resultSet.getString("description"));
                retrievedProduct.setPrice(resultSet.getBigDecimal("price"));
                retrievedProduct.setDiscount(resultSet.getBigDecimal("discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return retrievedProduct;
    }

    public List<String> getProductRepository() {
        List<String> productRepository = jdbcTemplate.queryForList("SELECT name FROM product", String.class);
        return productRepository;
    }
}
