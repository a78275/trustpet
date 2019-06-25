package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Petsitter;
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

@WebServlet(name = "ConsultarPetsittersServlet", urlPatterns = {"/ConsultarPetsitters"})
public class ConsultarPetsittersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();

        List<Petsitter> petsitters = FacadeBeans.consultarPetsitters(request.getParameter("cond"), request.getParameter("sort"));

        // Ocorreu um erro nos beans
        if(petsitters == null){
            mensagem.put("sucess",false);
        }
        else {
            mensagem.put("sucess",true);
            mensagem.put("petsitters", Util.parsePetsittersList(petsitters));
        }

        out.print(mensagem);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}