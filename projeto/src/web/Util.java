package web;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.google.gson.Gson;
import main.*;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public static Map<Integer,Double> parseServicosArray(JSONObject parameters) {
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

            obj.put("nome", e.getKey().getNome());
            obj.put("avatar", e.getKey().getAvatar());
            obj.put("servicos", parseServicosList(e.getValue()));

            arr.put(obj);
        }

        return arr;
    }

    private static JSONArray parseServicosList(List<Servico> servicos) {
        JSONArray arr = new JSONArray();

        for (Servico s : servicos){
            JSONObject obj = parseServico(s);

            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parsePetsittersList(List<Petsitter> ps) {
        Gson gson = new Gson();
        JSONArray arr = new JSONArray();

        for (Petsitter p : ps) {
            arr.put(parsePetsitter(p));
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

    public static JSONObject parsePetsitter(Petsitter petsitter) {
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

        obj.put("id", horario.getId());
        obj.put("dias", parseDiasCollection(horario.dias));

        return obj;
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
        obj.put("petsitter", parsePetsitter(pedido.getPetsitter()));
        obj.put("dono", parseDono(pedido.getDono()));
        obj.put("preco", pedido.getPreco());
        obj.put("ativo", pedido.getAtivo());
        obj.put("dataInicio", pedido.getDataInicio());
        obj.put("dataFim", pedido.getDataFim());
        obj.put("animalServicos", parseAnimalServicosCollection(pedido.animalServicos));
        obj.put("servicos", parseServicosCollection(pedido.servicos));

        return obj;
    }

    private static JSONArray parseServicosCollection(PrecoPetsitterServicoSetCollection servicos) {
        Iterator iter = servicos.getIterator();
        JSONArray arr = new JSONArray();

        while (iter.hasNext()){
            arr.put(parseServico((Servico) iter.next()));
        }

        return arr;
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
}