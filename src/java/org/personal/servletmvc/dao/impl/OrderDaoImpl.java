package org.personal.servletmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.personal.servletmvc.connectionfactory.ConnectionFactory;
import org.personal.servletmvc.dao.OrderDao;
import org.personal.servletmvc.model.Order;

public class OrderDaoImpl implements OrderDao {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

//    @Override
    public int save(Order order) throws Exception {
        final String QUERY = "INSERT INTO order (first_name, last_name, address, contact, email) VALUES (?,?,?,?,?)";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, order.getDishName());
        preparedStatement.setString(2, order.getCategory());
        preparedStatement.setInt(3, order.getPrice());
        preparedStatement.setInt(4, order.getQuantity());
        return preparedStatement.executeUpdate();
    }

//    @Override
    public int update(Order order) throws Exception {
        final String QUERY = "UPDATE order set first_name = ?, last_name = ?, address = ?, email = ?, contact=? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, order.getDishName());
        preparedStatement.setString(2, order.getCategory());
        preparedStatement.setInt(3, order.getPrice());
        preparedStatement.setInt(4, order.getQuantity());
        preparedStatement.setInt(5, order.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws Exception {
        final String QUERY = "DELETE FROM order where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

//    @Override
    public List<Order> findAll() throws Exception {
        List<Order> orders = new ArrayList<>();
        final String QUERY = "SELECT *FROM order";
        connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement(QUERY).executeQuery();
        while (rs.next()){
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setDishName(rs.getString("first_name"));
            order.setPrice(rs.getInt("last_name"));
            order.setQuantity(rs.getInt("address"));
            order.setCategory(rs.getString("contact"));
            orders.add(order);
        }
        return orders;
    }

//    @Override
    public Order findOne(int id) throws Exception {
        Order order = new Order();
        final String QUERY = "SELECT *FROM order where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            order.setId(rs.getInt("id"));
            order.setDishName(rs.getString("first_name"));
            order.setPrice(rs.getInt("last_name"));
            order.setQuantity(rs.getInt("address"));
            order.setCategory(rs.getString("contact"));
        }
        return order;
    }

 
}
