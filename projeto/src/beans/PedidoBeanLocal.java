package beans;

import main.Pedido;
import main.Petsitter;

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
	 */
	int registarPedido(Date data, List<Integer> servicos, List<Integer> animais);

	/**
	 *
	 * @param emailPetsitter
	 * @param idPedido
	 */
	boolean selPetsitter(String emailPetsitter, int idPedido);

	/**
	 *
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais);

	/**
	 *
	 * @param idPedido
	 */
	boolean cancelarPedido(int idPedido);

	/**
	 *
	 * @param email
	 */
	List<Pedido> consultarPedidos(String email);
}