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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "RegistarPetsitterServlet", urlPatterns = {"/RegistarPetsitter"})
public class RegistarPetsitterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        Date date = Util.parseDate((String) parameters.get("data"),"dd/MM/yyyy");
        if(date==null) {
            mensagem.put("msg", "Introduza uma data válida");
            out.print(mensagem);
            out.flush();
            return;
        }

        boolean result = FacadeBeans.registarUtilizador((String) parameters.get("nome"), (String) parameters.get("email"), date, (String) parameters.get("contacto"), Boolean.parseBoolean((String) parameters.get("jardim")), (String) parameters.get("morada"), (String) parameters.get("password"), (String) parameters.get("avatar"), "petsitter", (String) parameters.get("concelho"), (String) parameters.get("distrito"),session);
        if (result) {
            // TODO: redirecionar?
            mensagem.put("msg", "Registo de petsitter feito com sucesso.");
        } else {
            // TODO: redirecionar?
            mensagem.put("msg", "Erro no registo.");
        }
        out.print(mensagem);
        out.flush();
    }
}