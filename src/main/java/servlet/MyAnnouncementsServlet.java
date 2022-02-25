package servlet;

import manager.ItemManager;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/myAnnouncements")
public class MyAnnouncementsServlet extends HttpServlet {

    private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        List<Item> myItems = itemManager.getItemsByUserId(user.getId());

        req.setAttribute("myItems", myItems);

        req.getRequestDispatcher("/WEB-INF/myAnnouncements.jsp").forward(req, resp);

    }
}
