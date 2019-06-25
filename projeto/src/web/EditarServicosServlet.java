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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EditarServicosServlet", urlPatterns = {"/EditarServicos"})
public class EditarServicosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());
        Map<Integer,Double> servicos = Util.parseServicosList(parameters);

        boolean result = FacadeBeans.registarServicos((String) request.getSession().getAttribute("user"), servicos, session);

        if (result) {
            // TODO: redirecionar?
            mensagem.put("msg", "Edição bem sucedida.");
        } else {
            // TODO: redirecionar?
            mensagem.put("msg", "Erro.");
        }

        out.print(result);
        out.flush();
    }
}