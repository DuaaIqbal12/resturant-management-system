package org.personal.servletmvc.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.servletmvc.dao.UserDao;
import org.personal.servletmvc.dao.impl.UserDaoImpl;
import org.personal.servletmvc.model.User;

@WebServlet(name = "EmployeeRegister", urlPatterns = {"/"})
public class UserController extends HttpServlet {

    private final UserDao userDao = new UserDaoImpl();

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
        request.getRequestDispatcher("/employee/employee-register.jsp").forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            User employee = new User();
            employee.setFirstName(request.getParameter("firstName"));
            employee.setLastName(request.getParameter("lastName"));
            employee.setContact(request.getParameter("contact"));
            employee.setEmail(request.getParameter("email"));
            employee.setAddress(request.getParameter("address"));
            int result = userDao.save(employee);
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
            User employee = userDao.findOne(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/employee/employee-update.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setContact(request.getParameter("contact"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            System.out.println(user.toString());
            int result = userDao.update(user);
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
            userDao.delete(id);
            findAll(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("employees", userDao.findAll());
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
