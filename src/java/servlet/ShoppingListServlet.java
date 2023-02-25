package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Krushang Prajapati
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");

        if (action != null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (username != null) {
            response.sendRedirect("ShoppingList");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        String itemList = request.getParameter("itemlist");
        ArrayList<String> items;

        if (session.getAttribute("items") == null) {
            items = new ArrayList<>();
        } else {
            items = (ArrayList<String>) session.getAttribute("items");
        }

        switch (action) {
            case "add":
                items.add(item);
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;

            case "logout":
                items.clear();
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                break;

            case "delete":
                items.remove(itemList);
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;

            case "register":
                if (username == null || username.equals("")) {
                    request.setAttribute("invalid", true);
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                } else {
                    session.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break;
                }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
