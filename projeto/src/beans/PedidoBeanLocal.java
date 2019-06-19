package beans;

import main.Pedido;
import main.Petsitter;
import org.orm.PersistentSession;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Local
public interface PedidoBeanLocal {

	/**
	 *
	 * @param emailDono
	 * @param dataInicio
	 * @param dataFim
	 * @param animalServicos
	 * @param session
	 */
	public int registarPedido(String emailDono, Date dataInicio, Date dataFim, Map<Integer, List<Integer>> animalServicos, PersistentSession session);
	/**
	 *
	 * @param emailPetsitter
	 * @param idPedido
	 * @param session
	 */
	boolean concluirPedido(String emailPetsitter, int idPedido, PersistentSession session);

	/**
	 *
	 * @param dataInicio
	 * @param dataFim
	 * @param animalServicos
	 * @param session
	 */
	List<Petsitter> getPetsittersPedido(Date dataInicio, Date dataFim, Map<Integer, List<Integer>> animalServicos, PersistentSession session);

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