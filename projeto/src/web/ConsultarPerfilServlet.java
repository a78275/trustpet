package web;
import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Petsitter;
import main.Util;
import main.Utilizador;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ConsultarPerfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PersistentSession session = Util.getSession(request);
        PrintWriter out = response.getWriter();

        Utilizador utilizador = FacadeBeans.consultarPerfil("email1@email","petsitter",session);

        Gson gson= new Gson();
        String json = gson.toJson(utilizador);

        out.print(json);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}