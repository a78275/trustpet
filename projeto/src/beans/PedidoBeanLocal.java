package beans;

import main.Pedido;
import main.Petsitter;
import main.Servico;
import main.TipoAnimal;
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
	 * @param session
	 */
	int registarPedido(String emailDono, Date dataInicio, Date dataFim, PersistentSession session);
	/**
	 *
	 * @param emailPetsitter
	 * @param idPedido
	 * @param session
	 */
	boolean concluirPedido(String emailPetsitter, int idPedido, PersistentSession session);

	/**
	 *
	 * @param idPedido
	 * @param animalServicos
	 * @param session
	 */
	List<Petsitter> getPetsittersPedido(int idPedido, Map<Integer, List<Integer>> animalServicos, PersistentSession session);

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

	/**
	 *
	 * @param tiposAnimal
	 * @param session
	 */
	Map<TipoAnimal,List<Servico>> getServicosPedido(List<TipoAnimal> tiposAnimal, PersistentSession session);

	/**
	 *
	 * @param animalServicos
	 * @param session
	 */
	boolean registarServicosPedido(Map<Integer,List<Integer>> animalServicos, PersistentSession session);
}