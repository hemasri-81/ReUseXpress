package com.reusexpress.service.impl;
import com.reusexpress.dao.UserDAO; import com.reusexpress.model.User; import com.reusexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserDAO userDAO;
    @Override public Integer register(User user) { return userDAO.save(user); }
    @Override public User findByUsername(String username) { return userDAO.findByUsername(username); }
    @Override public User findById(Integer id) { return userDAO.findById(id); }
    @Override public List<User> findAll() { return userDAO.findAll(); }
}
