package learn.angular.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import learn.angular.model.User;
import learn.angular.repository.UserRepository;
import learn.angular.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
        userRepository.save(new User("Jack Sparrow", "Black Pearl", "jsparrow@sea.org"));
        userRepository.save(new User("John Silver", "Treasure Island", "jsilver@sea.org"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        List<User> users = userRepository.findAll();
        resp.getWriter().println(gson.toJson(users));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = gson.fromJson(req.getReader(), User.class);
        userRepository.save(user);
    }
}
