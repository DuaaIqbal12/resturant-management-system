package org.personal.servletmvc.dao;

import java.util.List;
import org.personal.servletmvc.model.Menu;

public interface MenuDao {
    
    int save(Menu menu) throws Exception;
    
    int update(Menu menu) throws Exception;
    
    int delete(int id) throws Exception;
    
    List<Menu> findAll() throws Exception;
    
    Menu findOne(int id) throws Exception;
    
}
