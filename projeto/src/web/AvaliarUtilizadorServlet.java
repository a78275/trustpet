package web;
import beans.FacadeBeans;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AvaliarUtilizadorServlet", urlPatterns = {"/AvaliarUtilizador"})
public class AvaliarUtilizadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String token = request.getHeader("Token");
        String email = FacadeBeans.validarToken(token);

        if(email!=null) {
            boolean result;
            String tipo = FacadeBeans.tipoUtilizador(email);
            if(tipo.equals("dono")) {
                result = FacadeBeans.avaliarUtilizador(email,(String) parameters.get("emailAlvo"), Integer.parseInt((String) parameters.get("avaliacao")), (String) parameters.get("comentario"), "petsitter");
            }
            else {
                result = FacadeBeans.avaliarUtilizador((String) parameters.get("emailAlvo"), email, Integer.parseInt((String) parameters.get("avaliacao")), (String) parameters.get("comentario"), "dono");
            }
            mensagem.put("success", result);
        }
        else {
            mensagem.put("sucess",false);
        }



        out.print(mensagem);
        out.flush();
    }
}