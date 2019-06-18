package beans;

import main.Pedido;
import main.Petsitter;
import org.orm.PersistentSession;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface PedidoBeanLocal {

	/**
	 *
	 * @param emailDono
	 * @param data
	 * @param servicos
	 * @param animais
	 * @param session
	 */
	int registarPedido(String emailDono, Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session);

	/**
	 *
	 * @param emailPetsitter
	 * @param idPedido
	 * @param session
	 */
	boolean concluirPedido(String emailPetsitter, int idPedido, PersistentSession session);

	/**
	 *
	 * @param data
	 * @param servicos
	 * @param animais
	 * @param session
	 */
	List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session);

	/**
	 *
	 * @param idPedido
	 * @param session
	 */
	boolean cancelarPedido(int idPedido, PersistentSession session);

	/**
	 *
	 * @param email
	 * @param session
	 */
	List<Pedido> consultarPedidos(String email, PersistentSession session);
}