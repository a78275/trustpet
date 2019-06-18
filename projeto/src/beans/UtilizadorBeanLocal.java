package beans;

import trustpet.Utilizador;

import javax.ejb.Local;
import java.util.Date;

@Local
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
	boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito);

	/**
	 *
	 * @param de
	 * @param para
	 * @param avaliacao
	 * @param comentario
	 */
	boolean avaliarUtilizador(String de, String para, int avaliacao, String comentario);

	/**
	 *
	 * @param email
	 */
	Utilizador consultarPerfil(String email);

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
	void editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito);


}