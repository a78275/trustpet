package web;
import beans.FacadeBeans;
import org.orm.PersistentSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditarAnimalServlet", urlPatterns = {"/EditarAnimal"})
public class EditarAnimalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PersistentSession session = Util.getSession(request);
        PrintWriter out = response.getWriter();
        boolean result;
        //if (parameterID == null)
        //result = FacadeBeans.registarAnimal("email2@email.com","Luna",1,"Pequeno","F","","Doente da cabeca","",true,true,true,"Engodo","",1,session);
        //else
        result = FacadeBeans.editarAnimal(2,"Luna",1,"Pequeno","F","","Doente da cabeca","Atrasada",true,true,true,"Engodo","",true,session);

        out.print(result);
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}