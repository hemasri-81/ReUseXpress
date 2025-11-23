package com.reusexpress.service;
import com.reusexpress.model.User; import java.util.List;
public interface UserService { Integer register(User user); User findByUsername(String username); User findById(Integer id); java.util.List<User> findAll(); }
