package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
import main.Review;
import main.Utilizador;
import org.json.JSONArray;
import org.json.JSONObject;

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

        if (email != null) {
            String tipo = FacadeBeans.tipoUtilizador(email);

            // Erro nos beans
            if (tipo != null) {
                Utilizador utilizador = FacadeBeans.consultarPerfil(email, tipo);
                mensagem.put("success", true);
                mensagem.put("utilizador", Util.parseUtilizador(utilizador));

                List<Review> reviewsList = FacadeBeans.consultarReviews(email,tipo);
                mensagem.put("reviews", Util.parseReviews(reviewsList));
            } else {
                mensagem.put("success", false);
            }
        } else {
            mensagem.put("success", false);
        }
        out.print(mensagem);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String token = request.getHeader("Token");
        String email = FacadeBeans.validarToken(token);
        String emailConsulta = (String) parameters.get("emailConsulta");

        if (email != null) {
            String tipo = FacadeBeans.tipoUtilizador(emailConsulta);

            Utilizador utilizador = FacadeBeans.consultarPerfil(emailConsulta,tipo);
            if (utilizador != null) {
                mensagem.put("success", true);
                mensagem.put("utilizador", Util.parseUtilizador(utilizador));

                List<Review> reviews = FacadeBeans.consultarReviews(emailConsulta,tipo);
                Gson gson = new Gson();
                mensagem.put("reviews",gson.toJson(reviews));
            } else {
                mensagem.put("success", false);
            }
        }

        out.print(mensagem);
        out.flush();
    }
}