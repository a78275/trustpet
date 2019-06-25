package web;

import beans.FacadeBeans;
import main.FacadeDAOs;
import main.Utilizador;
import org.json.JSONObject;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class AutenticarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        PersistentSession session = Util.getSession(request);
        JSONObject parameters = Util.parseBody(request.getReader());

        String email = (String) parameters.get("email");
        String password = (String) parameters.get("password");

        boolean result = FacadeBeans.autenticar(email, password, session);


        if (result) {
            mensagem.put("sucess",true);
            String token = FacadeBeans.setToken(email,session);
            mensagem.put("token",token);


            String tipo = FacadeBeans.tipoUtilizador(email,session);

            //Guardar tipo do utilizador da sessão atual
            if(tipo.equals("petsitter")) {
                mensagem.put("tipo","petsitter");
            }
            else if (tipo.equals("dono")){
                mensagem.put("tipo","dono");
            }
        } else {
            mensagem.put("sucess",false);
        }

        out.print(mensagem);
        out.flush();
    }
}