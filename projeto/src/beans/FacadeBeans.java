package beans;

import org.orm.PersistentSession;
import main.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FacadeBeans {

    private static AutenticarBeanLocal autenticarBean = lookupAutenticarBeanLocal();
    private static DonoBeanLocal donoBean = lookupDonoBeanLocal();
    private static PedidoBeanLocal pedidoBean = lookupPedidoBeanLocal();
    private static PetsitterBeanLocal petsitterBean = lookupPetsitterBeanLocal();
    private static UtilizadorBeanLocal utilizadorBean = lookupUtilizadorBeanLocal();
    /**
     *
     * @param nome
     * @param email
     * @param dataNasc
     * @param contacto
     * @param jardim
     * @param morada
     * @param password
     * @param avatar
     * @param tipoUtilizador
     * @param concelho
     * @param distrito
     */
    public static boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {
        return utilizadorBean.registarUtilizador(nome,email,dataNasc,contacto,jardim,morada,password,avatar,tipoUtilizador,concelho,distrito);
    }

    /**
     *
     * @param email
     * @param password
     */
    public static boolean autenticar(String email, String password) {
        return autenticarBean.autenticar(email,password);
    }

    /**
     *
     * @param emailDono
     * @param nome
     * @param idade
     * @param porte
     * @param sexo
     * @param alergias
     * @param doencas
     * @param comportamento
     * @param vacinas
     * @param desparasitacao
     * @param esterilizacao
     * @param raca
     * @param avatar
     */
    public static boolean registarAnimal(String emailDono, String nome, String idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, int tipo) {
        return donoBean.registarAnimal(emailDono,nome,idade,porte,sexo,alergias,doencas,comportamento,vacinas,desparasitacao,esterilizacao,raca,avatar,tipo);
    }

    /**
     *
     * @param emailPetsitter
     * @param tipos
     */
    public static boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos) {
        return petsitterBean.registarTiposAnimais(emailPetsitter,tipos);
    }

    /**
     *
     * @param emailPetsitter
     * @param horario
     */
    public static boolean editarHorario(String emailPetsitter, Map<Integer, List<Integer>> horario) {
        return petsitterBean.editarHorario(emailPetsitter,horario);
    }

    /**
     *
     * @param filtro
     * @param ordem
     */
    public static List<Petsitter> consultarPetsitters(String filtro, String ordem) {
        return petsitterBean.consultarPetsitters(filtro,ordem);
    }

    /**
     *
     * @param emailDono
     * @param emailPetsitter
     * @param avaliacao
     * @param comentario
     * @param alvo
     */
    public static boolean avaliarUtilizador(String emailDono, String emailPetsitter, int avaliacao, String comentario, String alvo) {
        return utilizadorBean.avaliarUtilizador(emailDono, emailPetsitter, avaliacao, comentario, alvo);
    }

    /**
     *
     * @param emailDono
     * @param dataInicio
     * @param dataFim
     */
    public static int registarPedido(String emailDono, Date dataInicio, Date dataFim) {
        return pedidoBean.registarPedido(emailDono, dataInicio, dataFim);
    }

    /**
     *
     * @param idPedido
     * @param animalServicos
     */
    public static Map<Petsitter,Double> getPetsittersPedido(int idPedido, Map<Integer, List<Integer>> animalServicos) {
        return pedidoBean.getPetsittersPedido(idPedido, animalServicos);
    }

    /**
     *
     * @param emailPetsitter
     * @param idPedido
     */
    public static boolean concluirPedido(String emailPetsitter, int idPedido) {
        return pedidoBean.concluirPedido(emailPetsitter, idPedido);
    }

    /**
     *
     * @param emailDono
     */
    public static List<Animal> consultarAnimais(String emailDono) {
        return donoBean.consultarAnimais(emailDono);
    }

    /**
     *
     * @param email
     * @param tipoUtilizador
     */
    public static Utilizador consultarPerfil(String email, String tipoUtilizador) {
        return utilizadorBean.consultarPerfil(email, tipoUtilizador);
    }

    /**
     *
     * @param idPedido
     */
    public static boolean cancelarPedido(int idPedido) {
        return pedidoBean.cancelarPedido(idPedido);
    }

    /**
     *
     * @param email
     */
    public static List<Pedido> consultarPedidos(String email) {
        return pedidoBean.consultarPedidos(email);
    }

    /**
     *
     * @param nome
     * @param email
     * @param dataNasc
     * @param contacto
     * @param jardim
     * @param morada
     * @param password
     * @param avatar
     * @param tipoUtilizador
     * @param concelho
     * @param distrito
     * @param ativo
     */
    public static boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, boolean ativo) {
        return utilizadorBean.editarDados(nome, email, dataNasc, contacto, jardim, morada, password, avatar, tipoUtilizador, concelho, distrito, ativo);
    }

    /**
     *
     * @param emailPetsitter
     * @param servicos
     */
    public static boolean editarServicos(String emailPetsitter, Map<Integer, Double> servicos) {
        return petsitterBean.editarServicos(emailPetsitter, servicos);
    }

    /**
     *
     * @param id
     * @param nome
     * @param idade
     * @param porte
     * @param sexo
     * @param alergias
     * @param doencas
     * @param comportamento
     * @param vacinas
     * @param desparasitacao
     * @param esterilizacao
     * @param raca
     * @param avatar
     * @param ativo
     */
    public static boolean editarAnimal(int id, String nome, String idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, boolean ativo) {
        return donoBean.editarAnimal(id, nome, idade, porte, sexo, alergias, doencas, comportamento, vacinas, desparasitacao, esterilizacao, raca, avatar, ativo);
    }
    /**
     *
     * @param idAnimal
     */
    public static Map<Animal,List<Servico>> getServicosPedido(List<Integer> idAnimal) {
        return pedidoBean.getServicosPedido(idAnimal);
    }

    /**
     *
     * @param animalServicos
     */
    public static boolean registarServicosPedido(int idPedido, Map<Integer,List<Integer>> animalServicos) {
        return pedidoBean.registarServicosPedido(idPedido, animalServicos);
    }

    /**
     *
     * @param token
     */
    public static String validarToken(String token) {
        return autenticarBean.validarToken(token);
    }

    /**
     *
     * @param email
     */
    public static String setToken(String email) {
        return autenticarBean.setToken(email);
    }

    /**
     *
     * @param email
     * @param password
     */
    public static boolean autenticarAdministrador(String email, String password) {
        return autenticarBean.autenticarAdministrador(email,password);
    }

    /**
     *
     * @param email
     */
    public static String tipoUtilizador(String email) {
        return utilizadorBean.tipoUtilizador(email);
    }

    /**
     *
     * @param email
     * @param tipo
     */
    public static List<Review> consultarReviews(String email, String tipo) {
        return utilizadorBean.consultarReviews(email,tipo);
    }

    /**
     *
     * @param idPedido
     * @param dataInicio
     * @param dataFim
     */
    public static int editarPedido(int idPedido, Date dataInicio, Date dataFim) {
        return pedidoBean.editarPedido(idPedido,dataInicio,dataFim);
    }

    /**
     *
     * @param email
     */

    public static Map<String, Double> getServicosPetsitter(String email){
        return petsitterBean.getServicosPetsitter(email);
    }

    private static AutenticarBeanLocal lookupAutenticarBeanLocal() {
        try {
            Context c = new InitialContext();
            return (AutenticarBeanLocal) c.lookup("java:global/trustpet_war_exploded/AutenticarBean!beans.AutenticarBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static DonoBeanLocal lookupDonoBeanLocal() {
        try {
            Context c = new InitialContext();
            return (DonoBeanLocal) c.lookup("java:global/trustpet_war_exploded/DonoBean!beans.DonoBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static PedidoBeanLocal lookupPedidoBeanLocal() {
        try {
            Context c = new InitialContext();
            return (PedidoBeanLocal) c.lookup("java:global/trustpet_war_exploded/PedidoBean!beans.PedidoBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static PetsitterBeanLocal lookupPetsitterBeanLocal() {
        try {
            Context c = new InitialContext();
            return (PetsitterBeanLocal) c.lookup("java:global/trustpet_war_exploded/PetsitterBean!beans.PetsitterBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static UtilizadorBeanLocal lookupUtilizadorBeanLocal() {
        try {
            Context c = new InitialContext();
            return (UtilizadorBeanLocal) c.lookup("java:global/trustpet_war_exploded/UtilizadorBean!beans.UtilizadorBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }
}