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

        Date date = Util.parseDate((String) parameters.get("data"),"dd/MM/yyyy");

        if(date != null) {
            boolean result = FacadeBeans.editarDados((String) parameters.get("nome"), email, date, (String) parameters.get("contacto"), Boolean.parseBoolean((String) parameters.get("jardim")), (String) parameters.get("morada"), Util.hash((String) parameters.get("password")), (String) parameters.get("avatar"), (String) parameters.get("tipoUtilizador"), (String) parameters.get("concelho"), (String) parameters.get("distrito"), true);
            mensagem.put("success", result);
        }
        else {
            mensagem.put("success",false);
        }
        out.print(mensagem);
        out.flush();
    }
}