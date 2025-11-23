package com.reusexpress.dao.impl;
import com.reusexpress.dao.ProductDAO; import com.reusexpress.model.Product;
import org.hibernate.SessionFactory; import org.hibernate.query.Query; import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository @Transactional
public class ProductDAOImpl implements ProductDAO {
    @Autowired private SessionFactory sessionFactory;
    @Override public Integer save(Product entity) { return (Integer) sessionFactory.getCurrentSession().save(entity); }
    @Override public void update(Product entity) { sessionFactory.getCurrentSession().update(entity); }
    @Override public void delete(Product entity) { sessionFactory.getCurrentSession().delete(entity); }
    @Override public Product findById(Integer id) { return sessionFactory.getCurrentSession().get(Product.class, id); }
    @Override public List<Product> findAll() { return sessionFactory.getCurrentSession().createQuery("from Product order by createdAt desc", Product.class).list(); }
    @Override public List<Product> searchByTitle(String keyword) {
        Query<Product> q = sessionFactory.getCurrentSession().createQuery("from Product where lower(title) like :k", Product.class);
        q.setParameter("k", "%" + keyword.toLowerCase() + "%"); return q.list();
    }
}
