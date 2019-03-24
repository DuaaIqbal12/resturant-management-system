package org.personal.servletmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.personal.servletmvc.connectionfactory.ConnectionFactory;
import org.personal.servletmvc.model.User;
import org.personal.servletmvc.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    @Override
    public int save(User employee) throws Exception {
        final String QUERY = "INSERT INTO employee (first_name, last_name, address, contact, email) VALUES (?,?,?,?,?)";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getAddress());
        preparedStatement.setString(4, employee.getContact());
        preparedStatement.setString(5, employee.getEmail());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(User employee) throws Exception {
        final String QUERY = "UPDATE employee set first_name = ?, last_name = ?, address = ?, email = ?, contact=? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getAddress());
        preparedStatement.setString(4, employee.getEmail());
        preparedStatement.setString(5, employee.getContact());
        preparedStatement.setInt(6, employee.getId());
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
    public List<User> findAll() throws Exception {
        List<User> employees = new ArrayList<>();
        final String QUERY = "SELECT *FROM employee";
        connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement(QUERY).executeQuery();
        while (rs.next()){
            User employee = new User();
            employee.setId(rs.getInt("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setAddress(rs.getString("address"));
            employee.setContact(rs.getString("contact"));
            employee.setEmail(rs.getString("email"));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public User findOne(int id) throws Exception {
        User employee = new User();
        final String QUERY = "SELECT *FROM employee where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            employee.setId(rs.getInt("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setAddress(rs.getString("address"));
            employee.setContact(rs.getString("contact"));
            employee.setEmail(rs.getString("email"));
        }
        return employee;
    }

}
