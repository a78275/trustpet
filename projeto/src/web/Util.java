package web;

import com.google.gson.Gson;
import main.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    public static Map<Integer, List<Integer>> parseAnimalServicosArray(JSONObject parameters) {
        Map<Integer, List<Integer>> animalServicos = new HashMap<>();
        JSONArray arr = parameters.getJSONArray("animalServicos");
        
        // Parse animalServicos
        for (int i = 0; i < arr.length(); i++) {
            String[] selection = arr.getString(i).split(":");

            int idAnimal = Integer.parseInt(selection[0]);
            int idServico = Integer.parseInt(selection[1]);

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

        return animalServicos;
    }

    public static Map<Integer,Double> parseServicosArray(JSONObject parameters) {
        Map<Integer, Double> servicos = new HashMap<>();
        JSONArray arr = parameters.getJSONArray("servicos");

        // Parse servicos
        for (int i = 0; i < arr.length(); i++) {
            String[] selection = arr.getString(i).split(":");
            int idServico = Integer.parseInt(selection[0]);
            double preco = Double.parseDouble(selection[1]);
            servicos.put(idServico, preco);
        }

        return servicos;
    }

    public static Map<Integer,List<Integer>> parseHorarioArray(JSONObject parameters) {
        Map<Integer,List<Integer>> horario = new HashMap<>();
        JSONArray arr = parameters.getJSONArray("horario");

        // Parse horario
        for (int i = 0; i < arr.length(); i++) {
            String[] selection = arr.getString(i).split(":");
            int idDia = Integer.parseInt(selection[0]);
            int hora = Integer.parseInt(selection[1]);

            List<Integer> horas = horario.get(idDia);

            if (horas == null) {
                horas = new ArrayList<>();
                horas.add(hora);
                horario.put(idDia,horas);
            }
            else {
                horas.add(hora);
                horario.put(idDia,horas);
            }

            horario.put(idDia, horas);
        }

        return horario;
    }

    private static List<Integer> parseHorasArray(JSONArray arr) {
        List<Integer> horas = new ArrayList<>();

        // Parse horas
        for (int i = 0; i < arr.length(); i++) {
            // Parse idDia
            int hora = arr.getJSONObject(i).getInt("hora");

            horas.add(hora);
        }

        return horas;
    }

    public static List<Integer> parseTiposAnimaisArray(JSONObject parameters) {
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

    public static JSONArray parseAnimalServicosMap(Map<Animal, List<Servico>> animalServicos) {
        JSONArray arr = new JSONArray();

        // Parse animalServicos
        for(Map.Entry<Animal, List<Servico>> e : animalServicos.entrySet()){
            JSONObject obj = new JSONObject();

            obj.put("id", e.getKey().getId());
            obj.put("nome", e.getKey().getNome());
            obj.put("avatar", e.getKey().getAvatar());
            obj.put("servicos", parseServicosList(e.getValue()));

            arr.put(obj);
        }

        return arr;
    }

    private static JSONObject parseServicoSel(Servico servico) {
        JSONObject obj = new JSONObject();

        obj.put("id", servico.getId());
        obj.put("designacao", servico.getDesignacao());
        //obj.put("tipoAnimais", parseTiposAnimaisCollection(servico.tipoAnimais));

        return obj;
    }

    private static JSONArray parseServicosList(List<Servico> servicos) {
        JSONArray arr = new JSONArray();

        for (Servico s : servicos){
            JSONObject obj = parseServicoSel(s);

            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parsePetsittersList(List<Petsitter> ps) {
        JSONArray arr = new JSONArray();

        for (Petsitter p : ps) {
            arr.put(parsePetsitter(p));
        }

        return arr;
    }

    public static JSONArray parsePetsittersListPreco(Map<Petsitter,Double> ps) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Petsitter, Double> p : ps.entrySet()) {
            arr.put(parsePetsitterPreco(p.getKey(),p.getValue()));
        }

        return arr;
    }

    public static JSONObject parseUtilizador(Utilizador utilizador) {
        JSONObject obj = new JSONObject();

        obj.put("email", utilizador.getEmail());
        obj.put("password", utilizador.getPassword());
        obj.put("nome", utilizador.getNome());
        obj.put("avatar", utilizador.getAvatar());
        obj.put("dataNasc", utilizador.getDataNasc());
        obj.put("contacto", utilizador.getContacto());
        obj.put("jardim", utilizador.getJardim());
        obj.put("morada", utilizador.getMorada());
        obj.put("ativo", utilizador.getAtivo());
        obj.put("concelho", utilizador.getConcelho());
        obj.put("distrito", utilizador.getDistrito());
        obj.put("avaliacaoMedia", utilizador.getAvaliacaoMedia());
        obj.put("nrAvaliacoes", utilizador.getNrAvaliacoes());

        return obj;
    }

    public static JSONObject parseDono(Dono dono) {
        JSONObject obj = new JSONObject();

        obj.put("email", dono.getEmail());
        obj.put("password", dono.getPassword());
        obj.put("nome", dono.getNome());
        obj.put("avatar", dono.getAvatar());
        obj.put("dataNasc", dono.getDataNasc());
        obj.put("contacto", dono.getContacto());
        obj.put("jardim", dono.getJardim());
        obj.put("morada", dono.getMorada());
        obj.put("ativo", dono.getAtivo());
        obj.put("concelho", dono.getConcelho());
        obj.put("distrito", dono.getDistrito());
        obj.put("avaliacaoMedia", dono.getAvaliacaoMedia());
        obj.put("nrAvaliacoes", dono.getNrAvaliacoes());
        obj.put("animais", parseAnimaisCollection(dono.animais));

        return obj;
    }

    private static JSONArray parseAnimaisCollection(AnimalSetCollection animais) {
        Iterator iter = animais.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseAnimal((Animal) iter.next()));
        }

        return arr;
    }

    private static JSONObject parseAnimal(Animal animal) {
        Gson gson = new Gson();
        return new JSONObject(gson.toJson(animal));
    }

    public static JSONObject parsePetsitterPreco(Petsitter petsitter,double preco) {
        if (petsitter!=null) {
            JSONObject obj = parsePetsitter(petsitter);
            obj.put("preco",preco);
            return obj;
        }
        else {
            return null;
        }

    }

    public static JSONObject parsePetsitter(Petsitter petsitter) {
        if (petsitter!=null) {
            JSONObject obj = new JSONObject();
            obj.put("email", petsitter.getEmail());
            obj.put("password", petsitter.getPassword());
            obj.put("nome", petsitter.getNome());
            obj.put("avatar", petsitter.getAvatar());
            obj.put("dataNasc", petsitter.getDataNasc());
            obj.put("contacto", petsitter.getContacto());
            obj.put("jardim", petsitter.getJardim());
            obj.put("morada", petsitter.getMorada());
            obj.put("ativo", petsitter.getAtivo());
            obj.put("concelho", petsitter.getConcelho());
            obj.put("distrito", petsitter.getDistrito());
            obj.put("avaliacaoMedia", petsitter.getAvaliacaoMedia());
            obj.put("nrAvaliacoes", petsitter.getNrAvaliacoes());
            obj.put("horario", parseHorario(petsitter.getHorario()));
            obj.put("animais", parseTiposAnimaisCollection(petsitter.animais));
            return obj;
        }
        else {
            return null;
        }
    }

    private static JSONArray parseTiposAnimaisCollection(TipoAnimalSetCollection animais) {
        Iterator iter = animais.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseTipoAnimal((TipoAnimal) iter.next()));
        }

        return arr;
    }

    private static JSONObject parseTipoAnimal(TipoAnimal tipoAnimal) {
        JSONObject obj = new JSONObject();

        obj.put("id", tipoAnimal.getId());
        obj.put("tipo", tipoAnimal.getTipo());

        return obj;
    }

    private static JSONObject parseHorario(Horario horario) {
        JSONObject obj = new JSONObject();
        if(horario!=null) {
            obj.put("id", horario.getId());
            obj.put("dias", parseDiasCollection(horario.dias));

            return obj;
        }
        else {
            return null;
        }
    }

    private static JSONArray parseDiasCollection(DiaSetCollection dias) {
        Iterator iter = dias.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseDia((Dia) iter.next()));
        }

        return arr;
    }

    private static JSONObject parseDia(Dia dia) {
        JSONObject obj = new JSONObject();

        obj.put("id", dia.getId());
        obj.put("dia", dia.getDia());
        obj.put("horas", parseHorasCollection(dia.horas));

        return obj;
    }

    private static JSONArray parseHorasCollection(HoraSetCollection horas) {
        Iterator iter = horas.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseHora((Hora) iter.next()));
        }

        return arr;
    }

    private static JSONObject parseHora(Hora hora) {
        JSONObject obj = new JSONObject();

        obj.put("hora", hora.getHora());

        return obj;
    }

    public static JSONArray parsePedidosList(List<Pedido> pedidos) {
        JSONArray arr = new JSONArray();

        for (Pedido p : pedidos) {
            arr.put(parsePedido(p));
        }

        return arr;
    }

    private static JSONObject parsePedido(Pedido pedido) {
        JSONObject obj = new JSONObject();

        obj.put("id", pedido.getId());
        obj.put("petsitter", parsePetsitterPedido(pedido.getPetsitter()));
        obj.put("dono", parseDonoPedido(pedido.getDono()));
        obj.put("preco", pedido.getPreco());
        obj.put("ativo", pedido.getAtivo());
        obj.put("dataInicio", pedido.getDataInicio());
        obj.put("dataFim", pedido.getDataFim());
        obj.put("animalServicos", parseAnimalServicosCollectionPedido(pedido.animalServicos));
        
        return obj;
    }

    private static JSONArray parseAnimalServicosCollectionPedido(AnimalServicoSetCollection animalServicos) {
        Iterator iter = animalServicos.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseAnimalServicoPedido((AnimalServico) iter.next()));
        }

        return arr;
    }

    private static JSONObject parseAnimalServicoPedido(AnimalServico animalServico) {
        JSONObject obj = new JSONObject();

        obj.put("id", animalServico.getId());
        obj.put("servico", parseServico(animalServico.getServico()));
        obj.put("animal", parseAnimalPedido(animalServico.getAnimal()));

        return obj;
    }

    private static JSONObject parseAnimalPedido(Animal animal) {
        if (animal!=null) {
            JSONObject obj = new JSONObject();
            obj.put("nome", animal.getNome());
            obj.put("avatar", animal.getAvatar());
            return obj;
        }
        else {
            return null;
        }
    }

    private static JSONObject parseDonoPedido(Dono dono) {
        JSONObject obj = new JSONObject();

        obj.put("email", dono.getEmail());
        obj.put("avatar", dono.getAvatar());

        return obj;
    }

    private static JSONObject parsePetsitterPedido(Petsitter petsitter) {
        if (petsitter!=null) {
            JSONObject obj = new JSONObject();
            obj.put("email", petsitter.getEmail());
            obj.put("avatar", petsitter.getAvatar());
            return obj;
        }
        else {
            return null;
        }
    }



    private static JSONArray parseAnimalServicosCollection(AnimalServicoSetCollection animalServicos) {
        Iterator iter = animalServicos.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseAnimalServico((AnimalServico) iter.next()));
        }

        return arr;
    }

    private static JSONObject parseAnimalServico(AnimalServico animalServico) {
        JSONObject obj = new JSONObject();

        obj.put("id", animalServico.getId());
        obj.put("servico", parseServico(animalServico.getServico()));
        obj.put("animal", parseAnimal(animalServico.getAnimal()));

        return obj;
    }

    private static JSONObject parseServico(Servico servico) {
        JSONObject obj = new JSONObject();

        obj.put("id", servico.getId());
        obj.put("designacao", servico.getDesignacao());
        obj.put("tipoAnimais", parseTiposAnimaisCollection(servico.tipoAnimais));

        return obj;
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

    public static JSONArray parseReviews(List<Review> reviewsList) {
        JSONArray arr = new JSONArray();

        for (Review r : reviewsList) {
            arr.put(parseReview(r));
        }

        return arr;
    }

    private static JSONObject parseReview(Review review) {
        JSONObject obj = new JSONObject();

        obj.put("data", review.getData());
        obj.put("pontuacao", review.getPontuacao());
        obj.put("comentario", review.getComentario());
        obj.put("dono", parseDonoReview(review.getDono()));
        obj.put("petsitter", parsePetsitterReview(review.getPetsitter()));

        return obj;
    }

    private static JSONObject parseDonoReview(Dono dono) {
        JSONObject obj = new JSONObject();

        obj.put("nome", dono.getNome());
        obj.put("avatar", dono.getAvatar());

        return obj;
    }

    private static JSONObject parsePetsitterReview(Petsitter petsitter) {
        JSONObject obj = new JSONObject();

        obj.put("nome", petsitter.getNome());
        obj.put("avatar", petsitter.getAvatar());

        return obj;
    }

    public static JSONArray parseServicosPetsitterMap(Map<String, Double> servicosPetsitter) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<String, Double> e : servicosPetsitter.entrySet()) {
            JSONObject obj = new JSONObject();
            obj.put("servico", e.getKey());
            obj.put("preco", e.getValue());
            arr.put(obj);
        }

        return arr;
    }
}