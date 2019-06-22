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
import java.util.Date;
import java.util.Map;

@WebServlet(name = "EditarAnimalServlet", urlPatterns = {"/EditarAnimal"})
public class EditarAnimalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        Map<String,String> parameters = Util.parseBody(request.getReader());
        boolean result;

        if(!parameters.containsKey("id") || parameters.get("id").equals("")) {
            result = FacadeBeans.registarAnimal(parameters.get("emailDono"), parameters.get("nome"), Integer.parseInt(parameters.get("idade")), parameters.get("porte"), parameters.get("sexo"), parameters.get("alergias"), parameters.get("doencas"), parameters.get("comportamento"), Boolean.parseBoolean(parameters.get("vacinas")), Boolean.parseBoolean(parameters.get("desparasitacao")), Boolean.parseBoolean(parameters.get("esterilizacao")), parameters.get("raca"), parameters.get("avatar"), Integer.parseInt(parameters.get("tipo")),session);
            if (result) {
                // TODO: redirecionar?
                mensagem.put("msg", "Registo do animal feito com sucesso.");
            } else {
                // TODO: redirecionar?
                mensagem.put("msg", "Erro no registo do animal.");
            }
        }
        else {
            result = FacadeBeans.editarAnimal(Integer.parseInt(parameters.get("id")), parameters.get("nome"), Integer.parseInt(parameters.get("idade")), parameters.get("porte"), parameters.get("sexo"), parameters.get("alergias"), parameters.get("doencas"), parameters.get("comportamento"), Boolean.parseBoolean(parameters.get("vacinas")), Boolean.parseBoolean(parameters.get("desparasitacao")), Boolean.parseBoolean(parameters.get("esterilizacao")), parameters.get("raca"), parameters.get("avatar"), Boolean.parseBoolean(parameters.get("ativo")),session);
            if (result) {
                // TODO: redirecionar?
                mensagem.put("msg", "Animal editado com sucesso.");
            } else {
                // TODO: redirecionar?
                mensagem.put("msg", "Erro na edição do animal.");
            }
        }

        out.print(mensagem);
        out.flush();
    }
}