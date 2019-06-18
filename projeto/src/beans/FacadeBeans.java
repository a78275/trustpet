package beans;

import main.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FacadeBeans {

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
	public boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {
		// TODO - implement beans.FacadeBeans.registarUtilizador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param passowrd
	 */
	public void autenticar(String email, String passowrd) {
		// TODO - implement beans.FacadeBeans.autenticar
		throw new UnsupportedOperationException();
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
	 * @param desparazitacao
	 * @param esterilizacao
	 * @param raca
	 * @param avatar
	 * @param ativo
	 */
	public boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparazitacao, boolean esterilizacao, String raca, String avatar, boolean ativo) {
		// TODO - implement beans.FacadeBeans.registarAnimal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param tipos
	 */
	public boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos) {
		// TODO - implement beans.FacadeBeans.registarTiposAnimais
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param servicos
	 */
	public boolean registarServicos(String emailPetsitter, Map<Integer, Float> servicos) {
		// TODO - implement beans.FacadeBeans.registarServicos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param horario
	 */
	public boolean editarHorario(String emailPetsitter, Map<String, List<Integer>> horario) {
		// TODO - implement beans.FacadeBeans.editarHorario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param filtro
	 */
	public List<Petsitter> consultarPetsitters(String filtro) {
		// TODO - implement beans.FacadeBeans.consultarPetsitters
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param de
	 * @param para
	 * @param avaliacao
	 * @param comentario
	 */
	public boolean avaliarUtilizador(String de, String para, int avaliacao, String comentario) {
		// TODO - implement beans.FacadeBeans.avaliarUtilizador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	public int efetuarPedido(Date data, List<Integer> servicos, List<Integer> animais) {
		// TODO - implement beans.FacadeBeans.efetuarPedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	public List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais) {
		// TODO - implement beans.FacadeBeans.getPetsittersPedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param idPedido
	 */
	public boolean selPetsitter(String emailPetsitter, int idPedido) {
		// TODO - implement beans.FacadeBeans.selPetsitter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailDono
	 */
	public List<Animal> consultarAnimais(String emailDono) {
		// TODO - implement beans.FacadeBeans.consultarAnimais
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public Utilizador consultarPerfil(String email) {
		// TODO - implement beans.FacadeBeans.consultarPerfil
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPedido
	 */
	public boolean cancelarPedido(int idPedido) {
		// TODO - implement beans.FacadeBeans.cancelarPedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<Pedido> consultarPedidos(String email) {
		// TODO - implement beans.FacadeBeans.consultarPedidos
		throw new UnsupportedOperationException();
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
	public void editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {
		// TODO - implement beans.FacadeBeans.editarDados
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param servicos
	 */
	public boolean editarServicos(String emailPetsitter, Map<Integer, Float> servicos) {
		// TODO - implement beans.FacadeBeans.editarServicos
		throw new UnsupportedOperationException();
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
	 * @param desparazitacao
	 * @param esterilizacao
	 * @param raca
	 * @param avatar
	 */
	public boolean editarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparazitacao, boolean esterilizacao, String raca, String avatar) {
		// TODO - implement beans.FacadeBeans.editarAnimal
		throw new UnsupportedOperationException();
	}

}