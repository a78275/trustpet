package web;

import beans.FacadeBeans;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.Util;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class AutenticarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonElement jelement = new JsonParser().parse(jb.toString());
        JsonObject credenciais = jelement.getAsJsonObject();

        if(credenciais != null) {
            String email = credenciais.get("email").getAsString();
            String password = credenciais.get("password").getAsString();

            if (email != null && password != null) {
                boolean success = FacadeBeans.autenticar(email, password, Util.getSession(request));

                if (success) {
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
                mensagem.put("msg", "Credenciais inválidas.");
            }
        }
        else {
            // TODO: enviar pedido post
            mensagem.put("msg", "Credenciais inválidas.");
        }

        out.print(mensagem);
        out.flush();

    }
}