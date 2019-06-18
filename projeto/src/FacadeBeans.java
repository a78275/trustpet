import trustpet.*;

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
	public boolean registarUtilizador(string nome, string email, Date dataNasc, string contacto, boolean jardim, string morada, string password, string avatar, string tipoUtilizador, string concelho, string distrito) {
		// TODO - implement FacadeBeans.registarUtilizador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param passowrd
	 */
	public void autenticar(string email, string passowrd) {
		// TODO - implement FacadeBeans.autenticar
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
	public boolean registarAnimal(string emailDono, string nome, int idade, string porte, string sexo, string alergias, string doencas, string comportamento, boolean vacinas, boolean desparazitacao, boolean esterilizacao, string raca, string avatar, boolean ativo) {
		// TODO - implement FacadeBeans.registarAnimal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param tipos
	 */
	public boolean registarTiposAnimais(string emailPetsitter, List<Integer> tipos) {
		// TODO - implement FacadeBeans.registarTiposAnimais
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param servicos
	 */
	public boolean registarServicos(string emailPetsitter, Map<Integer, Float> servicos) {
		// TODO - implement FacadeBeans.registarServicos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param horario
	 */
	public boolean registarHorario(string emailPetsitter, Map<String, List<Integer>> horario) {
		// TODO - implement FacadeBeans.registarHorario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param filtro
	 */
	public List<Petsitter> consultarPetsitters(string filtro) {
		// TODO - implement FacadeBeans.consultarPetsitters
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param de
	 * @param para
	 * @param avaliacao
	 * @param comentario
	 */
	public boolean avaliarUtilizador(string de, string para, int avaliacao, string comentario) {
		// TODO - implement FacadeBeans.avaliarUtilizador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	public int efetuarPedido(Date data, List<Integer> servicos, List<Integer> animais) {
		// TODO - implement FacadeBeans.efetuarPedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	public List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais) {
		// TODO - implement FacadeBeans.getPetsittersPedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailPetsitter
	 * @param idPedido
	 */
	public boolean selPetsitter(string emailPetsitter, int idPedido) {
		// TODO - implement FacadeBeans.selPetsitter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param emailDono
	 */
	public List<Animal> consultarAnimais(string emailDono) {
		// TODO - implement FacadeBeans.consultarAnimais
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public Utilizador consultarPerfil(string email) {
		// TODO - implement FacadeBeans.consultarPerfil
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPedido
	 */
	public boolean cancelarPedido(int idPedido) {
		// TODO - implement FacadeBeans.cancelarPedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 */
	public List<Pedido> consultarPedidos(string email) {
		// TODO - implement FacadeBeans.consultarPedidos
		throw new UnsupportedOperationException();
	}

}