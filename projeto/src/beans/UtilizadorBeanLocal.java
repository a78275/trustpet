package beans;

import main.Review;
import main.Utilizador;
import org.orm.PersistentSession;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

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
	 * @param emailDono
	 * @param emailPetsitter
	 * @param avaliacao
	 * @param comentario
	 * @param alvo
	 */
	boolean avaliarUtilizador(String emailDono, String emailPetsitter, int avaliacao, String comentario, String alvo);

	/**
	 *
	 * @param email
	 * @param tipoUtilizador
	 */
	Utilizador consultarPerfil(String email, String tipoUtilizador);

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
	 * @param concelho
	 * @param distrito
	 * @param ativo
	 */
	boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String concelho, String distrito, boolean ativo);

	/**
	 *
	 * @param email
	 */
	String tipoUtilizador(String email);

	/**
	 *
	 * @param email
	 * @param tipo
	 */
	List<Review> consultarReviews (String email, String tipo);
}