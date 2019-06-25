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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.*;
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

    public static Map<Integer,Double> parseServicosList(JSONObject parameters) {
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

    public static List<Integer> parseTiposAnimaisList(JSONObject parameters) {
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

    public static String parsePetsittersList(List<Petsitter> ps) {
        // Build JSON array
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        sb.append("{\"petsitters\":[");

        for (Petsitter p : ps) {
            sb.append(parsePetsitter(p));
            sb.append(",");
        }

        String json = sb.toString();
        // Tirar última vírgula
        if(!ps.isEmpty()) {
            json = json.substring(0, json.length() - 1);
        }
        // Fechar lista
        json = json + "]}";

        return json;
    }

    public static String parseUtilizador(Utilizador utilizador) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"email\":\"" + utilizador.getEmail() + "\",");
        sb.append("\"password\":\"" + utilizador.getPassword() + "\",");
        sb.append("\"nome\":\"" + utilizador.getNome() + "\",");
        sb.append("\"avatar\":\"" + utilizador.getAvatar() + "\",");
        sb.append("\"dataNasc\":\"" + utilizador.getDataNasc() + "\",");
        sb.append("\"contacto\":\"" + utilizador.getContacto() + "\",");
        sb.append("\"jardim\":\"" + utilizador.getJardim() + "\",");
        sb.append("\"morada\":\"" + utilizador.getMorada() + "\",");
        sb.append("\"ativo\":\"" + utilizador.getAtivo() + "\",");
        sb.append("\"concelho\":\"" + utilizador.getConcelho() + "\",");
        sb.append("\"distrito\":\"" + utilizador.getDistrito() + "\",");
        sb.append("\"avaliacaoMedia\":\"" + utilizador.getAvaliacaoMedia() + "\",");
        sb.append("\"nrAvaliacoes\":\"" + utilizador.getNrAvaliacoes() + "\"");
        sb.append("}");

        return sb.toString();
    }

    public static String parseDono(Dono dono) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"email\":\"" + dono.getEmail() + "\",");
        sb.append("\"password\":\"" + dono.getPassword() + "\",");
        sb.append("\"nome\":\"" + dono.getNome() + "\",");
        sb.append("\"avatar\":\"" + dono.getAvatar() + "\",");
        sb.append("\"dataNasc\":\"" + dono.getDataNasc() + "\",");
        sb.append("\"contacto\":\"" + dono.getContacto() + "\",");
        sb.append("\"jardim\":\"" + dono.getJardim() + "\",");
        sb.append("\"morada\":\"" + dono.getMorada() + "\",");
        sb.append("\"ativo\":\"" + dono.getAtivo() + "\",");
        sb.append("\"concelho\":\"" + dono.getConcelho() + "\",");
        sb.append("\"distrito\":\"" + dono.getDistrito() + "\",");
        sb.append("\"avaliacaoMedia\":\"" + dono.getAvaliacaoMedia() + "\",");
        sb.append("\"nrAvaliacoes\":\"" + dono.getNrAvaliacoes() + "\",");
        sb.append("\"animais\":" + parseAnimaisCollection(dono.animais));
        sb.append("}");

        return sb.toString();
    }

    private static String parseAnimaisCollection(AnimalSetCollection animais) {
        Iterator iter = animais.getIterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iter.hasNext()){
            sb.append(parseAnimal((Animal) iter.next()));
            sb.append(",");
        }

        String json = sb.toString();
        // Tirar última vírgula
        if(!animais.isEmpty()) {
            json = json.substring(0, json.length() - 1);
        }

        // Fechar lista
        json = json + "]";

        return json;
    }

    private static String parseAnimal(Animal animal) {
        Gson gson = new Gson();
        return gson.toJson(animal);
    }

    public static String parsePetsitter(Petsitter petsitter) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"email\":\"" + petsitter.getEmail() + "\",");
        sb.append("\"password\":\"" + petsitter.getPassword() + "\",");
        sb.append("\"nome\":\"" + petsitter.getNome() + "\",");
        sb.append("\"avatar\":\"" + petsitter.getAvatar() + "\",");
        sb.append("\"dataNasc\":\"" + petsitter.getDataNasc() + "\",");
        sb.append("\"contacto\":\"" + petsitter.getContacto() + "\",");
        sb.append("\"jardim\":\"" + petsitter.getJardim() + "\",");
        sb.append("\"morada\":\"" + petsitter.getMorada() + "\",");
        sb.append("\"ativo\":\"" + petsitter.getAtivo() + "\",");
        sb.append("\"concelho\":\"" + petsitter.getConcelho() + "\",");
        sb.append("\"distrito\":\"" + petsitter.getDistrito() + "\",");
        sb.append("\"avaliacaoMedia\":\"" + petsitter.getAvaliacaoMedia() + "\",");
        sb.append("\"nrAvaliacoes\":\"" + petsitter.getNrAvaliacoes() + "\",");
        sb.append("\"horario\":" + parseHorario(petsitter.getHorario()) + ",");
        sb.append("\"tiposAnimais\":" + parseTiposAnimaisCollection(petsitter.animais));
        sb.append("}");

        return sb.toString();
    }

    private static String parseTiposAnimaisCollection(TipoAnimalSetCollection animais) {
        Iterator iter = animais.getIterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iter.hasNext()){
            sb.append(parseTipoAnimal((TipoAnimal) iter.next()));
            sb.append(",");
        }

        String json = sb.toString();
        // Tirar última vírgula
        if(!animais.isEmpty()) {
            json = json.substring(0, json.length() - 1);
        }

        // Fechar lista
        json = json + "]";

        return json;
    }

    private static String parseTipoAnimal(TipoAnimal tipoAnimal) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\":\"" + tipoAnimal.getId() + "\",");
        sb.append("\"tipo\":\"" + tipoAnimal.getTipo() + "\"");
        sb.append("}");

        return sb.toString();
    }

    private static String parseHorario(Horario horario) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\":\"" + horario.getId() + "\",");
        sb.append("\"dias\":" + parseDiasCollection(horario.dias));
        sb.append("}");

        return sb.toString();
    }

    private static String parseDiasCollection(DiaSetCollection dias) {
        Iterator iter = dias.getIterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iter.hasNext()){
            sb.append(parseDia((Dia) iter.next()));
            sb.append(",");
        }

        String json = sb.toString();
        // Tirar última vírgula
        if(!dias.isEmpty()) {
            json = json.substring(0, json.length() - 1);
        }

        // Fechar lista
        json = json + "]";

        return json;
    }

    private static String parseDia(Dia dia) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"dia\":\"" + dia.getDia() + "\",");
        sb.append("\"horas\":" + parseHorasCollection(dia.horas));
        sb.append("}");

        return sb.toString();
    }

    private static String parseHorasCollection(HoraSetCollection horas) {
        Iterator iter = horas.getIterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iter.hasNext()){
            sb.append(parseHora((Hora) iter.next()));
            sb.append(",");
        }

        String json = sb.toString();
        // Tirar última vírgula
        if(!horas.isEmpty()) {
            json = json.substring(0, json.length() - 1);
        }

        // Fechar lista
        json = json + "]";

        return json;
    }

    private static String parseHora(Hora hora) {
        return "\"" + hora.getHora() + "\"";
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