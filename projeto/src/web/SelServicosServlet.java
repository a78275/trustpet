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
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        int idPedido = (int) request.getSession().getAttribute("idPedido");
        JSONArray arr = parameters.getJSONArray("animalServicos");

        Map<Integer, List<Integer>> animalServicos = new HashMap<>();

        // Parse animalServicos
        for (int i = 0; i < arr.length(); i++) {
            // Parse idAnimal
            int idAnimal = arr.getJSONObject(i).getInt("idAnimal");
            // Parse servicos
            JSONArray servicos = arr.getJSONObject(i).getJSONArray("servicos");

            for (int j = 0; j < servicos.length(); j++) {
                int idServico = Integer.parseInt((String) arr.get(j));

                List<Integer> servicosList = animalServicos.get(idAnimal);

                // O animal ainda não está no map
                if (servicosList == null){
                    servicosList = new ArrayList<>();
                    servicosList.add(idServico);
                    animalServicos.put(idAnimal, servicosList);
                }

                // O animal já está no map
                else {
                    servicosList.add(idServico);
                    animalServicos.put(idAnimal, servicosList);
                }
            }
        }

        //TODO: Apagar
        for(Map.Entry<Integer, List<Integer>> e : animalServicos.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }

        List<Petsitter> petsitters = FacadeBeans.getPetsittersPedido(idPedido, animalServicos, session);

        Gson gson= new Gson();
        String json = gson.toJson(petsitters);

        out.print(json);
        out.flush();
    }
}
