package org.personal.servletmvc.connectionfactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/resturant";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

}
