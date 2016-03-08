package servlet;

import service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rxb14 on 2016/3/8.
 */
public class ChartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List list;
        Service service = new Service();
        try {
            list = service.getProfit();
            request.getSession().setAttribute("PROFIT",list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }
}
