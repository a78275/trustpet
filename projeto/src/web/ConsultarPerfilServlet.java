package web;
import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Animal;
import main.Utilizador;
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

@WebServlet(name = "ConsultarPerfilServlet", urlPatterns = {"/ConsultarPerfil"})
public class ConsultarPerfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        String token = request.getHeader("Token");
        String email = FacadeBeans.validarToken(token);

        if(email!=null) {
            String tipo = FacadeBeans.tipoUtilizador(email);
            if(tipo !=null) {
                Utilizador utilizador = FacadeBeans.consultarPerfil(email,tipo);
                //TODO Arranjar solução para seralizar utilizador
                /*Gson gson= new Gson();
                String json = gson.toJson(utilizador);*/
                mensagem.put("sucess",true);
                //TODO Passar utilizador para o frontend (em vez do nome)
                mensagem.put("nome",utilizador.getNome());
            }
            else {
                mensagem.put("sucess",false);
            }
        }
        else {
            mensagem.put("sucess",false);
        }
        out.print(mensagem);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}