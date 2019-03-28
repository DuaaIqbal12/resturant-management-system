package org.personal.servletmvc.dao;

import java.util.List;
import org.personal.servletmvc.model.Order;

public interface OrderDao {
    
    int save(Order order) throws Exception;
    
    int update(Order order) throws Exception;
    
    int delete(int id) throws Exception;
    
    List<Order> findAll() throws Exception;
    
    Order findOne(int id) throws Exception;
    
}
