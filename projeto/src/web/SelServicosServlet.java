package web;

import beans.FacadeBeans;
import main.Petsitter;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelServicosServlet", urlPatterns = {"/SelServicos"})
public class SelServicosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject parameters = Util.parseBody(request.getReader());
        JSONObject mensagem = new JSONObject();

        int idPedido = (int) parameters.get("idPedido");

        Map<Integer, List<Integer>> animalServicos = Util.parseAnimalServicosArray(parameters);

        List<Petsitter> petsitters = FacadeBeans.getPetsittersPedido(idPedido, animalServicos);

        // Ocorreu um erro nos beans
        if(petsitters == null){
            mensagem.put("sucess",false);
        }
        else {
            mensagem.put("sucess",true);
            mensagem.put("petsitters", Util.parsePetsittersList(petsitters));
        }

        out.print(mensagem);
        out.flush();
    }
}
