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

        String emailDono = FacadeBeans.validarToken(token);
        //TODO:apagar
        System.out.println(emailDono);

        if(emailDono != null) {
            List<Pedido> pedidos = FacadeBeans.consultarPedidos(emailDono);

            //TODO: APAGAR
            for (Pedido p : pedidos){
                System.out.println(p.getId());
            }

            // Não existem pedidos
            if (pedidos == null) {
                mensagem.put("sucess", false);
            }
            else {
                mensagem.put("sucess",true);
                mensagem.put("pedidos", Util.parsePedidosList(pedidos));
            }
        }
        else {
            mensagem.put("sucess", false);
        }

        out.print(mensagem);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}