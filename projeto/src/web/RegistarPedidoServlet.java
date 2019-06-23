package web;
import beans.FacadeBeans;
import com.google.gson.Gson;
import main.FacadeDAOs;
import main.Servico;
import main.TipoAnimal;
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
        PersistentSession session = Util.getSession(request);
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        Date dataInicio = Util.parseDate((String) parameters.get("dataInicio"),"dd/MM/yyyy HH:mm");
        Date dataFim = Util.parseDate((String) parameters.get("dataFim"),"dd/MM/yyyy HH:mm");
        if(dataInicio==null || dataFim==null) {
            mensagem.put("msg", "Introduza datas válidas");
            out.print(mensagem);
            out.flush();
            return;
        }

        int idPedido = FacadeBeans.registarPedido((String) parameters.get("emailDono"), dataInicio, dataFim, session);
        if(idPedido==-1) {
            mensagem.put("msg", "Erro na criação do pedido.");
            out.print(mensagem);
            out.flush();
        }
        else {
            out.println("Pedido ID: " + idPedido);

            // TODO Receber tipos de animais do pedido HTTP, fazer parse corretamente
            List<TipoAnimal> tiposAnimal = new ArrayList<>();
            try {
                tiposAnimal.add(FacadeDAOs.getTipoAnimal(session,1));
            } catch (PersistentException e) {
                e.printStackTrace();
            }
            Map<TipoAnimal,List<Servico>> servicos = FacadeBeans.getServicosPedido(tiposAnimal,session);
            out.println("Servicos: ");
            // TODO Passar servicos ao front end corretamente
            /*Gson gson= new Gson();
            String json = gson.toJson(servicos);
            out.print(json);*/

            request.getSession().setAttribute("idPedido", idPedido);

            out.flush();
        }
    }
}