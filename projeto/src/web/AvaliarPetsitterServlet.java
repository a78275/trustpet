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

@WebServlet(name = "AvaliarPetsitterServlet", urlPatterns = {"/AvaliarPetsitter"})
public class AvaliarPetsitterServlet extends HttpServlet {
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

        boolean result = FacadeBeans.avaliarUtilizador((String) parameters.get("emailDono"), (String) parameters.get("emailPetsitter"), Integer.parseInt((String) parameters.get("avaliacao")), (String) parameters.get("comentario"), (String) parameters.get("alvo"));

        mensagem.put("success", result);

        out.print(mensagem);
        out.flush();
    }
}