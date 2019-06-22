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
     * @param session
     */
    public static boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session) {
        return utilizadorBean.registarUtilizador(nome,email,dataNasc,contacto,jardim,morada,password,avatar,tipoUtilizador,concelho,distrito,session);
    }

    /**
     *
     * @param email
     * @param password
     * @param session
     */
    public static boolean autenticar(String email, String password, PersistentSession session) {
        return autenticarBean.autenticar(email,password,session);
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
     * @param session
     */
    public static boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, int tipo,PersistentSession session) {
        return donoBean.registarAnimal(emailDono,nome,idade,porte,sexo,alergias,doencas,comportamento,vacinas,desparasitacao,esterilizacao,raca,avatar,tipo,session);
    }

    /**
     *
     * @param emailPetsitter
     * @param tipos
     * @param session
     */
    public static boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos, PersistentSession session) {
        return petsitterBean.registarTiposAnimais(emailPetsitter,tipos,session);
    }

    /**
     *
     * @param emailPetsitter
     * @param servicos
     * @param session
     */
    public static boolean registarServicos(String emailPetsitter, Map<Integer, Double> servicos, PersistentSession session) {
        return petsitterBean.registarServicos(emailPetsitter,servicos,session);
    }

    /**
     *
     * @param emailPetsitter
     * @param horario
     * @param session
     */
    public static boolean editarHorario(String emailPetsitter, Map<Integer, List<Integer>> horario, PersistentSession session) {
        return petsitterBean.editarHorario(emailPetsitter,horario,session);
    }

    /**
     *
     * @param filtro
     * @param session
     */
    public static List<Petsitter> consultarPetsitters(String filtro, PersistentSession session) {
        return petsitterBean.consultarPetsitters(filtro,session);
    }

    /**
     *
     * @param emailDono
     * @param emailPetsitter
     * @param avaliacao
     * @param comentario
     * @param alvo
     * @param session
     */
    boolean avaliarUtilizador(String emailDono, String emailPetsitter, int avaliacao, String comentario, String alvo, PersistentSession session) {
        return utilizadorBean.avaliarUtilizador(emailDono, emailPetsitter, avaliacao, comentario, alvo, session);
    }

    /**
     *
     * @param emailDono
     * @param dataInicio
     * @param dataFim
     * @param animalServicos
     * @param session
     */
    public static int registarPedido(String emailDono, Date dataInicio, Date dataFim, Map<Integer, List<Integer>> animalServicos, PersistentSession session) {
        return pedidoBean.registarPedido(emailDono, dataInicio, dataFim, animalServicos, session);
    }

    /**
     *
     * @param dataInicio
     * @param dataFim
     * @param animalServicos
     * @param session
     */
    public static List<Petsitter> getPetsittersPedido(Date dataInicio, Date dataFim, Map<Integer, List<Integer>> animalServicos, PersistentSession session) {
        return pedidoBean.getPetsittersPedido(dataInicio, dataFim, animalServicos, session);
    }

    /**
     *
     * @param emailPetsitter
     * @param idPedido
     * @param session
     */
    public static boolean concluirPedido(String emailPetsitter, int idPedido, PersistentSession session) {
        return pedidoBean.concluirPedido(emailPetsitter, idPedido, session);
    }

    /**
     *
     * @param emailDono
     * @param session
     */
    public static List<Animal> consultarAnimais(String emailDono, PersistentSession session) {
        return donoBean.consultarAnimais(emailDono, session);
    }

    /**
     *
     * @param email
     * @param tipoUtilizador
     * @param session
     */
    public static Utilizador consultarPerfil(String email, String tipoUtilizador, PersistentSession session) {
        return utilizadorBean.consultarPerfil(email, tipoUtilizador, session);
    }

    /**
     *
     * @param idPedido
     * @param session
     */
    public static boolean cancelarPedido(int idPedido, PersistentSession session) {
        return pedidoBean.cancelarPedido(idPedido, session);
    }

    /**
     *
     * @param email
     * @param session
     */
    public static List<Pedido> consultarPedidos(String email, PersistentSession session) {
        return pedidoBean.consultarPedidos(email, session);
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
     * @param session
     */
    public static boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, boolean ativo,PersistentSession session) {
        return utilizadorBean.editarDados(nome, email, dataNasc, contacto, jardim, morada, password, avatar, tipoUtilizador, concelho, distrito, ativo,session);
    }

    /**
     *
     * @param emailPetsitter
     * @param servicos
     * @param session
     */
    public static boolean editarServicos(String emailPetsitter, Map<Integer, Double> servicos, PersistentSession session) {
        return petsitterBean.editarServicos(emailPetsitter, servicos, session);
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
     * @param session
     */
    public static boolean editarAnimal(int id, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, boolean ativo, PersistentSession session) {
        return donoBean.editarAnimal(id, nome, idade, porte, sexo, alergias, doencas, comportamento, vacinas, desparasitacao, esterilizacao, raca, avatar, ativo, session);
    }
    /**
     *
     * @param tiposAnimal
     * @param session
     */
    public static List<Servico> getServicosPedido(List<TipoAnimal> tiposAnimal, PersistentSession session) {
        return pedidoBean.getServicosPedido(tiposAnimal,session);
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