package org.personal.servletmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.personal.servletmvc.connectionfactory.ConnectionFactory;
import org.personal.servletmvc.model.Menu;
import org.personal.servletmvc.dao.MenuDao;

public class MenuDaoImpl implements MenuDao {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    @Override
    public int save(Menu employee) throws Exception {
        final String QUERY = "INSERT INTO menu (menu_id, dish_item, price, type, image) VALUES (?,?,?,?,?)";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
//        preparedStatement.setInt(5, employee.getId());
        preparedStatement.setString(1, employee.getDishItem());
        preparedStatement.setInt(2, employee.getPrice());
        preparedStatement.setString(3, employee.getType());
        preparedStatement.setString(4, employee.getImage());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Menu employee) throws Exception {
        final String QUERY = "UPDATE employee set dish_item = ?, price = ?, type = ?, image = ? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, employee.getDishItem());
        preparedStatement.setInt(2, employee.getPrice());
        preparedStatement.setString(3, employee.getType());
        preparedStatement.setString(4, employee.getImage());
        preparedStatement.setInt(5, employee.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws Exception {
        final String QUERY = "DELETE FROM employee where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Menu> findAll() throws Exception {
        List<Menu> employees = new ArrayList<>();
        final String QUERY = "SELECT *FROM employee";
        connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement(QUERY).executeQuery();
        while (rs.next()){
            Menu employee = new Menu();
            employee.setId(rs.getInt("id"));
            employee.setDishItem(rs.getString("dish_item"));
            employee.setPrice(rs.getInt("price"));
            employee.setType(rs.getString("type"));
            employee.setImage(rs.getString("image"));
            employees.add(employee);
        }
        return employees;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Menu findOne(int id) throws Exception {
        Menu employee = new Menu();
        final String QUERY = "SELECT *FROM employee where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            employee.setId(rs.getInt("id"));
            employee.setDishItem(rs.getString("dish_item"));
            employee.setPrice(rs.getInt("price"));
            employee.setType(rs.getString("type"));
            employee.setImage(rs.getString("image"));
        }
        return employee;
    }

}
