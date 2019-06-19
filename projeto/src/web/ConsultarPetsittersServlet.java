package web;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConsultarPetsitters", urlPatterns = {"/ConsultarPetsitters"})
public class ConsultarPetsittersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //PersistentSession session = Util.getSession(request);
        PrintWriter out = response.getWriter();

        //List<Petsitter> ps = FacadeBeans.consultarPetsitters(null, session);

        JSONObject obj = new JSONObject();

        obj.put("email", "abcd");
        obj.put("password", "12345");
        obj.put("nome", "joana");

        out.print(obj);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\n\n\n\n\nREQUEST: " + request.getParameter("email") + "\n\n\n\n");
    }
}