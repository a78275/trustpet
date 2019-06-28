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
        String token = request.getHeader("Token");
        String email = FacadeBeans.validarToken(token);

        boolean result;

        // Registar Animal (sem id)
        if(!parameters.keySet().contains("id")) {
            result = FacadeBeans.registarAnimal(email, (String) parameters.get("nome"), (String) parameters.get("idade"), (String) parameters.get("porte"), (String) parameters.get("sexo"), (String) parameters.get("alergias"), (String) parameters.get("doencas"), (String) parameters.get("comportamento"), Boolean.parseBoolean((String) parameters.get("vacinas")), Boolean.parseBoolean((String) parameters.get("desparasitacao")), Boolean.parseBoolean((String) parameters.get("esterilizacao")), (String) parameters.get("raca"), (String) parameters.get("avatar"), Integer.parseInt((String) parameters.get("tipo")));
            mensagem.put("success", result);
        }
        // Editar Animal (sem ativo)
        else if (!parameters.keySet().contains("ativo")){
            result = FacadeBeans.editarAnimal(Integer.parseInt((String) parameters.get("id")), (String) parameters.get("nome"), (String) parameters.get("idade"), (String) parameters.get("porte"), (String) parameters.get("sexo"), (String) parameters.get("alergias"), (String) parameters.get("doencas"), (String) parameters.get("comportamento"), Boolean.parseBoolean((String) parameters.get("vacinas")), Boolean.parseBoolean((String) parameters.get("desparasitacao")), Boolean.parseBoolean((String) parameters.get("esterilizacao")), (String) parameters.get("raca"), (String) parameters.get("avatar"));
            mensagem.put("success", result);
        }
        // Remover Animal (id e ativo)
        else {
            result = FacadeBeans.removerAnimal(Integer.parseInt((String) parameters.get("id")), Boolean.parseBoolean((String) parameters.get("ativo")));
            mensagem.put("success", result);
        }

        out.print(mensagem);
        out.flush();
    }
}