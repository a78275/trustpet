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

@WebServlet(name = "EditarServicosServlet", urlPatterns = {"/EditarServicosServlet"})
public class EditarServicosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PersistentSession session = Util.getSession(request);
        PrintWriter out = response.getWriter();
        Map<Integer,Double> servicos = new HashMap<>();
        servicos.put(1,1.5);
        boolean result = FacadeBeans.registarServicos("email1@email.com",servicos,session);
        out.print(result);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());


        boolean result = FacadeBeans.registarServicos("email1@email.com",servicos,session);
        out.print(result);
        out.flush();*/
    }
}