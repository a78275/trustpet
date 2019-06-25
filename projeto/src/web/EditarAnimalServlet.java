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
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());
        boolean result;

        if(!parameters.keySet().contains("id") || parameters.get("id").toString().equals("")) {
            result = FacadeBeans.registarAnimal((String) parameters.get("emailDono"), (String) parameters.get("nome"), Integer.parseInt((String) parameters.get("idade")), (String) parameters.get("porte"), (String) parameters.get("sexo"), (String) parameters.get("alergias"), (String) parameters.get("doencas"), (String) parameters.get("comportamento"), Boolean.parseBoolean((String) parameters.get("vacinas")), Boolean.parseBoolean((String) parameters.get("desparasitacao")), Boolean.parseBoolean((String) parameters.get("esterilizacao")), (String) parameters.get("raca"), (String) parameters.get("avatar"), Integer.parseInt((String) parameters.get("tipo")));
            if (result) {
                mensagem.put("sucess",true);
            } else {
                // Falha no registo do animal
                mensagem.put("sucess",false);
            }
        }
        else {
            result = FacadeBeans.editarAnimal(Integer.parseInt((String) parameters.get("id")), (String) parameters.get("nome"), Integer.parseInt((String) parameters.get("idade")), (String) parameters.get("porte"), (String) parameters.get("sexo"), (String) parameters.get("alergias"), (String) parameters.get("doencas"), (String) parameters.get("comportamento"), Boolean.parseBoolean((String) parameters.get("vacinas")), Boolean.parseBoolean((String) parameters.get("desparasitacao")), Boolean.parseBoolean((String) parameters.get("esterilizacao")), (String) parameters.get("raca"), (String) parameters.get("avatar"), Boolean.parseBoolean((String) parameters.get("ativo")));
            if (result) {
                mensagem.put("sucess",true);
            } else {
                // Falha na edição do animal
                mensagem.put("sucess",false);
            }
        }

        out.print(mensagem);
        out.flush();
    }
}