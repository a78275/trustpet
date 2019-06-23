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

        JSONObject parameters = Util.parseBodyy(request.getReader());

        String email = (String) parameters.get("email");
        String password = (String) parameters.get("password");

        boolean result = FacadeBeans.autenticar(email, password, session);

        if (result) {
            // TODO: enviar pedido post
            mensagem.put("msg", "Login feito com sucesso.");
            // Guardar email do utilizador da sessão atual
            request.getSession().setAttribute("user", email);

            Utilizador user = null;
            try {
                user = FacadeDAOs.getDono(session,email);
            } catch (PersistentException e) {
                e.printStackTrace();
            }

            //Guardar tipo do utilizador da sessão atual
            if(user==null) {
                request.getSession().setAttribute("tipo", "petsitter");
            }
            else {
                request.getSession().setAttribute("tipo", "dono");
            }

            //request.setAttribute("msg", "Login feito com sucesso.");
        } else {
            // TODO: enviar pedido post
            mensagem.put("msg", "Credenciais incorretas.");
            //request.setAttribute("msg", "Credenciais incorretas.");
        }

        out.print(mensagem);
        out.flush();
    }
}