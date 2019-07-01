package web;
import beans.FacadeBeans;
import main.Pedido;
import org.json.JSONArray;
import org.json.JSONObject;

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
        JSONObject mensagem = new JSONObject();
        String token = request.getHeader("Token");

        String email = FacadeBeans.validarToken(token);

        if(email != null) {
            List<Pedido> pedidos = FacadeBeans.consultarPedidos(email);

            // Erro nos beans
            if (pedidos == null) {
                mensagem.put("success", false);
            }
            else {
                mensagem.put("success",true);
                mensagem.put("pedidos", Util.parsePedidosList(pedidos));
            }
        }
        else {
            mensagem.put("success", false);
        }

        out.print(mensagem);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}