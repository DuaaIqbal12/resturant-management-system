package org.personal.servletmvc.dao;

import java.util.List;
import org.personal.servletmvc.model.User;

public interface UserDao {
    
    int save(User employee) throws Exception;
    
    int update(User employee) throws Exception;
    
    int delete(int id) throws Exception;
    
    List<User> findAll() throws Exception;
    
    User findOne(int id) throws Exception;
    
}
