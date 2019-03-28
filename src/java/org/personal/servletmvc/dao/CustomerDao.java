package org.personal.servletmvc.dao;

import java.util.List;
import org.personal.servletmvc.model.Customer;

public interface CustomerDao {
    
    int save(Customer employee) throws Exception;
    
    int update(Customer employee) throws Exception;
    
    int delete(int id) throws Exception;
    
    List<Customer> findAll() throws Exception;
    
    Customer findOne(int id) throws Exception;
    
}
