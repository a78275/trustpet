package web;
import beans.FacadeBeans;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "EditarAnimalServlet", urlPatterns = {"/EditarAnimal"})
public class EditarAnimalServlet extends HttpServlet {

    public String getCatAvatar() throws IOException {
        URL catAPI = new URL("https://api.thecatapi.com/v1/images/search");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(catAPI.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null) {
            result += inputLine;
        }
        in.close();

        String res = result.substring(1,result.length()-1);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(res);
        } catch (JSONException e){
            e.printStackTrace();
        }

        return jsonObject.getString("url");
    }

    public String getDogAvatar() throws IOException {
        URL dogAPI = new URL("https://dog.ceo/api/breeds/image/random");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(dogAPI.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null) {
            result += inputLine;
        }
        in.close();

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(result);
        } catch (JSONException e){
            e.printStackTrace();
        }

        return jsonObject.getString("message");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());
        String token = request.getHeader("Token");
        String email = FacadeBeans.validarToken(token);

        boolean result;
        String avatar = "";

        if(email!=null) {
            // Registar Animal (sem id)
            if(!parameters.keySet().contains("id")) {
                if( Integer.parseInt((String) parameters.get("tipo")) == 1 && parameters.get("avatar").equals("") ) {
                    avatar = getCatAvatar();
                }
                else if( Integer.parseInt((String) parameters.get("tipo")) == 2 && parameters.get("avatar").equals("") ) {
                    avatar = getDogAvatar();
                }
                else {
                    avatar = (String) parameters.get("avatar");
                }
                result = FacadeBeans.registarAnimal(email, (String) parameters.get("nome"), (String) parameters.get("idade"), (String) parameters.get("porte"), (String) parameters.get("sexo"), (String) parameters.get("alergias"), (String) parameters.get("doencas"), (String) parameters.get("comportamento"), Boolean.parseBoolean((String) parameters.get("vacinas")), Boolean.parseBoolean((String) parameters.get("desparasitacao")), Boolean.parseBoolean((String) parameters.get("esterilizacao")), (String) parameters.get("raca"), avatar, Integer.parseInt((String) parameters.get("tipo")));
                mensagem.put("success", result);
            }
            // Editar Animal (sem ativo)
            else if (!parameters.keySet().contains("ativo")){
                if( Integer.parseInt((String) parameters.get("tipo")) == 1 && parameters.get("avatar").equals("") ) {
                    avatar = getCatAvatar();
                }
                else if( Integer.parseInt((String) parameters.get("tipo")) == 2 && parameters.get("avatar").equals("") ) {
                    avatar = getDogAvatar();
                }
                else {
                    avatar = (String) parameters.get("avatar");
                }
                result = FacadeBeans.editarAnimal(Integer.parseInt((String) parameters.get("id")), (String) parameters.get("nome"), (String) parameters.get("idade"), (String) parameters.get("porte"), (String) parameters.get("sexo"), (String) parameters.get("alergias"), (String) parameters.get("doencas"), (String) parameters.get("comportamento"), Boolean.parseBoolean((String) parameters.get("vacinas")), Boolean.parseBoolean((String) parameters.get("desparasitacao")), Boolean.parseBoolean((String) parameters.get("esterilizacao")), (String) parameters.get("raca"), avatar);
                mensagem.put("success", result);
            }
            // Remover Animal (id e ativo)
            else {
                result = FacadeBeans.removerAnimal(Integer.parseInt((String) parameters.get("id")), Boolean.parseBoolean((String) parameters.get("ativo")));
                mensagem.put("success", result);
            }
        }

        out.print(mensagem);
        out.flush();
    }
}