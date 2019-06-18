package beans;

import org.orm.PersistentSession;
import trustpet.Pedido;
import trustpet.Petsitter;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface PedidoBeanLocal {

	/**
	 *
	 * @param data
	 * @param servicos
	 * @param animais
	 * @param session
	 */
	int registarPedido(Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session);

	/**
	 *
	 * @param emailPetsitter
	 * @param idPedido
	 * @param session
	 */
	boolean selPetsitter(String emailPetsitter, int idPedido, PersistentSession session);

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