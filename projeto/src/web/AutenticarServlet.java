package web;

import beans.FacadeBeans;
import main.TrustPetPersistentManager;
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

@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class AutenticarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String email = (String) parameters.get("email");
        String password = Util.hash((String) parameters.get("password"));

        boolean result = FacadeBeans.autenticar(email, password);
        if (result) {
            mensagem.put("success", true);

            String tipo = FacadeBeans.tipoUtilizador(email);
            if (tipo.equals("petsitter")) {
                mensagem.put("tipo", "petsitter");
            } else if (tipo.equals("dono")) {
                mensagem.put("tipo", "dono");
            }
            else {
                mensagem.put("tipo","wut");
            }

            String tokenAtual = FacadeBeans.isAutenticado(email);
            if (tokenAtual == null || tokenAtual.equals("")) {
                String token = FacadeBeans.setToken(email);
                mensagem.put("token", token);
            } else {
                mensagem.put("token", tokenAtual);
            }
        } else {
            mensagem.put("success", false);
        }

        out.print(mensagem);
        out.flush();
    }
}