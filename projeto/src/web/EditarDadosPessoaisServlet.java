package web;
import beans.FacadeBeans;
import main.Util;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;

@WebServlet(name = "EditarDadosPessoaisServlet", urlPatterns = {"/EditarDadosPessoais"})
public class EditarDadosPessoaisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PersistentSession session = Util.getSession(request);
        PrintWriter out = response.getWriter();
        boolean result = FacadeBeans.editarDados("LuisEditado","email2@email.com",Date.from(Instant.now()),"91118722",false,"Rua da Coisa","ola","","dono","Porto","Porto",session);

        out.print(result);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}