package com.reusexpress.dao;
import com.reusexpress.model.User;
public interface UserDAO extends GenericDAO<User, Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
}
