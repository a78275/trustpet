package web;

import beans.FacadeBeans;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class AutenticarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();

        Map<String,String> parameters = Util.parseBody(request.getReader());

        if (parameters.containsKey("email") && parameters.containsKey("password")) {
            boolean result = FacadeBeans.autenticar(parameters.get("email"), parameters.get("password"), Util.getSession(request));

            if (result) {
                // TODO: enviar pedido post
                mensagem.put("msg", "Login feito com sucesso.");
                //request.setAttribute("msg", "Login feito com sucesso.");
            } else {
                // TODO: enviar pedido post
                mensagem.put("msg", "Credenciais incorretas.");
                //request.setAttribute("msg", "Credenciais incorretas.");
            }
        }
        else {
            // TODO: enviar pedido post
            mensagem.put("msg", "Introduza um email e password");
        }

        out.print(mensagem);
        out.flush();
    }
}