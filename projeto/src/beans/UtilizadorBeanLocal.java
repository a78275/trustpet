package beans;

import org.orm.PersistentSession;
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
	 * @param session
	 */
	boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session);

	/**
	 *
	 * @param de
	 * @param para
	 * @param avaliacao
	 * @param comentario
	 * @param session
	 */
	boolean avaliarUtilizador(String de, String para, int avaliacao, String comentario, PersistentSession session);

	/**
	 *
	 * @param email
	 * @param session
	 */
	Utilizador consultarPerfil(String email, PersistentSession session);

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
	boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session);


}