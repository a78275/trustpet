package web;
import beans.FacadeBeans;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EditarTiposAnimaisServlet", urlPatterns = {"/EditarTiposAnimais"})
public class EditarTiposAnimaisServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        List<Integer> tipos = Util.parseTiposAnimaisArray(parameters);

        String token = request.getHeader("Token");
        String email = FacadeBeans.validarToken(token);

        if(email != null) {
            boolean result = FacadeBeans.registarTiposAnimais(email, tipos);
            mensagem.put("success", result);
        }
        else {
            mensagem.put("success", false);
        }

        out.print(mensagem);
        out.flush();
    }
}