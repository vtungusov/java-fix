package ru.vtungusov.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        try {
            Statement statement = connection.createStatement();
            /*String sqlInsert = "INSERT INTO fix_user(first_name, last_name) VALUES('" + firstName + "','" + lastName + "');";
            System.out.println(sqlInsert);
            statement.execute(sqlInsert);*/
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO fix_user(first_name, last_name) VALUES (?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private Properties properties;

    @Override
    public void init() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("WEB-INF\\classes\\db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);
    }
}
