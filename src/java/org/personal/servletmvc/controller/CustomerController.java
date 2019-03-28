package org.personal.servletmvc.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.servletmvc.dao.impl.CustomerDaoImpl;
import org.personal.servletmvc.model.Customer;
import org.personal.servletmvc.dao.CustomerDao;

@WebServlet(name = "EmployeeRegister", urlPatterns = {"/"})
public class CustomerController extends HttpServlet {

    private final CustomerDao customerDao = new CustomerDaoImpl();

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
        request.getRequestDispatcher("/customer.jsp").forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            Customer employee = new Customer();
            employee.setTable(Integer.parseInt(request.getParameter("table")));
            employee.setPhone(Integer.parseInt(request.getParameter("phone")));
            employee.setName(request.getParameter("name"));
            int result = customerDao.save(employee);
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
            Customer employee = customerDao.findOne(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/employee/employee-update.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(request.getParameter("id")));
            customer.setName(request.getParameter("name"));
            customer.setPhone(Integer.parseInt(request.getParameter("phone")));
            customer.setTable(Integer.parseInt(request.getParameter("table")));
            System.out.println(customer.toString());
            int result = customerDao.update(customer);
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
            customerDao.delete(id);
            findAll(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("employees", customerDao.findAll());
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
