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

@WebServlet(name = "EditarDadosPessoaisServlet", urlPatterns = {"/EditarDadosPessoais"})
public class EditarDadosPessoaisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        Map<String,String> parameters = Util.parseBody(request.getReader());
        Date date = null;

        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get("data"));
        } catch (ParseException e) {
            e.printStackTrace();
            mensagem.put("msg", "Introduza uma data válida");
            out.print(mensagem);
            out.flush();
            return;
        }
        //TODO É para mandar ativo ou não? Se não, mudar para true
        boolean result = FacadeBeans.editarDados(parameters.get("nome"), parameters.get("email"), date, parameters.get("contacto"), Boolean.parseBoolean(parameters.get("jardim")), parameters.get("morada"), parameters.get("password"), parameters.get("avatar"), parameters.get("tipoUtilizador"), parameters.get("concelho"), parameters.get("distrito"), Boolean.parseBoolean(parameters.get("ativo")), session);
        if (result) {
            // TODO: redirecionar?
            mensagem.put("msg", "Dados editados com sucesso.");
        } else {
            // TODO: redirecionar?
            mensagem.put("msg", "Erro na edição de dados.");
        }
        out.print(mensagem);
        out.flush();
    }
}