package com.reusexpress.service;
import com.reusexpress.model.Product; import java.util.List;
public interface ProductService { Integer save(Product p); void update(Product p); void delete(Product p); Product findById(Integer id); java.util.List<Product> findAll(); java.util.List<Product> search(String keyword); }
