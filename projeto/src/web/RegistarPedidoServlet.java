package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
import main.FacadeDAOs;
import main.Servico;
import main.TipoAnimal;
import main.TrustPetPersistentManager;
import org.json.JSONArray;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RegistarPedidoServlet", urlPatterns = {"/RegistarPedido"})
public class RegistarPedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        Date dataInicio = Util.parseDate((String) parameters.get("dataInicio"), "dd/MM/yyyy HH:mm");
        Date dataFim = Util.parseDate((String) parameters.get("dataFim"), "dd/MM/yyyy HH:mm");
        JSONArray animais = (JSONArray) parameters.get("animais");

        if (dataInicio != null && dataFim != null && animais != null) {
            int idPedido = FacadeBeans.registarPedido((String) parameters.get("email"), dataInicio, dataFim);

            if (idPedido != -1) {
                List<Integer> tiposAnimal = new ArrayList<>();
                for(int i = 0; i < animais.length(); i++) {
                    Integer idAnimal = Integer.parseInt((String) animais.get(i));
                    tiposAnimal.add(FacadeBeans.tipoAnimal(idAnimal));
                }

                Map<TipoAnimal, List<Servico>> servicos = FacadeBeans.getServicosPedido(tiposAnimal);

                mensagem.put("idPedido",idPedido);
                mensagem.put("sucess", true);
            } else {
                mensagem.put("sucess", false);
            }
        } else {
            mensagem.put("sucess", false);
        }

        out.print(mensagem);
        out.flush();
    }
}