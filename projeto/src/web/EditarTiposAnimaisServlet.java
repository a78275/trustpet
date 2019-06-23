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

        Map<String,String> parameters = Util.parseBody(request.getReader());
        List<Integer> tipos = parseList(parameters.get("tipos"));

        boolean result = FacadeBeans.registarTiposAnimais(parameters.get("email"),tipos,session);
        out.print(result);
        out.flush();
    }

    //TODO Melhorar isto
    private List<Integer> parseList(String stringList) {
        String[] strings = stringList.split("[.,]");
        List<Integer> integers = new ArrayList<>();
        for(String s : strings) {
            if(s.startsWith("[")) {
                integers.add(Integer.parseInt(s.substring(1)));
            }
            else if (s.endsWith("]")) {
                integers.add(Integer.parseInt(s.substring(0,s.length()-1)));
            }
            else {
                integers.add(Integer.parseInt(s));
            }
        }
        return integers;
    }
}