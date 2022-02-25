package servlet;

import manager.ItemManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/itemDetail")
public class ItemDetailServlet extends HttpServlet {

    private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String general = req.getParameter("general");
        String cars = req.getParameter("cars");
        String houses = req.getParameter("houses");
        String commercial = req.getParameter("Commercial");
        String furniture = req.getParameter("furniture");

        if (cars != null){

            List<Item> cars1 = itemManager.getAllCars();
            req.setAttribute("cars",cars1);
            req.getRequestDispatcher("/WEB-INF/allCars.jsp").forward(req,resp);

        }else if (houses != null){

            List<Item> houses1 = itemManager.getAllHouses();
            req.setAttribute("houses",houses1);
            req.getRequestDispatcher("/WEB-INF/allHouses.jsp").forward(req,resp);

        }else if (commercial != null){

            List<Item> allCommercial = itemManager.getAllCommercial();
            req.setAttribute("allCommercial",allCommercial);
            req.getRequestDispatcher("/WEB-INF/allCommercial.jsp").forward(req,resp);

        }else if (furniture != null){

            List<Item> allFurniture = itemManager.getAllFurniture();
            req.setAttribute("allFurniture",allFurniture);
            req.getRequestDispatcher("/WEB-INF/allFurniture.jsp").forward(req,resp);

        }else if (general != null){

            resp.sendRedirect("/userHome");

        }
    }
}
