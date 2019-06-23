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
import java.util.List;
import java.util.Map;

@WebServlet(name = "InativarUtilizadorServlet", urlPatterns = {"/InativarUtilizador"})
public class InativarUtilizadorServlet extends HttpServlet {
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

        JSONObject parameters = Util.parseBody(request.getReader());

        boolean result = FacadeBeans.editarDados(null, (String) parameters.get("email"), null, null, false, null, null, null, (String) parameters.get("tipoUtilizador"), null, null, false, session);
        out.print(result);
        out.flush();
    }
}