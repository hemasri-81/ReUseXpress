package com.reusexpress.dao;
import com.reusexpress.model.Product; import java.util.List;
public interface ProductDAO extends GenericDAO<Product, Integer>{
    java.util.List<Product> searchByTitle(String keyword);
}
