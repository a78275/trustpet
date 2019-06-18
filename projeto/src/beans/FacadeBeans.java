package beans;

import trustpet.*;

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
	 * @param ativo
	 */
	public static boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, boolean ativo) {
		return donoBean.registarAnimal(emailDono,nome,idade,porte,sexo,alergias,doencas,comportamento,vacinas,desparasitacao,esterilizacao,raca,avatar);
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
	 * @param servicos
	 */
	public static boolean registarServicos(String emailPetsitter, Map<Integer, Float> servicos) {
		return petsitterBean.registarServicos(emailPetsitter,servicos);
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param horario
	 */
	public static boolean editarHorario(String emailPetsitter, Map<String, List<Integer>> horario) {
		return petsitterBean.editarHorario(emailPetsitter,horario);
	}

	/**
	 * 
	 * @param filtro
	 */
	public static List<Petsitter> consultarPetsitters(String filtro) {
		return petsitterBean.consultarPetsitters(filtro);
	}

	/**
	 * 
	 * @param de
	 * @param para
	 * @param avaliacao
	 * @param comentario
	 */
	public static boolean avaliarUtilizador(String de, String para, int avaliacao, String comentario) {
		return utilizadorBean.avaliarUtilizador(de,para,avaliacao,comentario);
	}

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	public static int registarPedido(Date data, List<Integer> servicos, List<Integer> animais) {
		return pedidoBean.registarPedido(data,servicos,animais);
	}

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	public static List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais) {
		return pedidoBean.getPetsittersPedido(data,servicos,animais);
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param idPedido
	 */
	public static boolean selPetsitter(String emailPetsitter, int idPedido) {
		return pedidoBean.selPetsitter(emailPetsitter,idPedido);
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
	 */
	public static Utilizador consultarPerfil(String email) {
		return utilizadorBean.consultarPerfil(email);
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
	 */
	public static void editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {
		utilizadorBean.editarDados(nome,email,dataNasc,contacto,jardim,morada,password,avatar,tipoUtilizador,concelho,distrito);
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param servicos
	 */
	public static boolean editarServicos(String emailPetsitter, Map<Integer, Float> servicos) {
		return petsitterBean.editarServicos(emailPetsitter,servicos);
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
	public static boolean editarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar) {
		return donoBean.editarAnimal(emailDono,nome,idade,porte,sexo,alergias,doencas,comportamento,vacinas,desparasitacao,esterilizacao,raca,avatar);
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