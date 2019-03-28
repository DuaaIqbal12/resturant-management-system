package org.personal.servletmvc.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.servletmvc.dao.OrderDao;
import org.personal.servletmvc.dao.impl.OrderDaoImpl;
import org.personal.servletmvc.model.Order;

@WebServlet(name = "EmployeeRegister", urlPatterns = {"/"})
public class OrderController extends HttpServlet {

    private final OrderDao orderDao = new OrderDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("action value " + action);
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                save(request, response);
                break;
            case "/edit":
                edit(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            Order employee = new Order();
            employee.setDishName(request.getParameter("name"));
            employee.setPrice(Integer.parseInt(request.getParameter("price")));
            employee.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            employee.setCategory(request.getParameter("category"));
            int result = orderDao.save(employee);
            if (result == 1) {
                findAll(request, response);
            }
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Order employee = orderDao.findOne(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/employee/employee-update.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Order user = new Order();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setDishName(request.getParameter("dishName"));
            user.setPrice(Integer.parseInt(request.getParameter("price")));
            user.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            user.setCategory(request.getParameter("category"));
            System.out.println(user.toString());
            int result = orderDao.update(user);
            if (result == 1) {
                findAll(request, response);
            }
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            orderDao.delete(id);
            findAll(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("employees", orderDao.findAll());
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
