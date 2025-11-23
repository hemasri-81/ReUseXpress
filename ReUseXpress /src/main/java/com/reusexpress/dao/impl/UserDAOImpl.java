package com.reusexpress.dao.impl;
import com.reusexpress.dao.UserDAO; import com.reusexpress.model.User;
import org.hibernate.SessionFactory; import org.hibernate.query.Query; import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository @Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired private SessionFactory sessionFactory;
    @Override public Integer save(User entity) { return (Integer) sessionFactory.getCurrentSession().save(entity); }
    @Override public void update(User entity) { sessionFactory.getCurrentSession().update(entity); }
    @Override public void delete(User entity) { sessionFactory.getCurrentSession().delete(entity); }
    @Override public User findById(Integer id) { return sessionFactory.getCurrentSession().get(User.class, id); }
    @Override public List<User> findAll() { return sessionFactory.getCurrentSession().createQuery("from User", User.class).list(); }
    @Override public User findByUsername(String username) {
        Query<User> q = sessionFactory.getCurrentSession().createQuery("from User where username=:u", User.class);
        q.setParameter("u", username); return q.uniqueResult();
    }
    @Override public User findByEmail(String email) {
        Query<User> q = sessionFactory.getCurrentSession().createQuery("from User where email=:e", User.class);
        q.setParameter("e", email); return q.uniqueResult();
    }
}
