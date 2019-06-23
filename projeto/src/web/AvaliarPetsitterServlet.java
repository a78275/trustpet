package web;
import beans.FacadeBeans;
import main.FacadeDAOs;
import org.json.JSONObject;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        Map<String,String> parameters = Util.parseBody(request.getReader());

        boolean result = FacadeBeans.avaliarUtilizador(parameters.get("emailDono"), parameters.get("emailPetsitter"), Integer.parseInt(parameters.get("avaliacao")), parameters.get("comentario"), parameters.get("alvo"), session);

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