package web;
import beans.FacadeBeans;
import org.json.JSONArray;
import org.json.JSONObject;
import org.orm.PersistentSession;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EditarTiposAnimaisServlet", urlPatterns = {"/EditarTiposAnimais"})
public class EditarTiposAnimaisServlet extends HttpServlet {
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

        JSONObject parameters = Util.parseBody(request.getReader());
        //List<Integer> tipos = parseList((String) parameters.get("tipos"));

        //boolean result = FacadeBeans.registarTiposAnimais((String) parameters.get("email"),tipos,session);
        //out.print(result);
        out.flush();
    }
}