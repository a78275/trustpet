package web;
import beans.FacadeBeans;
import main.Administrador;
import main.FacadeDAOs;
import org.json.JSONObject;
import org.orm.PersistentException;
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

        //TODO Passar método para os Beans?
        Administrador admin = null;
        try {
            admin = FacadeDAOs.getAdministrador(session,(String) parameters.get("email"));
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(admin!=null && admin.getPassword().equals((String) parameters.get("password"))) {
            boolean result = FacadeBeans.editarDados(null, (String) parameters.get("emailDono"), null, null, false, null, null, null, (String) parameters.get("tipoUtilizador"), null, null, false, session);
            out.print(result);
            out.flush();
        }
    }
}