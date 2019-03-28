package org.personal.servletmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.personal.servletmvc.connectionfactory.ConnectionFactory;
import org.personal.servletmvc.model.Customer;
import org.personal.servletmvc.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    @Override
    public int save(Customer employee) throws Exception {
        final String QUERY = "INSERT INTO customer (name, phone_no, table_no) VALUES (?,?,?)";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, employee.getPhone());
        preparedStatement.setInt(2, employee.getTable());
        preparedStatement.setString(3, employee.getName());
//        preparedStatement.setInt(4, employee.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Customer employee) throws Exception {
        final String QUERY = "UPDATE employee set first_name = ?, last_name = ?, address = ?, email = ?, contact=? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement.setInt(1, employee.getPhone());
        preparedStatement.setInt(2, employee.getTable());
        preparedStatement.setString(3, employee.getName());
        preparedStatement.setInt(4, employee.getId());
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
    public List<Customer> findAll() throws Exception {
        List<Customer> employees = new ArrayList<>();
        final String QUERY = "SELECT *FROM employee";
        connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement(QUERY).executeQuery();
        while (rs.next()){
            Customer employee = new Customer();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setPhone(rs.getInt("phone"));
            employee.setTable(rs.getInt("table"));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Customer findOne(int id) throws Exception {
        Customer employee = new Customer();
        final String QUERY = "SELECT *FROM employee where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setPhone(rs.getInt("phone"));
            employee.setTable(rs.getInt("table"));
        }
        return employee;
    }

}
