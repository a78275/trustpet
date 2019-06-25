package web;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.TrustPetPersistentManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.orm.PersistentSession;

public class Util {
    public static String hash(String original) {
        String res = original;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(original.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            res = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


    public static Map<Integer, List<Integer>> parseAnimalServicos(JSONObject parameters) {
        Map<Integer, List<Integer>> animalServicos = new HashMap<>();
        JSONArray arr = parameters.getJSONArray("animalServicos");

        // Parse animalServicos
        for (int i = 0; i < arr.length(); i++) {
            // Parse idAnimal
            int idAnimal = arr.getJSONObject(i).getInt("idAnimal");

            // Parse servicos
            JSONArray servicos = arr.getJSONObject(i).getJSONArray("servicos");

            for (int j = 0; j < servicos.length(); j++) {
                int idServico = servicos.getInt(j);

                List<Integer> servicosList = animalServicos.get(idAnimal);

                // O animal ainda não está no map
                if (servicosList == null) {
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

        return animalServicos;
    }

    public static Map<Integer,Double> parseServicos(JSONObject parameters) {
        Map<Integer, Double> servicos = new HashMap<>();
        JSONArray arr = parameters.getJSONArray("servicos");

        // Parse servicos
        for (int i = 0; i < arr.length(); i++) {
            // Parse idServico
            int idServico = arr.getJSONObject(i).getInt("idServico");
            // Parse preço
            double preco = arr.getJSONObject(i).getDouble("preco");

            servicos.put(idServico, preco);
        }

        return servicos;
    }

    public static List<Integer> parseTiposAnimais(JSONObject parameters) {
        List<Integer> tipos = new ArrayList<>();
        JSONArray arr = parameters.getJSONArray("tipos");

        // Parse tipos
        for (int i = 0; i < arr.length(); i++) {
            // Parse idTipo
            int idTipo = arr.getInt(i);

            tipos.add(idTipo);
        }

        return tipos;
    }

    public static JSONObject parseBody (BufferedReader reader) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONObject(jb.toString());
    }

    public static Date parseDate (String dateString, String pattern) {
        Date date = null;
        try {
            date=new SimpleDateFormat(pattern).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}