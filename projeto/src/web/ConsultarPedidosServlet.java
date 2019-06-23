package web;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ConsultarPedidosServlet", urlPatterns = {"/ConsultarPedidos"})
public class ConsultarPedidosServlet extends HttpServlet {
}