package com.reusexpress.service.impl;
import com.reusexpress.dao.ProductDAO; import com.reusexpress.model.Product; import com.reusexpress.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductDAO productDAO;
    @Override public Integer save(Product p) { return productDAO.save(p); }
    @Override public void update(Product p) { productDAO.update(p); }
    @Override public void delete(Product p) { productDAO.delete(p); }
    @Override public Product findById(Integer id) { return productDAO.findById(id); }
    @Override public List<Product> findAll() { return productDAO.findAll(); }
    @Override public List<Product> search(String keyword) { return productDAO.searchByTitle(keyword); }
}
