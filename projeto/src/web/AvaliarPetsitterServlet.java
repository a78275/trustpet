package web;
import beans.FacadeBeans;
import org.json.JSONObject;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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

        if (result) {
            // TODO: redirecionar?
            mensagem.put("msg", "Avaliação feita com sucesso.");
        } else {
            // TODO: redirecionar?
            mensagem.put("msg", "Erro na avaliação.");
        }
        out.print(mensagem);
        out.flush();
    }
}