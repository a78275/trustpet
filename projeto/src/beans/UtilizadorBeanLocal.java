package beans;

public interface UtilizadorBeanLocal {

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
	boolean registarUtilizador(string nome, string email, Date dataNasc, string contacto, boolean jardim, string morada, string password, string avatar, string tipoUtilizador, string concelho, string distrito);

	/**
	 * 
	 * @param de
	 * @param para
	 * @param avaliacao
	 * @param comentario
	 */
	boolean avaliarUtilizador(string de, string para, int avaliacao, string comentario);

	/**
	 * 
	 * @param emailUtilizador
	 */
	boolean inativarUtilizador(string emailUtilizador);

	/**
	 * 
	 * @param email
	 */
	Utilizador consultarPerfil(string email);

}