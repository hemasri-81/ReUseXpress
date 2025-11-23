package com.reusexpress.dao;
import java.io.Serializable; import java.util.List;
public interface GenericDAO<T, ID extends Serializable> {
    ID save(T entity); void update(T entity); void delete(T entity); T findById(ID id); List<T> findAll();
}
