package beans;

import main.Utilizador;
import org.orm.PersistentSession;

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
	 * @param emailDono
	 * @param emailPetsitter
	 * @param avaliacao
	 * @param comentario
	 * @param alvo
	 * @param session
	 */
	boolean avaliarUtilizador(String emailDono, String emailPetsitter, int avaliacao, String comentario, String alvo, PersistentSession session);

	/**
	 *
	 * @param email
	 * @param tipoUtilizador
	 * @param session
	 */
	Utilizador consultarPerfil(String email, String tipoUtilizador, PersistentSession session);

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
	boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, boolean ativo, PersistentSession session);


}