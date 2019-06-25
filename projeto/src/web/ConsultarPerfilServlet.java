package web;
import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Animal;
import main.Utilizador;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ConsultarPerfilServlet", urlPatterns = {"/ConsultarPerfil"})
public class ConsultarPerfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PersistentSession session = Util.getSession(request);
        PrintWriter out = response.getWriter();
        String email = (String) request.getSession().getAttribute("user");
        String tipo = (String) request.getSession().getAttribute("tipo");

        if(email!=null && tipo !=null) {
            Utilizador utilizador = FacadeBeans.consultarPerfil(email,tipo,session);

            String json = Util.parseUtilizador(utilizador);

            out.print(json);
        }
        else {
            out.print("Não está autenticado na sessão ativa.");
        }

        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}