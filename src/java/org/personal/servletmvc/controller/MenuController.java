package org.personal.servletmvc.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.personal.servletmvc.dao.MenuDao;
import org.personal.servletmvc.dao.impl.MenuDaoImpl;
import org.personal.servletmvc.model.Menu;

@WebServlet(name = "EmployeeRegister", urlPatterns = {"/"})
public class MenuController extends HttpServlet {

    private final MenuDao menuDao = (MenuDao) new MenuDaoImpl();

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
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            Menu employee = new Menu();
            employee.setDishItem(request.getParameter("dishItem"));
            employee.setPrice(Integer.parseInt(request.getParameter("price")));
            employee.setType(request.getParameter("type"));
            employee.setImage(request.getParameter("image"));
            int result = menuDao.save(employee);
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
            Menu employee = menuDao.findOne(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/employee/employee-register.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Menu menu = new Menu();
            menu.setId(Integer.parseInt(request.getParameter("id")));
  menu.setDishItem(request.getParameter("dishItem"));
            menu.setPrice(Integer.parseInt(request.getParameter("price")));
            menu.setType(request.getParameter("type"));
            menu.setImage(request.getParameter("image"));
            System.out.println(menu.toString());
            int result = menuDao.update(menu);
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
            menuDao.delete(id);
            findAll(request, response);
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("employees", menuDao.findAll());
        } catch (Exception ex) {
            System.out.println("exception " + ex.getMessage());
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
