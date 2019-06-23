package web;

import beans.FacadeBeans;
import main.Petsitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        int idPedido = (int) request.getSession().getAttribute("idPedido");

        Map<Integer, List<Integer>> servicos = new HashMap<>();
        servicos.put(1,List.of(1));

        //List<Petsitter> petsitters = FacadeBeans.getPetsittersPedido(idPedido,);
    }
}
