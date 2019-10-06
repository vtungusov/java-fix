package ru.vtungusov.servlets;

import ru.vtungusov.models.User;
import ru.vtungusov.repositories.UsersRepository;
import ru.vtungusov.repositories.UsersRepositoryInMemoryImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet ("/signUp")
public class SignUpServlet extends HttpServlet {
    private UsersRepository usersRepository;

    @Override
    public void init() {
        this.usersRepository = new UsersRepositoryInMemoryImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        this.usersRepository.save(new User(name, password, birthDate));
        /*RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);*/
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = this.usersRepository.findAll();

        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }
}
