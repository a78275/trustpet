package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import main.Pedido;
import main.Petsitter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
        PersistentSession session = Util.getSession(request);
        JSONObject parameters = Util.parseBody(request.getReader());

        int idPedido = (int) request.getSession().getAttribute("idPedido");

        Map<Integer, List<Integer>> animalServicos = Util.parseAnimalServicos(parameters);

        List<Petsitter> petsitters = FacadeBeans.getPetsittersPedido(idPedido, animalServicos, session);

        Gson gson= new Gson();
        String json = gson.toJson(petsitters);

        out.print(json);
        out.flush();
    }
}
