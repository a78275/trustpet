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

@WebServlet(name = "IndexServlet", urlPatterns = {"/Index"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        JSONObject mensagem = new JSONObject();
        String token = request.getHeader("Token");
        if(!token.equals("")) {
            String email = FacadeBeans.validarToken(token);
            if(email!=null) {
                mensagem.put("email", email);
                mensagem.put("tipo", FacadeBeans.tipoUtilizador(email));
                mensagem.put("success", "true");
            }
            else {
                mensagem.put("email", "null");
                mensagem.put("success", "true");
            }
        }
        else {
            mensagem.put("success", "true");
        }

        out.print(mensagem);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}