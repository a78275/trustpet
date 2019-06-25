package web;
import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Animal;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ConsultarAnimaisServlet", urlPatterns = {"/ConsultarAnimais"})
public class ConsultarAnimaisServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        String token = request.getHeader("Token");

        String emailDono = FacadeBeans.validarToken(token);
        if(emailDono!=null) {
            List<Animal> animalList = FacadeBeans.consultarAnimais(emailDono);

            // Não existem pedidos
            if (animalList == null) {
                mensagem.put("sucess", false);
            }
            else {
                Gson gson= new Gson();
                String json = gson.toJson(animalList);
                mensagem.put("sucess",true);
                mensagem.put("animais",json);
            }
        }
        else {
            mensagem.put("sucess",false);
        }
        out.print(mensagem);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}