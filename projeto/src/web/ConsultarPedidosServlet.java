package web;
import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Pedido;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ConsultarPedidosServlet", urlPatterns = {"/ConsultarPedidos"})
public class ConsultarPedidosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        List<Pedido> pedidos = FacadeBeans.consultarPedidos((String) request.getSession().getAttribute("user"));

        Gson gson= new Gson();
        String json = gson.toJson(pedidos);

        out.print(json);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\n\n\n\n\nREQUEST: " + request.getParameter("email") + "\n\n\n\n");
    }
}